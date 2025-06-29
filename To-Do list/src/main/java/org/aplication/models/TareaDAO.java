package org.aplication.models;

import org.aplication.db.Conexion;
import org.aplication.domain.Tarea;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
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
     * @param id
     * @return
     */
    @Override
    public Tarea buscarTareaPorId(int id) {
        return null;
    }

    /**
     * @param tarea
     */
    @Override
    public void actualizarTarea(Tarea tarea) {

    }

    /**
     * @param id
     */
    @Override
    public void eliminarTarea(int id) {

    }

    /**
     * @param prioridad
     * @return
     */
    @Override
    public List<Tarea> listarPorPrioridad(String prioridad) {
        return List.of();
    }

    /**
     * @param fecha
     * @return
     */
    @Override
    public List<Tarea> listarPorFecha(LocalDate fecha) {
        return List.of();
    }

    /**
     * @param desde
     * @param hasta
     * @return
     */
    @Override
    public List<Tarea> listarEntreDosFechas(LocalDate desde, LocalDate hasta) {
        return List.of();
    }

    /**
     * @param estado
     * @return
     */
    @Override
    public List<Tarea> listarPorEstado(String estado) {
        return List.of();
    }

    /**
     * @return
     */
    @Override
    public List<Tarea> listarVencidas() {
        return List.of();
    }

    /**
     * @param tarea
     * @return
     */
    @Override
    public boolean existe(Tarea tarea) {
        return false;
    }

    /**
     * @param nuevaDescripcion
     */
    @Override
    public void actualizarDescripcion(String nuevaDescripcion) {

    }

    /**
     * @param nuevaFecha
     */
    @Override
    public void actualizarFechaCreacion(LocalDate nuevaFecha) {

    }

    /**
     * @param nuevaFecha
     */
    @Override
    public void actualizarFechaLimite(LocalDate nuevaFecha) {

    }

    /**
     * @param nuevaPrioridad
     */
    @Override
    public void actualizarPrioridad(String nuevaPrioridad) {

    }

    /**
     * @param nuevoEstado
     */
    @Override
    public void actualizarEstado(String nuevoEstado) {

    }

    /**
     * @return
     */
    @Override
    public int cantidadDeTareas() {
        return 0;
    }

    /**
     * @param prioridad
     * @return
     */
    @Override
    public int cantidadPorPrioridad(String prioridad) {
        return 0;
    }

    /**
     * @param estado
     * @return
     */
    @Override
    public int cantidadPorEstado(String estado) {
        return 0;
    }
}
