package aplication.models;

import aplication.domain.Tarea;

import java.time.LocalDate;
import java.util.List;

public interface ITareaDAO {

    // Crud basico
    void crearTarea(Tarea tarea);
    Tarea buscarTareaPorId(int id);
    void actualizarTarea(Tarea tarea);
    void eliminarTarea(int id);

    // Listas
    List<Tarea> listarPorPrioridad(String prioridad);
    List<Tarea> listarPorFecha(LocalDate fecha);
    List<Tarea> listarEntreDosFechas(LocalDate desde,LocalDate hasta);
    List<Tarea> listarPorEstado(String estado);
    List<Tarea> listarVencidas();

    // Validaciones
    boolean existe(int id);

    // Actualizaciones utiles
    void actualizarDescripcion(int iodTarea,String nuevaDescripcion);
    void actualizarFechaCreacion(int iodTarea,LocalDate nuevaFecha);
    void actualizarFechaLimite(int iodTarea,LocalDate nuevaFecha);
    void actualizarPrioridad(int iodTarea,String nuevaPrioridad);
    void actualizarEstado(int iodTarea,String nuevoEstado);

    // conteos utiles
    int cantidadDeTareas();
    int cantidadPorPrioridad(String prioridad);
    int cantidadPorEstado(String estado);
}
