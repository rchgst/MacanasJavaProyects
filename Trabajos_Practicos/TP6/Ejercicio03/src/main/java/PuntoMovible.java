public class PuntoMovible implements Movible {
  private int x;
  private int y;
  private int xVelocidad;
  private int yVelocidad;

  public PuntoMovible(int x, int y, int xVelocidad, int yVelocidad) {
    this.x = x;
    this.y = y;
    this.xVelocidad = xVelocidad;
    this.yVelocidad = yVelocidad;
  }

  @Override
  public void moverArriba() {
    this.y += this.yVelocidad;
  }

  @Override
  public void moverAbajo() {
    this.y -= this.yVelocidad;
  }

  @Override
  public void moverIzquierda() {
    this.x -= this.xVelocidad;
  }

  @Override
  public void moverDerecha() {
    this.x += this.xVelocidad;
  }

  public int getX() {
    return this.x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return this.y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public int getxVelocidad() {
    return this.xVelocidad;
  }

  public void setxVelocidad(int xVelocidad) {
    this.xVelocidad = xVelocidad;
  }

  public int getyVelocidad() {
    return this.yVelocidad;
  }

  public void setyVelocidad(int yVelocidad) {
    this.yVelocidad = yVelocidad;
  }

  @Override
  public String toString() {
    return "PuntoMovible [x=" + this.x + ", y=" + this.y + ", xVelocidad=" + this.xVelocidad + ", yVelocidad="
        + this.yVelocidad + "]";
  }

}
