package org.aplication.models;

import org.aplication.domain.Tarea;

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
    boolean existe(Tarea tarea);

    // Actualizaciones utiles
    void actualizarDescripcion(String nuevaDescripcion);
    void actualizarFechaCreacion(LocalDate nuevaFecha);
    void actualizarFechaLimite(LocalDate nuevaFecha);
    void actualizarPrioridad(String nuevaPrioridad);
    void actualizarEstado(String nuevoEstado);

    // conteos utiles
    int cantidadDeTareas();
    int cantidadPorPrioridad(String prioridad);
    int cantidadPorEstado(String estado);
}
