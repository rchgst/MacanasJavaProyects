package biblioteca_app.dominio;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Prestamo {
    private int id;
    private Date fechaPrestamo,devolucion_esperada,devolucion_real;
    private String estado;
    private int idUsuario,idLibro;

    public Prestamo(Date fechaPrestamo, Date devolucion_esperada, Date devolucion_real, String estado, int idUsuario, int idLibro) {
        this.fechaPrestamo = fechaPrestamo;
        this.devolucion_esperada = devolucion_esperada;
        this.devolucion_real = devolucion_real;
        this.estado = estado;
        this.idUsuario = idUsuario;
        this.idLibro = idLibro;
    }

    public Prestamo(Date fechaPrestamo, Date devolucion_esperada, Date devolucion_real, String estado, int idUsuario, int idLibro, int id) {
        this(fechaPrestamo,devolucion_esperada,devolucion_real,estado,idUsuario,idLibro);
        this.id = id;
    }

    public Prestamo(int id) {
        this.id = id;
    }

    public Prestamo(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getDevolucion_esperada() {
        return devolucion_esperada;
    }

    public void setDevolucion_esperada(Date devolucion_esperada) {
        this.devolucion_esperada = devolucion_esperada;
    }

    public Date getDevolucion_real() {
        return devolucion_real;
    }

    public void setDevolucion_real(Date devolucion_real) {
        this.devolucion_real = devolucion_real;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Prestamo prestamo = (Prestamo) o;
        return id == prestamo.id && idUsuario == prestamo.idUsuario && idLibro == prestamo.idLibro && Objects.equals(fechaPrestamo, prestamo.fechaPrestamo) && Objects.equals(devolucion_esperada, prestamo.devolucion_esperada) && Objects.equals(devolucion_real, prestamo.devolucion_real) && Objects.equals(estado, prestamo.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fechaPrestamo, devolucion_esperada, devolucion_real, estado, idUsuario, idLibro);
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "id=" + id +
                ", fechaPrestamo=" + fechaPrestamo +
                ", devolucion_esperada=" + devolucion_esperada +
                ", devolucion_real=" + devolucion_real +
                ", estado='" + estado + '\'' +
                ", idUsuario=" + idUsuario +
                ", idLibro=" + idLibro +
                '}';
    }
}
