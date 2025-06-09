import java.util.ArrayList;

public class TablaPrestamo {
  private ArrayList<Prestamo> prestamos;
  private int cantidad;

  public TablaPrestamo() {
    this.prestamos = new ArrayList<>();
  }

  public Prestamo getPrestamos(int pos) {
    return this.prestamos.get(pos);
  }

  public int getCantidad() {
    return this.cantidad;
  }

  public void nuevoPrestamo(Prestamo p) {
    this.prestamos.add(p);
    ++this.cantidad;
  }

  public boolean estaPrestado(Libro libro) {
    boolean loEsta = false;
    if (!(this.prestamos.isEmpty())) {
      for (Prestamo prestamo : this.prestamos) {
        if (prestamo.getLibro().equals(libro)) {
          loEsta = true;
        }
      }
    }
    return loEsta;
  }

  public boolean hayPrestamos() {
    return !(this.prestamos.isEmpty());
  }
}
