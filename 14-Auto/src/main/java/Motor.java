public class Motor {
  private double consumoXMin;
  private double distanciaXLitro;
  private boolean encendido;

  public double getConsumoXMin() {
    return this.consumoXMin;
  }

  public void setConsumoXMin(double consumoXMin) {
    this.consumoXMin = consumoXMin;
  }

  public double getDistanciaXLitro() {
    return this.distanciaXLitro;
  }

  public void setDistanciaXLitro(double distanciaXLitro) {
    this.distanciaXLitro = distanciaXLitro;
  }

  public boolean isEncendido() {
    return this.encendido;
  }

  public void setEncendido(boolean encendido) {
    this.encendido = encendido;
  }

  public Motor() {
  }

  public Motor(double consumoXMin, double distanciaXLitro, boolean encendido) {
    this.consumoXMin = consumoXMin;
    this.distanciaXLitro = distanciaXLitro;
    this.encendido = encendido;
  }

  public Motor(double consumoXMin, double distanciaXLitro) {
    this.consumoXMin = consumoXMin;
    this.distanciaXLitro = distanciaXLitro;
  }

}
