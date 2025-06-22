package biblioteca_app.datos;

import biblioteca_app.dominio.Autor;
import biblioteca_app.dominio.Libro;

import java.util.Date;
import java.util.List;

public interface IAutorDAO {

    // Crud basico
    void agregarAutor(Autor autor);
    Autor buscarPorId(int idAutor);
    void actualizarAutor(Autor autor);
    void eliminarAutor(int idAutor);

    // Listaciones caracterizadas
    List<Autor> listarTodo();
    List<Autor> listarPorNacionalidad(String nacionalidad);
    List<Autor> buscarAutorPorNombreParcial(String nombreParcial);

    // Relaciones con libros
    List<Libro> obtenerLibrosDeAutor(int idAutor);
    boolean tieneLibrosAsociados(int idAutor);

    // Validaciones
    boolean existeAutor(String nombreCompleto);

    // Buscas especificas
    Autor buscarPorNombre(String nombre);

    // Actualizaciones especificas
    void actualizarNombre(int idAutor,String nuevoNombre);
    void actualizarBiografia(int idAutor,String nuevaBiografia);
    void actualizarNacionalidad(int idAutor,String muevaNacionalidad);
    void actualizarFechaNacimiento(int idAutor, Date nuevaFechaNacimiento);
    void actualizarFechaFallecimiento(int idAutor, Date nuevaFechaFallecimiento);

}
