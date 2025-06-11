public abstract class Figura {
  protected String color;
  protected boolean relleno;

  public Figura() {
    this.color = "";
  }

  public Figura(String color, boolean relleno) {
    this.color = color;
    this.relleno = relleno;
  }

  public String getColor() {
    return this.color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public boolean estaRelleno() {
    return this.relleno;
  }

  public void setRelleno(boolean relleno) {
    this.relleno = relleno;
  }

  public abstract double getArea();

  public abstract double getPerimetro();

  @Override
  public String toString() {
    return "Figura [color=" + this.color + ", relleno=" + this.relleno + "]";
  }

}
