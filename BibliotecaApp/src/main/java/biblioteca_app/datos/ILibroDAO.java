package biblioteca_app.datos;

import biblioteca_app.dominio.Libro;

import java.util.List;

public interface ILibroDAO {

    List<Libro> lista();
    Libro buscarId(Libro libro);
    void insertaLibro(Libro libro);
    void eliminaLibro(Libro libro);
    void actualizaLibro(Libro libro);

}
