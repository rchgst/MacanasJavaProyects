import java.util.ArrayList;

public class CarritoDeCompra {
  private ArrayList<Libro> carrito;

  public CarritoDeCompra() {
    this.carrito = new ArrayList<>();
  }

  public void agregarLibro(Libro libro) {
    this.carrito.add(libro);
  }

  public void eliminarLibro(Libro libro) {
    this.carrito.remove(libro);
  }

  public double calcularTotal() {
    double precioTotal = 0;
    for (Libro libro : this.carrito) {
      precioTotal += libro.getPrecio();
    }
    return precioTotal;
  }

  public void pagar(TipoDePago tipoDePago) {
    double total = calcularTotal();
    System.out.println("El monto total a pagar es: " + total);
    System.out.println("Usted pago: " + tipoDePago.pagar(total));
  }
}
