package biblioteca_app.dominio;

import java.util.Objects;

public class Libro {

    private String titulo,autor,isbn,categoria;
    private int id,anio;

    public Libro(String titulo, String autor, String isbn, String categoria, int anio) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.categoria = categoria;
        this.anio = anio;
    }

    public Libro(String titulo, String autor, String isbn, String categoria, int anio, int id) {
        this(titulo,autor,isbn,categoria,anio);
        this.id = id;
    }

    public Libro(int id) {
        this.id = id;
    }

    public Libro(){}

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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

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

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", isbn='" + isbn + '\'' +
                ", categoria='" + categoria + '\'' +
                ", id=" + id +
                ", anio=" + anio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return id == libro.id && anio == libro.anio && Objects.equals(titulo, libro.titulo) && Objects.equals(autor, libro.autor) && Objects.equals(isbn, libro.isbn) && Objects.equals(categoria, libro.categoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, autor, isbn, categoria, id, anio);
    }
}
