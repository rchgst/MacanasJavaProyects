import java.util.ArrayList;

public class Pedido {
  private ArrayList<PiezaCeramica> piezas;
  private FormaDePago formaDePago;

  public Pedido() {
    this.piezas = new ArrayList<>();
  }

  public void agregarPieza(PiezaCeramica pieza) {
    this.piezas.add(pieza);
  }

  public void setFormaDePago(FormaDePago formaDePago) {
    this.formaDePago = formaDePago;
  }

  public double calcularTotal() {
    double total = 0;
    if (!(this.piezas.isEmpty())) {
      for (PiezaCeramica piezaCeramica : this.piezas) {
        total += piezaCeramica.getPrecioFinal();
      }
    }
    return total;
  }

  public void pagar() {
    if (this.formaDePago != null) {
      double total = calcularTotal();
      System.out.println("Total a pagar: " + total);
      System.out.println("Lo que pagara: " + this.formaDePago.pagar(total));
    } else {
      System.out.println("No indico su metodo de pago!");
    }
  }
}
