public class Rectangulo extends Figura {
  protected double base;
  protected double altura;

  public Rectangulo() {
  }

  public Rectangulo(double base, double altura) {
    this.base = base;
    this.altura = altura;
  }

  public Rectangulo(String color, boolean relleno, double base, double altura) {
    super(color, relleno);
    this.base = base;
    this.altura = altura;
  }

  public double getBase() {
    return this.base;
  }

  public void setBase(double base) {
    this.base = base;
  }

  public double getAltura() {
    return this.altura;
  }

  public void setAltura(double altura) {
    this.altura = altura;
  }

  @Override
  public double getArea() {
    double area = 0;
    if (this.base > 0 && this.altura > 0) {
      area = this.base * this.altura;
    }
    return area;
  }

  @Override
  public double getPerimetro() {
    double perimetro = 0;
    if (this.base > 0 && this.altura > 0) {
      perimetro = 2 * (this.base + this.altura);
    }
    return perimetro;
  }

  @Override
  public String toString() {
    return "Rectangulo [color=" + this.color + ", base=" + this.base + ", relleno=" + this.relleno + ", altura="
        + this.altura + "]";
  }

}
