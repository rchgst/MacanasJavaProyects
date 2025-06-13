public class Circulo implements ObjetoGeometrico {
  protected double radio;

  public Circulo(double radio) {
    this.radio = radio;
  }

  @Override
  public double getArea() {
    double area = 0;
    if (this.radio > 0) {
      area = Math.PI * Math.pow(this.radio, 2);
    }
    return area;
  }

  @Override
  public double getPerimetro() {
    double perimetro = 0;
    if (this.radio > 0) {
      perimetro = 2 * Math.PI * this.radio;
    }
    return perimetro;
  }

}
