package org.aplication.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Tarea {
    int id;
    private String descripcion;
    private LocalDate fechaCreacion;
    private LocalDate fechaLimite;
    private String prioridad;
    private String estado;

    public Tarea(String descripcion, LocalDate fechaCreacion, LocalDate fechaLimite, String prioridad, String estado) {
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaLimite = fechaLimite;
        this.prioridad = prioridad;
        this.estado = estado;
    }

    public Tarea(int id, String descripcion, LocalDate fechaCreacion, LocalDate fechaLimite, String prioridad, String estado) {
        this(descripcion,fechaCreacion,fechaLimite,prioridad,estado);
        this.id = id;
    }

    public Tarea(int id) {
        this.id = id;
    }

    public Tarea(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDate getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(LocalDate fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Tarea tarea = (Tarea) o;
        return id == tarea.id && Objects.equals(descripcion, tarea.descripcion) && Objects.equals(fechaCreacion, tarea.fechaCreacion) && Objects.equals(fechaLimite, tarea.fechaLimite) && Objects.equals(prioridad, tarea.prioridad) && Objects.equals(estado, tarea.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descripcion, fechaCreacion, fechaLimite, prioridad, estado);
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaLimite=" + fechaLimite +
                ", prioridad='" + prioridad + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }

}
