public class Efectivo extends TipoDePago {
  private double porcDescuento;

  public Efectivo() {
    this.porcDescuento = 0.1;
  }

  @Override
  public double pagar(double monto) {
    return monto - (monto * this.porcDescuento);
  }

  public double getPorcDescuento() {
    return this.porcDescuento;
  }

  public void setPorcDescuento(double porcDescuento) {
    this.porcDescuento = porcDescuento;
  }
}
