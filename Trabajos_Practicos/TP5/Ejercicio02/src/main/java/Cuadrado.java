public class Cuadrado extends Rectangulo {
  public Cuadrado() {
  }

  public Cuadrado(double lado) {
    super(lado, lado);
  }

  public Cuadrado(double lado, String color, boolean relleno) {
    super(color, relleno, lado, lado);
  }

  public double getLado() {
    return this.base;
  }

  public void setLado(double lado) {
    this.base = lado;
    this.altura = lado;
  }

  @Override
  public double getArea() {
    double area = 0;
    if (this.base > 0) {
      area = this.base * this.altura;
    }
    return area;
  }

  @Override
  public double getPerimetro() {
    double perimetro = 0;
    if (this.base > 0) {
      perimetro = this.base * 4;
    }
    return perimetro;
  }

  @Override
  public String toString() {
    return "Cuadrado [color=" + this.color + ", lado=" + this.base + ", relleno=" + this.relleno + "]";
  }

}
