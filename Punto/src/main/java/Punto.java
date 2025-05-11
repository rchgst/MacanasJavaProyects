import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Punto {

  private double x;
  private double y;

  public double getX() {
    return this.x;
  }

  public void setX(double x) {
    this.x = x;
  }

  public double getY() {
    return this.y;
  }

  public void setY(double y) {
    this.y = y;
  }

  public double distanciaEuclidea(Punto p) {
    return sqrt(pow(p.getX() - getX(), 2) + pow(p.getY() - getY(), 2));
  }

  public Punto(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public Punto() {
  }

  public boolean estaDentroRadio(Punto p, double radio) {
    return distanciaEuclidea(p) <= radio;
  }
}
