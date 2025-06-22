package biblioteca_app.datos;

import biblioteca_app.dominio.Libro;
import biblioteca_app.dominio.Prestamo;
import biblioteca_app.dominio.Usuario;

import java.util.Date;
import java.util.List;

public interface IPrestamoDAO {

    // CRUD basico
    void agregarPrestamo(Prestamo prestamo);
    Prestamo buscarPrestamoPorId(int idPrestamo);
    void actualizarPrestamo(Prestamo prestamo);
    void eliminarPrestamo(int idPrestamo);

    // Listados
    List<Prestamo>listarTodo();
    List<Prestamo>listarPorEstado(String estado);
    List<Prestamo>listarPrestamoDeUsuario(Usuario usuario);
    List<Prestamo>listarPrestamosEnUnaFechaDada(Date fecha);

    // Validaciones
    boolean libroPrestado(Libro libro);
    boolean excedeLimite(Usuario usuario,int limiteMaximo);
    boolean prestamoVencido(Prestamo prestamo);

    // Actualizaciones especificas
    void actualizarIdLibro(int idPrestamo,int nuevoIdLibro);
    void actualizarEstado(int idPrestamo,String nuevoEstado);
    void actualizarIdUsuario(int idPrestamo,int nuevoIdUsuario);
    void actualizarFechaPrestamo(int idPrestamo,Date nuevaFechaPrestamo);
    void actualizarFechaDevolucion(int idPrestamo,Date nuevaFechaDevolucion);
    void actualizarFechaDevolucionReal(int idPrestamo,Date nuevaFechaDevolucionReal);
}
