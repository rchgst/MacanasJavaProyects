public class Linea implements Relacion {
  private double x1;
  private double y1;
  private double x2;
  private double y2;

  public Linea(double x1, double y1, double x2, double y2) {
    this.y2 = y2;
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
  }

  public double getLongitud() {
    double longitud = 0;
    if (this.x1 != this.x2 || this.y1 != this.y2) {
      longitud = Math.sqrt(Math.pow(this.x2 - this.x1, 2) + Math.pow(this.y2 - this.y1, 2));
    }
    return longitud;
  }

  @Override
  public boolean esMasGrande(Object otro) {
    boolean loEs = false;
    if (otro instanceof Linea) {
      loEs = ((Linea) otro).getLongitud() < getLongitud();
    }
    return loEs;
  }

  @Override
  public boolean esMasChico(Object otro) {
    boolean loEs = false;
    if (otro instanceof Linea) {
      loEs = ((Linea) otro).getLongitud() > getLongitud();
    }
    return loEs;
  }

  @Override
  public boolean esIgual(Object otro) {
    boolean loEs = false;
    if (otro instanceof Linea) {
      loEs = ((Linea) otro).getLongitud() == getLongitud();
    }
    return loEs;
  }
}
