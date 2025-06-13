public class CirculoRedimensionable extends Circulo implements Redimensionable {

  public CirculoRedimensionable(double radio) {
    super(radio);
  }

  @Override
  public void redimensionar(int porcentaje) {
    double redimension = this.radio * ((double) porcentaje / 100);
    this.radio = redimension;
  }

}
