package aplication.models;

import aplication.db.Conexion;
import aplication.domain.Tarea;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TareaDAO implements ITareaDAO{

    /**
     * crea una nueva tarea y la agrega en la base de datos
     * @param tarea la terea que queremos agregar
     */
    @Override
    public void crearTarea(Tarea tarea) {
        String sql = "INSERT INTO tareas(descripcion, fechaCreacion, fechaLimite, prioridad, estado) VALUES (?, ?, ?, ?, ?)";

        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                ){
            java.sql.Date fechaCreacion = java.sql.Date.valueOf(tarea.getFechaCreacion());
            java.sql.Date fechaLimite = java.sql.Date.valueOf(tarea.getFechaLimite());

            ps.setString(1,tarea.getDescripcion());
            ps.setDate(2,fechaCreacion);
            ps.setDate(3,fechaLimite);
            ps.setString(4,tarea.getPrioridad());
            ps.setString(5,tarea.getEstado());

            ps.execute();
        }catch (Exception e){
            System.out.println("error al crear tarea: "+e.getMessage());
        }
    }

    /**
     * para evitar repeticion de codigo
     * setea los campos de la Tarea con los resultados obtenidos de la base de datos
     * @param tarea tarea a la que queremos actualizar datos
     * @param rs resultado obtenido de una consulta sql
    */

    private void seteaCamposTarea(Tarea tarea,ResultSet rs){
        try {
            LocalDate fechaCreacion = rs.getDate("fechaCreacion").toLocalDate();
            LocalDate fechaLimite = rs.getDate("fechaLimite").toLocalDate();

            tarea.setId(rs.getInt("id"));
            tarea.setDescripcion(rs.getString("descripcion"));
            tarea.setFechaCreacion(fechaCreacion);
            tarea.setFechaLimite(fechaLimite);
            tarea.setPrioridad(rs.getString("prioridad"));
            tarea.setEstado(rs.getString("estado"));
        }catch (Exception e){
            System.out.println("error al setear campos: "+e.getMessage());
        }
    }

    /**
     * busca una tarea en la base de datos con el campo id
     * si la encuentra retorna la tarea
     * si no la encuentra retorna null
     * @param id
     * @return tarea o null
     */
    @Override
    public Tarea buscarTareaPorId(int id) {
        String sql = "SELECT * FROM tareas WHERE id = ?";
        Tarea tarea = null;
        try(
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                ){
            ps.setInt(1,id);
            try (ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    tarea = new Tarea();
                    this.seteaCamposTarea(tarea,rs);
                }
            }
        }catch (Exception e){
            System.out.println("error al buscar tarea por id: "+e.getMessage());
        }

        return tarea;
    }

    /**
     * actualiza todos los campos de una tarea ya existente
     * @param tarea
     */
    @Override
    public void actualizarTarea(Tarea tarea) {
        String sql = "UPDATE tareas SET descripcion = ?, fechaCreacion = ?, fechaLimite = ?, prioridad = ?, estado = ? WHERE id = ?";

        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                ){
            java.sql.Date fechaCreacion = java.sql.Date.valueOf(tarea.getFechaCreacion());
            java.sql.Date fechaLimite = java.sql.Date.valueOf(tarea.getFechaLimite());

            ps.setString(1,tarea.getDescripcion());
            ps.setDate(2,fechaCreacion);
            ps.setDate(3,fechaLimite);
            ps.setString(4,tarea.getPrioridad());
            ps.setString(5,tarea.getEstado());
            ps.setInt(6,tarea.getId());

            ps.executeUpdate();
        }catch (Exception e){
            System.out.println("error al actualizar los datos de una tarea: "+e.getMessage());
        }
    }

    /**
     * dado un id elimina la tarea en la base de datos
     * @param id
     */
    @Override
    public void eliminarTarea(int id) {
        String sql = "DELETE FROM tareas WHERE id = ?";

        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                ){
            ps.setInt(1,id);
            ps.executeUpdate();
        }catch (Exception e){
            System.out.println("error al eliminar tarea: "+e.getMessage());
        }
    }

    /**
     * carga una lista de tareas con las tareas que indica la consulta sql
     * @param tareas una lista de tareas vacia
     * @param ps una consulta sql que idnica que tipo de tareas guardara la lista
     */
    private void cargaLista(List<Tarea>tareas,PreparedStatement ps){
        try (ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                Tarea tarea = new Tarea();
                this.seteaCamposTarea(tarea,rs);
                tareas.add(tarea);
            }
        }catch (Exception e){
            System.out.println("error al cargar la lista con tareas: "+e.getMessage());
        }
    }

    /**
     * lista todas las tareas de una fecha dada
     * @param fecha
     * @return retorna una lista de tareas, en caso de no encontrar tareas retorna una lista vacia
     */
    @Override
    public List<Tarea> listarPorFecha(LocalDate fecha) {
        String sql = "SELECT * FROM tareas WHERE fecha = ?";
        List<Tarea> tareas = new ArrayList<>();

        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                ){
            java.sql.Date fechaSql = java.sql.Date.valueOf(fecha);
            ps.setDate(1,fechaSql);

            this.cargaLista(tareas,ps);

        }catch (Exception e){
            System.out.println("error al generar lista de tareas: "+e.getMessage());
        }
        return tareas;
    }

    /**
     * lista todas las tareas con la misma prioridad
     * @param prioridad
     * @return
     */
    @Override
    public List<Tarea> listarPorPrioridad(String prioridad) {
        String sql = "SELECT * FROM tareas WHERE prioridad = ?";
        List<Tarea>tareas = new ArrayList<>();

        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                ){
            ps.setString(1,prioridad);
            this.cargaLista(tareas,ps);
        }catch (Exception e){
            System.out.println("error al generar lista de prioridades");
        }
        return tareas;
    }

    /**
     * genera una lista con las tareas que esten entre dos fechas
     * @param desde primera fecha del intervalo
     * @param hasta segunda fecha del intervalo
     * @return devuelve una lista de tareas
     */
    @Override
    public List<Tarea> listarEntreDosFechas(LocalDate desde, LocalDate hasta) {
        String sql = "SELECT * FROM tareas WHERE fechaCreacion BETWEEN ? AND ? ORDER BY fechaCreacion";
        List<Tarea>tareas = new ArrayList<>();

        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                ){

            ps.setDate(1,java.sql.Date.valueOf(desde));
            ps.setDate(2,java.sql.Date.valueOf(hasta));
            this.cargaLista(tareas,ps);

        }catch (Exception e){
            System.out.println("error al generar lista entre dos fechas: "+e.getMessage());
        }

        return tareas;
    }

    /**
     * genera una lista con todas las tareas que tenganm el mismo estado
     * @param estado (pendiente, iniciado, finalizado)
     * @return devuelve una lista de tareas o una lista vacia en caso de que ninguno cumpla
     */
    @Override
    public List<Tarea> listarPorEstado(String estado) {
        String sql = "SELECT * FROM tareas WHERE estado = ?";
        List<Tarea>tareas = new ArrayList<>();

        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                ){
            ps.setString(1,estado);
            this.cargaLista(tareas,ps);
        }catch (Exception e){
            System.out.println("error al generar lista de tareas con un mismo estado: "+e.getMessage());
        }

        return tareas;
    }

    /**
     * genera una lista de tareas cuya fecha limite ya fue superada
     * @return devuelve una lista vacia o una lista con uno o mas tareas
     */
    @Override
    public List<Tarea> listarVencidas() {
        String sql = "SELECT * FROM tareas WHERE fechaLimite < ? AND estado IN ('Pendiente', 'iniciado')";
        List<Tarea>tareas = new ArrayList<>();

        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                ){
            ps.setDate(1,java.sql.Date.valueOf(LocalDate.now()));
            this.cargaLista(tareas,ps);
        }catch (Exception e){
            System.out.println("error al generar lista de tareas vencidas: "+e.getMessage());
        }

        return tareas;
    }

    /**
     * valida si una tarea se encuentra en la base de datos
     * @param tarea
     * @return devuelve true si existe, false si no
     */
    @Override
    public boolean existe(int id) {
        String sql = "SELECT 1 FROM tareas WHERE id = ? LIMIT = 1";

        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                ){

            ps.setInt(1,id);
            try (ResultSet rs = ps.executeQuery()){
                if(rs.next())
                    return true;
            }
        }catch (Exception e){
            System.out.println("error al validar si la tarea existe");
        }

        return false;
    }

    /**
     * actualiza la descripcion de una tarea
     * @param nuevaDescripcion
     */
    @Override
    public void actualizarDescripcion(int iodTarea,String nuevaDescripcion) {
        String sql = "UPDATE tareas SET descripcion = ? WHERE id = ?";

        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                ){
            ps.setString(1,nuevaDescripcion);
            ps.setInt(1,iodTarea);

            ps.executeUpdate();
        }catch (Exception e){
            System.out.println("error al actualizar la descripcion");
        }
    }

    /**
     * @param nuevaFecha
     */
    @Override
    public void actualizarFechaCreacion(int iodTarea,LocalDate nuevaFecha) {
        String sql = "UPDATE tareas SET fechaCreacion = ? WHERE id = ?";

        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
        ){
            ps.setDate(1,java.sql.Date.valueOf(nuevaFecha));
            ps.setInt(1,iodTarea);

            ps.executeUpdate();
        }catch (Exception e){
            System.out.println("error al actualizar la fecha de creación");
        }
    }

    /**
     * @param nuevaFecha
     */
    @Override
    public void actualizarFechaLimite(int iodTarea,LocalDate nuevaFecha) {
        String sql = "UPDATE tareas SET fechaLimite = ? WHERE id = ?";

        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
        ){
            ps.setDate(1,java.sql.Date.valueOf(nuevaFecha));
            ps.setInt(1,iodTarea);

            ps.executeUpdate();
        }catch (Exception e){
            System.out.println("error al actualizar la fecha de creación");
        }
    }

    /**
     * @param nuevaPrioridad
     */
    @Override
    public void actualizarPrioridad(int iodTarea,String nuevaPrioridad) {
        String sql = "UPDATE tareas SET prioridad = ? WHERE id = ?";

        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
        ){
            ps.setString(1,nuevaPrioridad);
            ps.setInt(1,iodTarea);

            ps.executeUpdate();
        }catch (Exception e){
            System.out.println("error al actualizar la prioridad");
        }
    }

    /**
     * @param nuevoEstado
     */
    @Override
    public void actualizarEstado(int iodTarea,String nuevoEstado) {
        String sql = "UPDATE tareas SET estado = ? WHERE id = ?";

        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
        ){
            ps.setString(1,nuevoEstado);
            ps.setInt(1,iodTarea);

            ps.executeUpdate();
        }catch (Exception e){
            System.out.println("error al actualizar el estado");
        }
    }

    /**
     * Devuelve la cantidad total de tareas registradas en la base de datos.
     * @return Cantidad de tareas (0 si no hay registros o hay error)
     */
    @Override
    public int cantidadDeTareas() {
        String sql = "SELECT COUNT(*) AS total FROM tareas";
        int cantidad = 0;

        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
        ) {
            if (rs.next()) {
                cantidad = rs.getInt("total");
            }
        } catch (SQLException e) {
            System.err.println("Error al contar tareas: " + e.getMessage());
        }

        return cantidad;
    }

    /**
     * devuelve la cantidad de tareas con la misma prioridad
     * @param prioridad
     * @return 0 o la cantidad de tareas que cumplen
     */
    @Override
    public int cantidadPorPrioridad(String prioridad) {
        String sql = "SELECT COUNT(*) AS total FROM tareas WHERE prioridad = ?";
        int cantidad = 0;

        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                ){
            ps.setString(1,prioridad);

            try (ResultSet rs = ps.executeQuery()){
                if(rs.next())
                    cantidad = rs.getInt("total");
            }
        }catch (Exception e){
            System.out.println("error al contar tareas por prioridad");
        }
        return cantidad;
    }

    /**
     * devuelve la cantidad de tareas con un mismo estado
     * @param estado
     * @return 0 o la cantidad de tareas que cumplen
     */
    @Override
    public int cantidadPorEstado(String estado) {
        String sql = "SELECT COUNT(*) AS total FROM tareas WHERE estado = ?";
        int cantidad = 0;
        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
        ){
            ps.setString(1,estado);

            try (ResultSet rs = ps.executeQuery()){
                if(rs.next())
                    cantidad = rs.getInt("total");
            }
        }catch (Exception e){
            System.out.println("error al contar tareas por estado");
        }
        return cantidad;
    }
}
