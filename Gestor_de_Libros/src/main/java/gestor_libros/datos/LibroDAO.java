package gestor_libros.datos;

import gestor_libros.conexion.ConexionDB;
import gestor_libros.dominio.Libro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO implements ILibroDAO{

    @Override
    public List<Libro> lista() {
        List<Libro>libros = new ArrayList<>();
        String sql = "SELECT * FROM libro ORDER BY id";

        try(
            Connection conn = ConexionDB.getConexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ) {

            while (rs.next()){
                Libro libro = new Libro();
                libro.setId(rs.getInt("id"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutor(rs.getString("autor"));
                libro.setAnio(rs.getInt("anio"));
                libro.setIsbn(rs.getString("isbn"));

                libros.add(libro);
            }
        }catch (Exception e){
            System.out.println(" error: "+e.getMessage());
        }

        return libros;
    }

    @Override
    public Libro buscarId(Libro libro) {
        String sql = "SELECT * FROM libro WHERE id = ?";
        Libro libroRet = null;

        try (
                Connection conn = ConexionDB.getConexion();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, libro.getId());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    libroRet = new Libro();
                    libroRet.setId(rs.getInt("id"));
                    libroRet.setTitulo(rs.getString("titulo"));
                    libroRet.setAutor(rs.getString("autor"));
                    libroRet.setAnio(rs.getInt("anio"));
                    libroRet.setIsbn(rs.getString("isbn"));
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return libroRet;
    }

    @Override
    public void insertaLibro(Libro libro) {
        String sql = "INSERT INTO libro(titulo,autor,anio,isbn) VALUES (?, ?, ?, ?)";

        try (
             Connection conn = ConexionDB.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
        ){
            ps.setString(1,libro.getTitulo());
            ps.setString(2,libro.getAutor());
            ps.setInt(3,libro.getAnio());
            ps.setString(4,libro.getIsbn());
            ps.execute();
        }catch (Exception e){
            System.out.println("error: "+e.getMessage());
        }
    }

    @Override
    public void eliminaLibro(Libro libro) {
        String sql = "DELETE FROM libro WHERE id = ?";

        try (
             Connection conn = ConexionDB.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
        ){
            ps.setInt(1,libro.getId());
            ps.executeUpdate();

        }catch (Exception e){
            System.out.println("error al eliminar libro: "+e.getMessage());
        }
    }

    @Override
    public void actualizaLibro(Libro libro) {
        String sql = "UPDATE libro SET titulo = ?, autor = ?, anio = ?, isbn = ? WHERE id = ?";

        try (
                Connection conn = ConexionDB.getConexion();
                PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getAutor());
            ps.setInt(3, libro.getAnio());
            ps.setString(4, libro.getIsbn());
            ps.setInt(5, libro.getId());
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("error al actualizar libro: " + e.getMessage());
        }
    }
}
