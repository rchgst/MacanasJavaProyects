public class Baldosa extends PiezaCeramica {
  private int peso;

  public Baldosa(double precioBase, int codigo, int peso) {
    super(precioBase, codigo);
    this.peso = peso;
  }

  @Override
  public double getPrecioFinal() {
    return getPrecioBase() + (0.034 * this.peso);
  }

}
