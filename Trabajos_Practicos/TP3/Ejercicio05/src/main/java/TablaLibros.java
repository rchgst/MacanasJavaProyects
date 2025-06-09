import java.util.ArrayList;

public class TablaLibros {
  private ArrayList<Libro> libros;
  private int cantidad;

  public TablaLibros() {
    this.libros = new ArrayList<>();
  }

  public ArrayList<Libro> getLibros() {
    return this.libros;
  }

  public void insertarLibro(Libro libro) {
    this.libros.add(libro);
    ++this.cantidad;
  }

  public void eliminarLibro(Libro libro) {
    if (!(this.libros.isEmpty())) {
      if (this.libros.contains(libro)) {
        this.libros.remove(libro);
        --this.cantidad;
      } else {
        System.out.println("No se encuentra ese libro en la lista.");
      }
    } else {
      System.out.println("La lista de libros esta vacia!");
    }
  }

  public int cantidadLibros() {
    return this.cantidad;
  }

  public boolean existeLibro(Libro libro) {
    return this.libros.contains(libro);
  }

  public boolean estaLlena() {
    return this.libros.size() == this.cantidad;
  }

  public boolean hayLibros() {
    return !(this.libros.isEmpty());
  }

  public Libro recuperarLibro(String codigo) {
    Libro recuperar = null;
    if (!(this.libros.isEmpty())) {
      for (Libro libro : this.libros) {
        if (libro.getCodigo().equals(codigo)) {
          recuperar = libro;
        }
      }
    }
    return recuperar;
  }

  public TablaLibros librosAutor(String nombre) {
    TablaLibros segunAutor = new TablaLibros();
    for (Libro libro : this.libros) {
      if (libro.getAutor().getNombre().equals(nombre)) {
        segunAutor.insertarLibro(libro);
      }
    }
    return segunAutor;
  }
}
