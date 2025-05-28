import java.util.ArrayList;

public class Libro {
  private int isbn;
  private ArrayList<Autor> autores;
  private Formato formato;
  private double precioNominal;

  public int getIsbn() {
    return this.isbn;
  }

  public ArrayList<Autor> getAutores() {
    return this.autores;
  }

  public Formato getFormato() {
    return this.formato;
  }

  public double getPrecio() {
    if (this.formato instanceof Papel) {
      if (this.formato.getTipo().trim().toLowerCase().equals("tapa dura")) {
        return this.precioNominal * 1.20;
      }
      return this.precioNominal;
    } else {
      if (this.formato.getTipo().trim().toLowerCase().equals("mobi")) {
        return this.precioNominal * 0.95;
      }
      return this.precioNominal * 0.85;
    }
  }

  public Libro(int isbn, ArrayList<Autor> autores, Formato formato, double precioNominal) {
    this.isbn = isbn;
    this.autores = autores;
    this.formato = formato;
    this.precioNominal = precioNominal;
  }

  public boolean equals(Libro otro) {
    return this.isbn == otro.getIsbn();
  }
}
