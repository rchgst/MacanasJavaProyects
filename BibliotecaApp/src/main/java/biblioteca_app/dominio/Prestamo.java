package biblioteca_app.dominio;

import java.time.LocalDate;
import java.util.Objects;

public class Prestamo {

    private int id;
    private int idUsuario;
    private int idLibro;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    public Prestamo(int idUsuario, int idLibro, LocalDate fechaPrestamo, LocalDate fechaDevolucion) {
        this.idUsuario = idUsuario;
        this.idLibro = idLibro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public Prestamo(int id, int idUsuario, int idLibro, LocalDate fechaPrestamo, LocalDate fechaDevolucion) {
        this(idUsuario,idLibro,fechaPrestamo,fechaDevolucion);
        this.id = id;
    }

    public Prestamo(int id){
        this.id = id;
    }

    public Prestamo(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "id=" + id +
                ", idUsuario=" + idUsuario +
                ", idLibro=" + idLibro +
                ", fechaPrestamo=" + fechaPrestamo +
                ", fechaDevolucion=" + fechaDevolucion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Prestamo prestamo = (Prestamo) o;
        return id == prestamo.id && idUsuario == prestamo.idUsuario && idLibro == prestamo.idLibro && Objects.equals(fechaPrestamo, prestamo.fechaPrestamo) && Objects.equals(fechaDevolucion, prestamo.fechaDevolucion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idUsuario, idLibro, fechaPrestamo, fechaDevolucion);
    }
}
