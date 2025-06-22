package biblioteca_app.datos;

import biblioteca_app.conexionDB.ConexionBDD;
import biblioteca_app.dominio.Autor;
import biblioteca_app.dominio.Libro;
import com.sun.jdi.request.StepRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class AutorDAO implements IAutorDAO{
    @Override
    public void agregarAutor(Autor autor) {
        String sql = "INSERT INTO autores(nombre, nacionalidad, fechaNacimiento, fechaFallecimiento, biografia)"+
                " VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConexionBDD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);){

            ps.setString(1,autor.getNombre());
            ps.setString(2,autor.getNacionalidad());
            ps.setDate(3,autor.getFecha_nacimiento());
            ps.setDate(4,autor.getFecha_fallecimiento());
            ps.setString(5,autor.getBiografia());

            ps.execute();
        }catch (Exception e){
            System.out.println("error al cargar autor: "+e.getMessage());
        }
    }

    @Override
    public Autor buscarPorId(int idAutor) {
        String sql = "SELECT * FROM autores WHERE id = ?";
        Autor autor = null;

        try (Connection conn = ConexionBDD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
                ){
            ps.setInt(1,idAutor);

            try (ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    autor = new Autor();
                    this.setearCamposAutor(autor,rs);
                }
            }

        }catch (Exception e){
            System.out.println("error al buscar autor por id: "+e.getMessage());
        }
        return autor;
    }

    @Override
    public void actualizarAutor(Autor autor) {
        String sql = "UPDATE autores SET nombre = ?, nacionalidad = ?, fechaNacimiento = ?, fechaFallecimiento = ?, biografia = ? WHERE id = ?";

        try (Connection conn = ConexionBDD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);){

            ps.setString(1,autor.getNombre());
            ps.setString(2,autor.getNacionalidad());
            ps.setDate(3,autor.getFecha_nacimiento());
            ps.setDate(4,autor.getFecha_fallecimiento());
            ps.setString(5,autor.getBiografia());
            ps.setInt(6,autor.getId());

            ps.execute();
        }catch (Exception e){
            System.out.println("error al actualizar los datos del autor: "+e.getMessage());
        }
    }

    public void eliminarAutor(int idAutor) {
        // Primero verifica si tiene libros asociados
        if (this.tieneLibrosAsociados(idAutor)) {
            System.out.println("Error: El autor tiene libros asociados. Elimine los libros primero.");
            return; // Sal del método sin ejecutar el DELETE
        }

        String sql = "DELETE FROM autores WHERE id = ?";

        try (Connection conn = ConexionBDD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idAutor);
            int filasAfectadas = ps.executeUpdate(); // Usa executeUpdate() para DELETE

            if (filasAfectadas > 0) {
                System.out.println("Autor eliminado exitosamente.");
            } else {
                System.out.println("No se encontró el autor con ID: " + idAutor);
            }

        } catch (Exception e) {
            System.out.println("Error al eliminar autor: " + e.getMessage());
        }
    }

    public void setearCamposAutor(Autor autor,ResultSet rs){
        try {
            autor.setId(rs.getInt("id"));
            autor.setNombre(rs.getString("nombre"));
            autor.setNacionalidad(rs.getString("nacionalidad"));
            autor.setFecha_nacimiento(rs.getDate("fechaNacimiento"));
            autor.setFecha_fallecimiento(rs.getDate("fechaFallecimiento"));
            autor.setBiografia(rs.getString("biografia"));
        }catch (Exception e){
            System.out.println("error al modificar autor: "+e.getMessage());
        }
    }

    @Override
    public List<Autor> listarTodo() {
        String sql = "SELECT * FROM autores ORDER BY id";
        List<Autor>autores = new ArrayList<>();

        try (Connection conn = ConexionBDD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();){

            while (rs.next()){
                Autor autor = new Autor();
                this.setearCamposAutor(autor,rs);
                autores.add(autor);
            }

        }catch (Exception e){
            System.out.println("error al crear la lista de autores: "+e.getMessage());
        }

        return autores;
    }

    @Override
    public List<Autor> listarPorNacionalidad(String nacionalidad) {
        String sql = "SELECT * FROM autores WHERE nacionalidad = ?";
        List<Autor>autores = new ArrayList<>();

        try (
             Connection conn = ConexionBDD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
                ){

            ps.setString(1,nacionalidad);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Autor autor = new Autor();
                    this.setearCamposAutor(autor, rs);
                    autores.add(autor);
                }
            }
        }catch (Exception e){
            System.out.println("error al generar lista de autores por nacionalidad: "+e.getMessage());
        }

        return autores;
    }

    @Override
    public List<Autor> buscarAutorPorNombreParcial(String nombreParcial) {
        String sql = "SELECT * FROM autores WHERE nombre LIKE ?";
        List<Autor> autores = new ArrayList<>();

        try (Connection conn = ConexionBDD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + nombreParcial + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Autor autor = new Autor();
                    this.setearCamposAutor(autor, rs);
                    autores.add(autor);
                }
            }
        } catch (Exception e) {
            System.out.println("Error al buscar autores por nombre parcial '" + nombreParcial + "': " + e.getMessage());
        }
        return autores;
    }

    @Override
    public List<Libro> obtenerLibrosDeAutor(int idAutor) {
        String sql = "SELECT l.* FROM libros l JOIN autores a ON l.idAutor = a.id WHERE a.id = ?";
        List<Libro>libros = new ArrayList<>();

        try (
             Connection conn = ConexionBDD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
                ){
            ps.setInt(1,idAutor);

            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    Libro libro = new Libro();
                    LibroDAO.seteaCamposLibro(libro,rs);
                    libros.add(libro);
                }
            }
        }catch (Exception e){
            System.out.println("error al generar lista de libros: "+e.getMessage());
        }
        return libros;
    }

    @Override
    public boolean tieneLibrosAsociados(int idAutor) {
        String sql = "SELECT COUNT(*) FROM libros WHERE autor_id = ?";
        try (
                Connection conn = ConexionBDD.getConexion();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, idAutor);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (Exception e) {
            System.out.println("Error al verificar libros: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean existeAutor(String nombreCompleto) {
        String sql = "SELECT 1 FROM autores WHERE nombre = ? LIMIT 1";

        try (
             Connection conn = ConexionBDD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
                ){
            ps.setString(1,nombreCompleto);

            try (ResultSet rs = ps.executeQuery()){
                if(rs.next())
                    return true;
            }
        }catch (Exception e){
            System.out.println("error al buscar el autor por su nombre: "+e.getMessage());
        }
        return false;
    }

    @Override
    public Autor buscarPorNombre(String nombre) {
        String sql = "SELECT * FROM autores WHERE nombre = ?";
        Autor autor = null;

        try (
             Connection conn = ConexionBDD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
                ){

            ps.setString(1,nombre);

            try (ResultSet rs = ps.executeQuery()){
                if(rs.next()) {
                    autor = new Autor();
                    this.setearCamposAutor(autor, rs);
                }
            }
        }catch (Exception e){
            System.out.println("error al buscar el autor por su nombre: "+e.getMessage());
        }

        return autor;
    }

    @Override
    public void actualizarNombre(int idAutor, String nuevoNombre) {
        String sql = "UPDATE autores SET nombre = ? WHERE id = ?";

        try (
             Connection conn = ConexionBDD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
                ){
            ps.setString(1,nuevoNombre);
            ps.setInt(2,idAutor);
            ps.execute();

        }catch (Exception e){
            System.out.println("error al actualizar el nombre del autor: "+e.getMessage());
        }
    }

    @Override
    public void actualizarBiografia(int idAutor, String nuevaBiografia) {
        String sql = "UPDATE autores SET biografia = ? WHERE id = ?";

        try (
                Connection conn = ConexionBDD.getConexion();
                PreparedStatement ps = conn.prepareStatement(sql);
        ){
            ps.setString(1,nuevaBiografia);
            ps.setInt(2,idAutor);
            ps.execute();

        }catch (Exception e){
            System.out.println("error al actualizar la biografia del autor: "+e.getMessage());
        }
    }

    @Override
    public void actualizarNacionalidad(int idAutor, String muevaNacionalidad) {
        String sql = "UPDATE autores SET nacionalidad = ? WHERE id = ?";

        try (
                Connection conn = ConexionBDD.getConexion();
                PreparedStatement ps = conn.prepareStatement(sql);
        ){
            ps.setString(1,muevaNacionalidad);
            ps.setInt(2,idAutor);
            ps.execute();

        }catch (Exception e){
            System.out.println("error al actualizar la nacionalidad del autor: "+e.getMessage());
        }
    }

    @Override
    public void actualizarFechaNacimiento(int idAutor, Date nuevaFechaNacimiento) {
        String sql = "UPDATE autores SET fechaNacimiento = ? WHERE id = ?";

        try (
                Connection conn = ConexionBDD.getConexion();
                PreparedStatement ps = conn.prepareStatement(sql);
        ){
            ps.setDate(1, new java.sql.Date(nuevaFechaNacimiento.getTime())); // Más seguro
            ps.setInt(2,idAutor);
            ps.execute();

        }catch (Exception e){
            System.out.println("error al actualizar la fecha de nacimiento del autor: "+e.getMessage());
        }
    }

    @Override
    public void actualizarFechaFallecimiento(int idAutor, Date nuevaFechaFallecimiento) {
        String sql = "UPDATE autores SET fechaFallecimiento = ? WHERE id = ?";

        try (
                Connection conn = ConexionBDD.getConexion();
                PreparedStatement ps = conn.prepareStatement(sql);
        ){
            ps.setDate(1, new java.sql.Date(nuevaFechaFallecimiento.getTime()));
            ps.setInt(2,idAutor);
            ps.execute();

        }catch (Exception e){
            System.out.println("error al actualizar la fecha de nacimiento del autor: "+e.getMessage());
        }
    }
}
