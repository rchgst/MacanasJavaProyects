package biblioteca_app.datos;

import biblioteca_app.conexionDB.ConexionBDD;
import biblioteca_app.dominio.Autor;
import biblioteca_app.dominio.Libro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO implements ILibroDAO{

    public static void seteaCamposLibro(Libro libro,ResultSet rs){
        try {
            libro.setId(rs.getInt("id"));
            libro.setTitulo(rs.getString("titulo"));
            libro.setAnio(rs.getInt("anio"));
            libro.setIsbn(rs.getString("isbn"));
            libro.setCategoria(rs.getString("categoria"));
        }catch (Exception e){
            System.out.println("error al modificar valores del libro: "+e.getMessage());
        }
    }

    @Override
    public List<Libro> lista() {
        List<Libro>libros = new ArrayList<>();
        String sql = "SELECT * FROM libro ORDER BY id";

        try(
                Connection conn = ConexionBDD.getConexion();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
        ) {

            while (rs.next()){
                Libro libro = new Libro();
                seteaCamposLibro(libro,rs);
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
                Connection conn = ConexionBDD.getConexion();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, libro.getId());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    libroRet = new Libro();
                    seteaCamposLibro(libroRet,rs);
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return libroRet;
    }

    @Override
    public void insertaLibro(Libro libro) {
        String sql = "INSERT INTO libro(titulo,anio,isbn,categoria) VALUES (?, ?, ?, ?, ?)";

        try (
                Connection conn = ConexionBDD.getConexion();
                PreparedStatement ps = conn.prepareStatement(sql);
        ){
            ps.setString(1,libro.getTitulo());
            ps.setInt(2,libro.getAnio());
            ps.setString(3,libro.getIsbn());
            ps.setString(4,libro.getCategoria());
            ps.execute();
        }catch (Exception e){
            System.out.println("error: "+e.getMessage());
        }
    }

    @Override
    public void eliminaLibro(Libro libro) {
        String sql = "DELETE FROM libro WHERE id = ?";

        try (
                Connection conn = ConexionBDD.getConexion();
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
        String sql = "UPDATE libro SET titulo = ?, anio = ?, isbn = ?, categoria = ? WHERE id = ?";

        try (
                Connection conn = ConexionBDD.getConexion();
                PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setString(1, libro.getTitulo());
            ps.setInt(2, libro.getAnio());
            ps.setString(3, libro.getIsbn());
            ps.setString(4,libro.getCategoria());
            ps.setInt(5, libro.getId());
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("error al actualizar libro: " + e.getMessage());
        }
    }

    /**
     * @param titulo
     * @return
     */
    @Override
    public Libro buscarPorTitulo(String titulo) {
        String sql = "SELECT * FROM libros WHERE titulo = ?";
        Libro libro = null;

        try (
                Connection con = ConexionBDD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                ){
            ps.setString(1,titulo);

            try (ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    libro = new Libro();
                    seteaCamposLibro(libro,rs);
                }
            }
        }catch (Exception e){
            System.out.println("error al buscar el libro con el titulo");
        }

        return libro;
    }

    /**
     * @param isbn
     * @return
     */
    @Override
    public Libro buscarPorIsbn(String isbn) {
        String sql = "SELECT * FROM libros WHERE isbn = ?";
        Libro libro = null;

        try (
                Connection con = ConexionBDD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
        ){
            ps.setString(1,isbn);

            try (ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    libro = new Libro();
                    seteaCamposLibro(libro,rs);
                }
            }
        }catch (Exception e){
            System.out.println("error al buscar el libro con el isbn");
        }

        return libro;
    }

    /**
     * @param titulo
     * @param isbn
     * @return
     */
    @Override
    public Libro buscar(String titulo, String isbn) {
        String sql = "SELECT * FROM libros WHERE isbn = ? AND titulo = ?";
        Libro libro = null;

        try (
                Connection con = ConexionBDD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
        ){
            ps.setString(1,isbn);
            ps.setString(2,titulo);

            try (ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    libro = new Libro();
                    seteaCamposLibro(libro,rs);
                }
            }
        }catch (Exception e){
            System.out.println("error al buscar el libro");
        }

        return libro;
    }

    /**
     * @param titulo
     * @param isbn
     * @param autor
     * @return
     */
    @Override
    public Libro buscar(String titulo, String isbn, Autor autor) {
        String sql = "SELECT * FROM libros WHERE isbn = ? AND titulo = ? AND idAutor = ?";
        Libro libro = null;

        try (
                Connection con = ConexionBDD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
        ){
            ps.setString(1,isbn);
            ps.setString(2,titulo);
            ps.setInt(3,autor.getId());

            try (ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    libro = new Libro();
                    seteaCamposLibro(libro,rs);
                }
            }
        }catch (Exception e){
            System.out.println("error al buscar el libro");
        }

        return libro;
    }

    /**
     * @param titulo
     * @param isbn
     * @param autor
     * @param anio
     * @return
     */
    @Override
    public Libro buscar(String titulo, String isbn, Autor autor, int anio) {
        String sql = "SELECT * FROM libros WHERE isbn = ? AND titulo = ? AND idAutor = ? AND anio = ?";
        Libro libro = null;

        try (
                Connection con = ConexionBDD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
        ){
            ps.setString(1,isbn);
            ps.setString(2,titulo);
            ps.setInt(3,autor.getId());
            ps.setInt(4,anio);

            try (ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    libro = new Libro();
                    seteaCamposLibro(libro,rs);
                }
            }
        }catch (Exception e){
            System.out.println("error al buscar el libro");
        }

        return libro;
    }

    /**
     * @param titulo
     * @param isbn
     * @param autor
     * @param categorria
     * @return
     */
    @Override
    public Libro buscar(String titulo, String isbn, Autor autor, String categorria) {
        String sql = "SELECT * FROM libros WHERE isbn = ? AND titulo = ? AND idAutor = ? AND categoria = ?";
        Libro libro = null;

        try (
                Connection con = ConexionBDD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
        ){
            ps.setString(1,isbn);
            ps.setString(2,titulo);
            ps.setInt(3,autor.getId());
            ps.setString(4,categorria);

            try (ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    libro = new Libro();
                    seteaCamposLibro(libro,rs);
                }
            }
        }catch (Exception e){
            System.out.println("error al buscar el libro");
        }

        return libro;
    }

    /**
     * @param autor
     * @return
     */
    @Override
    public List<Libro> librosDeAutor(Autor autor) {
        String sql = "SELECT * FROM libros WHERE idAutor = ?";
        List<Libro>libros = new ArrayList<>();
        try (
                Connection con = ConexionBDD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                ){
            ps.setInt(1,autor.getId());

            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    Libro libro = new Libro();
                    seteaCamposLibro(libro,rs);
                    libros.add(libro);
                }
            }
        }catch (Exception e){
            System.out.println("error al generar lista de libros de un autor");
        }
        return libros;
    }

    /**
     * @param genero
     * @return
     */
    @Override
    public List<Libro> librosPorGenero(String genero) {
        String sql = "SELECT * FROM libros WHERE categoria = ?";
        List<Libro>libros = new ArrayList<>();

        try (
                Connection con = ConexionBDD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                ){
            ps.setString(1,genero);

            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    Libro libro = new Libro();
                    seteaCamposLibro(libro,rs);
                    libros.add(libro);
                }
            }
        }catch (Exception e){
            System.out.println("error al generar lista de una misma categoria");
        }
        return libros;
    }

    /**
     * @param anio
     * @return
     */
    @Override
    public List<Libro> librosEnUnAnio(int anio) {
        String sql = "SELECT * FROM libros WHERE anio = ?";
        List<Libro>libros = new ArrayList<>();

        try (
                Connection con = ConexionBDD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                ){
            ps.setInt(1,anio);

            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    Libro libro = new Libro();
                    seteaCamposLibro(libro,rs);
                    libros.add(libro);
                }
            }
        }catch (Exception e){
            System.out.println("error al generar lista de libros en el año");
        }
        return libros;
    }

    /**
     * @param id
     * @param titulo
     */
    @Override
    public void actualizarTitulo(int id, String titulo) {

    }

    /**
     * @param id
     * @param isbn
     */
    @Override
    public void actualizarIsbn(int id, String isbn) {

    }

    /**
     * @param id
     * @param autor
     */
    @Override
    public void actualizarAutor(int id, Autor autor) {

    }

    /**
     * @param id
     * @param categoria
     */
    @Override
    public void actualizarCategoria(int id, String categoria) {

    }

    /**
     * @param id
     * @param anio
     */
    @Override
    public void actualizarAnio(int id, int anio) {

    }
}

