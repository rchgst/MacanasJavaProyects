import java.util.ArrayList;

public class TablaAutores {
  private ArrayList<Autor> autores;
  private int cantidad;

  public ArrayList<Autor> getAutores() {
    return this.autores;
  }

  public TablaAutores() {
    this.autores = new ArrayList<>();
  }

  public void insertarAutor(Autor autor) {
    this.autores.add(autor);
    ++this.cantidad;
  }

  public int cantidadAutores() {
    return this.cantidad;
  }

  public boolean estaAutor(Autor autor) {
    return this.autores.contains(autor);
  }

  public boolean hayAutores() {
    return !(this.autores.isEmpty());
  }

  public Autor recuperarAutor(int pos) {
    Autor autor = null;
    if (pos >= 0 && pos < this.autores.size()) {
      autor = this.autores.get(pos);
    }
    return autor;
  }

  public Autor recuperarAutor(String nombre) {
    Autor recuperar = null;
    if (this.autores.size() > 0) {
      for (Autor autor : this.autores) {
        if (autor.getNombre().equals(nombre)) {
          recuperar = autor;
        }
      }
    }
    return recuperar;
  }

  public TablaAutores autoresNac(String nac) {
    TablaAutores autoresNac = new TablaAutores();
    for (Autor autor : this.autores) {
      if (autor.getNacionalidad().equals(nac)) {
        autoresNac.insertarAutor(autor);
      }
    }
    return autoresNac;
  }
}
