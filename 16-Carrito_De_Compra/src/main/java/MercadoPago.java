public class MercadoPago extends TipoDePago {
  private double porcRecargo;

  public MercadoPago() {
    this.porcRecargo = 0.15;
  }

  @Override
  public double pagar(double monto) {
    return monto + (monto * this.porcRecargo);
  }

  public double getPorcRecargo() {
    return this.porcRecargo;
  }

  public void setPorcRecargo(double porcRecargo) {
    this.porcRecargo = porcRecargo;
  }
}
