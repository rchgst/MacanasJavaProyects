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
        String sql = "SELECT * FROM libros ORDER BY id";

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
        String sql = "SELECT * FROM libros WHERE id = ?";
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
        String sql = "INSERT INTO libros(titulo,anio,isbn,categoria) VALUES (?, ?, ?, ?, ?)";

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
        String sql = "DELETE FROM libros WHERE id = ?";

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
        String sql = "UPDATE libros SET titulo = ?, anio = ?, isbn = ?, categoria = ? WHERE id = ?";

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
     *  bsuca un libro por el titulo del mismo
     * @param titulo titulo es el nombre del libro
     * @return retorna el libro encontrado, si no encuentra retorna null
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
     * busca un libro por su isbn
     * @param isbn el isbn del libro
     * @return devuelve el libro si lo encuentra, retorna null en caso contrario
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
     * busca un libro con dos datos el titulo y el isbn
     * @param titulo
     * @param isbn
     * @return retorna el libro si lo encuentra, retorna null si no lo encuentra
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
     * busqueda mas avanzada y especifica
     * @param titulo
     * @param isbn
     * @param autor
     * @return retorna el libro si lo encuentra, en caso contrario devuelve null
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
     * busqueda mas especificas con 4 parametros, asegurando un resultado mas preciso
     * @param titulo
     * @param isbn
     * @param autor
     * @param anio
     * @return si se encuentra el libro lo retorna y si no lo encuentra devuelve null
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
     * busqueda mas especifica de 4 parametros, aseguando un resultado mas preciso
     * @param titulo
     * @param isbn
     * @param autor
     * @param categorria
     * @return devuelve el libro si se encuentra , si no devuelve null
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
     * genera una lista de libros de un mismo autor
     * @param autor
     * @return devuelve la lista generada con todos los libros encontrados
     * si no encuentra libros la lista estara vacia
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
     * devuelve una lista de libros que comparten una misma categoria
     * @param genero
     * @return devuelve la lista con todos los libros que encontro con la misma categoria
     * si no encuentra libros devuelve una lista vacia
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
     * Devuelve todos los libros publicados en un año específico.
     *
     * @param anio el año a buscar
     * @return lista de libros publicados ese año
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
     * Actualiza el título de un libro por su ID.
     *
     * @param id el ID del libro
     * @param titulo el nuevo título
     */
    @Override
    public void actualizarTitulo(int id, String titulo) {
        String sql = "UPDATE libros SET titulo = ? WHERE id = ?";

        try (
                Connection con = ConexionBDD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
        ){
            ps.setString(1,titulo);
            ps.setInt(2,id);

            ps.execute();
        }catch (Exception e){
            System.out.println("error al actualizar el titulo");
        }

    }

    /**
     * Actualiza el ISBN de un libro por su ID.
     *
     * @param id el ID del libro
     * @param isbn el nuevo ISBN
     */
    @Override
    public void actualizarIsbn(int id, String isbn) {
        String sql = "UPDATE libros SET isbn = ? WHERE id = ?";

        try (
                Connection con = ConexionBDD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
        ){
            ps.setString(1,isbn);
            ps.setInt(2,id);

            ps.execute();
        }catch (Exception e){
            System.out.println("error al actualizar el isbn");
        }
    }

    /**
     * Actualiza el autor de un libro por su ID.
     *
     * @param id el ID del libro
     * @param autor el nuevo autor
     */
    @Override
    public void actualizarAutor(int id, Autor autor) {
        String sql = "UPDATE libros SET idAutor = ? WHERE id = ?";

        try (
                Connection con = ConexionBDD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
        ){
            ps.setInt(1,autor.getId());
            ps.setInt(2,id);

            ps.execute();
        }catch (Exception e){
            System.out.println("error al actualizar el autor");
        }
    }

    /**
     * Actualiza la categoría de un libro por su ID.
     *
     * @param id el ID del libro
     * @param categoria la nueva categoría
     */
    @Override
    public void actualizarCategoria(int id, String categoria) {
        String sql = "UPDATE libros SET categoria = ? WHERE id = ?";

        try (
                Connection con = ConexionBDD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
        ){
            ps.setString(1,categoria);
            ps.setInt(2,id);

            ps.execute();
        }catch (Exception e){
            System.out.println("error al actualizar el categoria");
        }
    }

    /**
     * Actualiza el año de publicación de un libro por su ID.
     *
     * @param id el ID del libro
     * @param anio el nuevo año
     */
    @Override
    public void actualizarAnio(int id, int anio) {
        String sql = "UPDATE libros SET anio = ? WHERE id = ?";

        try (
                Connection con = ConexionBDD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
        ){
            ps.setInt(1,anio);
            ps.setInt(2,id);

            ps.execute();
        }catch (Exception e){
            System.out.println("error al actualizar el anio");
        }
    }
}
