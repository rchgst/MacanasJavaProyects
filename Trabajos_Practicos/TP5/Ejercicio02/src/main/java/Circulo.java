public class Circulo extends Figura {
  protected double radio;

  public Circulo() {
  }

  public Circulo(String color, boolean relleno, double radio) {
    super(color, relleno);
    this.radio = radio;
  }

  public double getRadio() {
    return this.radio;
  }

  public void setRadio(double radio) {
    this.radio = radio;
  }

  @Override
  public double getArea() {
    double area = 0;
    if (this.radio > 0) {
      area = Math.PI * Math.pow(radio, 2);
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

  @Override
  public String toString() {
    return "Circulo [color=" + this.color + ", radio=" + this.radio + ", relleno=" + this.relleno + "]";
  }
}
