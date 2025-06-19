package biblioteca_app.dominio;

import java.time.LocalDate;
import java.util.Objects;

public class Autor {
    private String nombre,nacionalidad;
    private LocalDate fecha_nacimiento,fecha_fallecimiento;
    private int id;

    public Autor(String nombre, String nacionalidad, LocalDate fecha_nacimiento, LocalDate fecha_fallecimiento) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.fecha_nacimiento = fecha_nacimiento;
        this.fecha_fallecimiento = fecha_fallecimiento;
    }

    public Autor(String nombre, String nacionalidad, LocalDate fecha_nacimiento, LocalDate fecha_fallecimiento, int id) {
        this(nombre,nacionalidad,fecha_nacimiento,fecha_fallecimiento);
        this.id = id;
    }

    public Autor(int id) {
        this.id = id;
    }

    public Autor(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public LocalDate getFecha_fallecimiento() {
        return fecha_fallecimiento;
    }

    public void setFecha_fallecimiento(LocalDate fecha_fallecimiento) {
        this.fecha_fallecimiento = fecha_fallecimiento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "nombre='" + nombre + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", fecha_nacimiento=" + fecha_nacimiento +
                ", fecha_fallecimiento=" + fecha_fallecimiento +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        return id == autor.id && Objects.equals(nombre, autor.nombre) && Objects.equals(nacionalidad, autor.nacionalidad) && Objects.equals(fecha_nacimiento, autor.fecha_nacimiento) && Objects.equals(fecha_fallecimiento, autor.fecha_fallecimiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, nacionalidad, fecha_nacimiento, fecha_fallecimiento, id);
    }
}
