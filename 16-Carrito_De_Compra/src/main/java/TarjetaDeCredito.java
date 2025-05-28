public class TarjetaDeCredito extends TipoDePago {
  private double recargo;

  public TarjetaDeCredito() {
    this.recargo = 100;
  }

  @Override
  public double pagar(double monto) {
    return monto + recargo;
  }

  public double getRecargo() {
    return this.recargo;
  }

  public void setRecargo(double recargo) {
    this.recargo = recargo;
  }
}
