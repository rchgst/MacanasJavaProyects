package biblioteca_app.dominio;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Autor {
    private String nombre,nacionalidad;
    private Date fecha_nacimiento,fecha_fallecimiento;
    private int id;
    private String biografia;
    private List<Libro> libros;

    public Autor(String nombre, String nacionalidad, Date fecha_nacimiento, Date fecha_fallecimiento,String biografia) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.fecha_nacimiento = fecha_nacimiento;
        this.fecha_fallecimiento = fecha_fallecimiento;
        this.biografia = biografia;
        this.libros = new ArrayList<>();
    }

    public Autor(String nombre, String nacionalidad, Date fecha_nacimiento, Date fecha_fallecimiento,String biografia, int id) {
        this(nombre,nacionalidad,fecha_nacimiento,fecha_fallecimiento,biografia);
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

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Date getFecha_fallecimiento() {
        return fecha_fallecimiento;
    }

    public void setFecha_fallecimiento(Date fecha_fallecimiento) {
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

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        return id == autor.id && Objects.equals(nombre, autor.nombre) && Objects.equals(nacionalidad, autor.nacionalidad) && Objects.equals(fecha_nacimiento, autor.fecha_nacimiento) && Objects.equals(fecha_fallecimiento, autor.fecha_fallecimiento) && Objects.equals(biografia, autor.biografia) && Objects.equals(libros, autor.libros);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, nacionalidad, fecha_nacimiento, fecha_fallecimiento, id, biografia, libros);
    }
}
