public class Tanque {
  private double capTotal;
  private double capActual;
  private boolean vacio;

  public double getCapTotal() {
    return this.capTotal;
  }

  public void setCapTotal(double capTotal) {
    this.capTotal = capTotal;
  }

  public double getCapActual() {
    return this.capActual;
  }

  public void setCapActual(double capActual) {
    this.capActual = capActual;
  }

  public boolean isVacio() {
    return this.vacio;
  }

  public void setVacio(boolean vacio) {
    this.vacio = vacio;
  }

  public Tanque() {
    this.vacio = true;
  }

  public Tanque(double capTotal, double capActual) {
    this.capTotal = capTotal;
    this.capActual = capActual;
    if (capActual == 0) {
      this.vacio = true;
    }
  }
}
