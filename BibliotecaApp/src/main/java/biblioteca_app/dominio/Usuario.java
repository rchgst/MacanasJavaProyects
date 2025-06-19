package biblioteca_app.dominio;

import java.util.Date;
import java.util.Objects;

public class Usuario {

    private int id;
    private String dni;
    private String nombre;
    private String email;
    private String password; // Encriptada
    private String rol;
    private Date fechaRegistro;

    public Usuario(String dni, String nombre, String email, String password, String rol, Date fechaRegistro) {
        this.dni = dni;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.rol = rol;
        this.fechaRegistro = fechaRegistro;
    }

    public Usuario(int id, String dni, String nombre, String email, String password, String rol, Date fechaRegistro) {
        this(dni,nombre,email,password,rol,fechaRegistro);
        this.id = id;
    }

    public Usuario(int id) {
        this.id = id;
    }

    public Usuario(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public java.sql.Date getFechaRegistro() {
        return (java.sql.Date) fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", rol='" + rol + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id == usuario.id && Objects.equals(dni, usuario.dni) && Objects.equals(nombre, usuario.nombre) && Objects.equals(email, usuario.email) && Objects.equals(password, usuario.password) && Objects.equals(rol, usuario.rol) && Objects.equals(fechaRegistro, usuario.fechaRegistro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dni, nombre, email, password, rol, fechaRegistro);
    }
}
