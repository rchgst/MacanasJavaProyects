public abstract class PiezaCeramica {
  private int codigo;
  private double precioBase;

  public PiezaCeramica(double precioBase, int codigo) {
    this.precioBase = precioBase;
    this.codigo = codigo;
  }

  public double getPrecioBase() {
    return this.precioBase;
  }

  public abstract double getPrecioFinal();
}
