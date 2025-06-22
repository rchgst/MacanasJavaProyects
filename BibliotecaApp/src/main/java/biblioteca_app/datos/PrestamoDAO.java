package biblioteca_app.datos;

import biblioteca_app.conexionDB.ConexionBDD;
import biblioteca_app.dominio.Libro;
import biblioteca_app.dominio.Prestamo;
import biblioteca_app.dominio.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PrestamoDAO implements IPrestamoDAO{

    @Override
    public void agregarPrestamo(Prestamo prestamo) {
        String sql = "INSERT INTO prestamos (fechaPrestamo, devolucion_esperada, devolucion_real, estado, idUsuario, idLibro) VALUES (?, ?, ?, ?, ?, ?)";

        try (
                Connection con = ConexionBDD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                ){
            ps.setDate(1,new java.sql.Date(prestamo.getFechaPrestamo().getTime()));
            ps.setDate(2,new java.sql.Date(prestamo.getDevolucion_esperada().getTime()));
            ps.setDate(3,new java.sql.Date(prestamo.getDevolucion_real().getTime()));
            ps.setString(4,prestamo.getEstado());
            ps.setInt(5,prestamo.getIdUsuario());
            ps.setInt(6,prestamo.getIdLibro());

            ps.execute();
        }catch (Exception e){
            System.out.println("error al crear prestamo: "+e.getMessage());
        }
    }

    @Override
    public Prestamo buscarPrestamoPorId(int idPrestamo) {
        String sql = "SELECT * FROM prestamos WHERE id = ?";
        Prestamo prestamo = null;

        try (
                Connection con = ConexionBDD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                ){
            ps.setInt(1,idPrestamo);

            try (ResultSet rs = ps.executeQuery()){
                if(rs.next()) {
                    prestamo = new Prestamo();
                    this.setearValoresPrestamo(prestamo, rs);
                }
                else{
                    System.out.println("no se encontro el prestamo");
                }
            }
        }catch (Exception e){
            System.out.println("error al buscar el usuario: "+e.getMessage());
        }
        return prestamo;
    }

    @Override
    public void actualizarPrestamo(Prestamo prestamo) {
        String sql = "UPDATE prestamos SET fechaPrestamo = ?, devolucion_esperada = ?, devolucion_real = ?, estado = ?, idUsuario = ?, idLibro = ? WHERE id = ?";

        try(
                Connection con = ConexionBDD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                ){
            ps.setDate(1,new java.sql.Date(prestamo.getFechaPrestamo().getTime()));
            ps.setDate(2,new java.sql.Date(prestamo.getDevolucion_esperada().getTime()));
            ps.setDate(3,new java.sql.Date(prestamo.getDevolucion_real().getTime()));
            ps.setString(4,prestamo.getEstado());
            ps.setInt(5,prestamo.getIdUsuario());
            ps.setInt(6,prestamo.getIdLibro());
            ps.setInt(7,prestamo.getId());

            ps.execute();
        }catch (Exception e){
            System.out.println("error al actulizar los datos del prstamo: "+e.getMessage());
        }
    }

    @Override
    public void eliminarPrestamo(int idPrestamo) {
        String sql = "DELETE FROM prestamos WHERE id = ?";

        try (
                Connection con = ConexionBDD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                ){
            ps.setInt(1,idPrestamo);
            ps.execute();
        }catch (Exception e){
            System.out.println("error al eliminar el prestamo: "+e.getMessage());
        }
    }

    private void setearValoresPrestamo(Prestamo prestamo,ResultSet rs){
        try {
            prestamo.setFechaPrestamo(rs.getDate("fechaPrestamo"));
            prestamo.setDevolucion_esperada(rs.getDate("devolucion_esperada"));
            prestamo.setDevolucion_real(rs.getDate("devolucion_real"));
            prestamo.setEstado(rs.getString("estado"));
            prestamo.setIdUsuario(rs.getInt("idUsuario"));
            prestamo.setIdLibro(rs.getInt("idLibro"));
        }catch (Exception e){
            System.out.println("error al setear valores del prestamo");
        }
    }

    @Override
    public List<Prestamo> listarTodo() {
        String sql = "SELECT * FROM prestamos ORDER BY id";
        List<Prestamo>prestamos = new ArrayList<>();

        try (
                Connection con = ConexionBDD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
        ){
            while (rs.next()){
                Prestamo prestamo = new Prestamo();
                this.setearValoresPrestamo(prestamo,rs);
                prestamos.add(prestamo);
            }
        }catch (Exception e){
            System.out.println("error al generar lista de prestamos: "+e.getMessage());
        }
        return prestamos;
    }

    @Override
    public List<Prestamo> listarPorEstado(String estado) {
        String sql = "SELECT * FROM prestamos WHERE estado = ?";
        List<Prestamo>prestamos = new ArrayList<>();

        try (
                Connection con = ConexionBDD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                ){
            ps.setString(1,estado);

            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    Prestamo prestamo = new Prestamo();
                    this.setearValoresPrestamo(prestamo,rs);
                    prestamos.add(prestamo);
                }
            }
        }catch (Exception e){
            System.out.println("error al intentar generar lista de prestamos con el estado dado: "+e.getMessage());
        }
        return prestamos;
    }

    @Override
    public List<Prestamo> listarPrestamoDeUsuario(Usuario usuario) {
        String sql = "SELECT * FROM prestamos WHERE idUsuario = ?";
        List<Prestamo>prestamos = new ArrayList<>();

        try (
                Connection con = ConexionBDD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                ){
            ps.setInt(1,usuario.getId());

            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    Prestamo prestamo = new Prestamo();
                    this.setearValoresPrestamo(prestamo,rs);
                    prestamos.add(prestamo);
                }
            }

        }catch (Exception e){
            System.out.println("error al generar prestamos del usuario: "+e.getMessage());
        }
        return prestamos;
    }

    @Override
    public List<Prestamo> listarPrestamosEnUnaFechaDada(Date fecha) {
        String sql = "SELECT * FROM prestamos WHERE fechaPrestamo = ?";
        List<Prestamo>prestamos = new ArrayList<>();

        try (
                Connection con = ConexionBDD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                ){
            ps.setDate(1,new java.sql.Date(fecha.getTime()));

            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    Prestamo prestamo = new Prestamo();
                    this.setearValoresPrestamo(prestamo,rs);
                    prestamos.add(prestamo);
                }
            }
        }catch (Exception e){
            System.out.println("error al generar los prestamos del dia ingresado: "+e.getMessage());
        }
        return prestamos;
    }

    @Override
    public boolean libroPrestado(Libro libro) {
        String sql = "SELECT 1 FROM prestamos WHERE idLibro = ? LIMIT 1";

        try (
                Connection con = ConexionBDD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                ){
            ps.setInt(1,libro.getId());
            try (ResultSet rs = ps.executeQuery()){
                if(rs.next())
                    return true;
            }
        }catch (Exception e){
            System.out.println("error al buscar si el libro esta prestado: "+e.getMessage());
        }
        return false;
    }

    @Override
    public boolean excedeLimite(Usuario usuario, int limiteMaximo) {
        if (usuario == null || usuario.getId() <= 0) {
            throw new IllegalArgumentException("Usuario no válido");
        }

        String sql = "SELECT COUNT(*) AS total FROM prestamos WHERE idUsuario = ? AND estado = 'ACTIVO'"; // Usamos 'ACTIVO' en lugar de 'prestado' para consistencia

        try (
                Connection con = ConexionBDD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {
            ps.setInt(1, usuario.getId());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int totalPrestamosActivos = rs.getInt("total");
                    return totalPrestamosActivos >= limiteMaximo; // True si excede el límite
                }
            }
        } catch (SQLException e) {
            System.out.println("error al verificar cantidad de prestamos: "+e.getMessage());
        }
        return false;
    }

    @Override
    public boolean prestamoVencido(Prestamo prestamo) {
        if (prestamo == null || prestamo.getDevolucion_esperada() == null) {
            throw new IllegalArgumentException("Préstamo o fecha esperada no pueden ser nulos");
        }

        // Si no se ha devuelto, comparamos con la fecha actual
        if (prestamo.getDevolucion_real() == null) {
            return prestamo.getDevolucion_esperada().before(new Date()); // ¿La fecha esperada ya pasó?
        }

        // Si ya se devolvió, verificamos si fue después de lo esperado
        return prestamo.getDevolucion_esperada().before(prestamo.getDevolucion_real());
    }

    @Override
    public void actualizarIdLibro(int idPrestamo,int nuevoIdLibro) {
        String sql = "UPDATE prestamos SET idLibro = ? WHERE id = ?";

        try(
                Connection con = ConexionBDD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                ){
            ps.setInt(1,nuevoIdLibro);
            ps.setInt(2,idPrestamo);
            ps.execute();
        }catch (Exception e){
            System.out.println("error al actualizar el id del libro: "+e.getMessage());
        }
    }

    @Override
    public void actualizarEstado(int idPrestamo,String nuevoEstado) {
        String sql = "UPDATE prestamos SET estado = ? WHERE id = ?";

        try(
                Connection con = ConexionBDD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
        ){
            ps.setString(1,nuevoEstado);
            ps.setInt(2,idPrestamo);
            ps.execute();
        }catch (Exception e){
            System.out.println("error al actualizar el estado del libro: "+e.getMessage());
        }
    }

    @Override
    public void actualizarIdUsuario(int idPrestamo,int nuevoIdUsuario) {
        String sql = "UPDATE prestamos SET idUsuario = ? WHERE id = ?";

        try(
                Connection con = ConexionBDD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
        ){
            ps.setInt(1,nuevoIdUsuario);
            ps.setInt(2,idPrestamo);
            ps.execute();
        }catch (Exception e){
            System.out.println("error al actualizar el id del usuario: "+e.getMessage());
        }
    }

    @Override
    public void actualizarFechaPrestamo(int idPrestamo,Date nuevaFechaPrestamo) {
        String sql = "UPDATE prestamos SET fechaPrestamo = ? WHERE id = ?";

        try(
                Connection con = ConexionBDD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
        ){
            ps.setDate(1,new java.sql.Date(nuevaFechaPrestamo.getTime()));
            ps.setInt(2,idPrestamo);
            ps.execute();
        }catch (Exception e){
            System.out.println("error al actualizar la fecha del prestamo: "+e.getMessage());
        }
    }

    @Override
    public void actualizarFechaDevolucion(int idPrestamo,Date nuevaFechaDevolucion) {
        String sql = "UPDATE prestamos SET devolucion_esperada = ? WHERE id = ?";

        try(
                Connection con = ConexionBDD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
        ){
            ps.setDate(1,new java.sql.Date(nuevaFechaDevolucion.getTime()));
            ps.setInt(2,idPrestamo);
            ps.execute();
        }catch (Exception e){
            System.out.println("error al actualizar la fecha de devolucion del prestamo: "+e.getMessage());
        }
    }

    @Override
    public void actualizarFechaDevolucionReal(int idPrestamo,Date nuevaFechaDevolucionReal) {
        String sql = "UPDATE prestamos SET devolucion_real = ? WHERE id = ?";

        try(
                Connection con = ConexionBDD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
        ){
            ps.setDate(1,new java.sql.Date(nuevaFechaDevolucionReal.getTime()));
            ps.setInt(2,idPrestamo);
            ps.execute();
        }catch (Exception e){
            System.out.println("error al actualizar la fecha real de devolucion del prestamo: "+e.getMessage());
        }
    }
}
