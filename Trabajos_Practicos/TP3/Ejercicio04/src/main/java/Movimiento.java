public class Movimiento {
  private int idCaja;
  private double importe;

  public int getIdCaja() {
    return this.idCaja;
  }

  public void setIdCaja(int idCaja) {
    this.idCaja = idCaja;
  }

  public double getImporte() {
    return this.importe;
  }

  public void setImporte(double importe) {
    this.importe = importe;
  }

  public Movimiento() {
  }

  public Movimiento(int idCaja, double importe) {
    this.idCaja = idCaja;
    this.importe = importe;
  }

}
