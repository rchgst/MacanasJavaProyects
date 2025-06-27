package biblioteca_app.datos;

import biblioteca_app.dominio.Autor;
import biblioteca_app.dominio.Libro;

import java.util.List;

public interface ILibroDAO {

    List<Libro> lista();
    Libro buscarId(Libro libro);
    void insertaLibro(Libro libro);
    void eliminaLibro(Libro libro);
    void actualizaLibro(Libro libro);

    // busqudas utiles
    Libro buscarPorTitulo(String titulo);
    Libro buscarPorIsbn(String isbn);

    // mas especificas
    Libro buscar(String titulo,String isbn);
    Libro buscar(String titulo,String isbn,Autor autor);
    Libro buscar(String titulo,String isbn,Autor autor,int anio);
    Libro buscar(String titulo,String isbn,Autor autor,String categorria);


    // listados
    List<Libro> librosDeAutor(Autor autor);
    List<Libro> librosPorGenero(String genero);
    List<Libro> librosEnUnAnio(int anio);

    // actualizacion de datos mas utiles
    void actualizarTitulo(int id,String titulo);
    void actualizarIsbn(int id,String isbn);
    void actualizarAutor(int id,Autor autor);
    void actualizarCategoria(int id,String categoria);
    void actualizarAnio(int id,int anio);
}
