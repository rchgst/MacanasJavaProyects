package gestor_libros.dominio;

import java.util.Objects;

public class Libro {
    private int id,anio;
    private String titulo,autor,isbn;

    public Libro(int anio, String titulo, String autor, String isbn) {
        this.anio = anio;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
    }

    public Libro(int id, int anio, String titulo, String autor, String isbn) {
        this(anio,titulo,autor,isbn);
        this.id = id;
    }

    public Libro(int id) {
        this.id = id;
    }

    public Libro(){}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", anio=" + anio +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return id == libro.id && anio == libro.anio && Objects.equals(titulo, libro.titulo) && Objects.equals(autor, libro.autor) && Objects.equals(isbn, libro.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, anio, titulo, autor, isbn);
    }
}
