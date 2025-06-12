public class Azulejo extends PiezaCeramica {
  private int medida;

  public Azulejo(double precioBase, int codigo, int medida) {
    super(precioBase, codigo);
    this.medida = medida;
  }

  @Override
  public double getPrecioFinal() {
    return getPrecioBase() + (3.05 * this.medida);
  }

}
