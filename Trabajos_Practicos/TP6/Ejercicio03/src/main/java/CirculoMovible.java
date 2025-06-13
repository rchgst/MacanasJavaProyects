public class CirculoMovible implements Movible {
  private int radio;
  private PuntoMovible centro;

  public CirculoMovible(int x, int y, int xVelocidad, int yVelocidad, int radio) {
    this.radio = radio;
    this.centro = new PuntoMovible(x, y, xVelocidad, yVelocidad);
  }

  @Override
  public void moverArriba() {
    this.centro.moverArriba();
  }

  @Override
  public void moverAbajo() {
    this.centro.moverAbajo();
  }

  @Override
  public void moverIzquierda() {
    this.centro.moverIzquierda();
  }

  @Override
  public void moverDerecha() {
    this.centro.moverDerecha();
  }

  @Override
  public String toString() {
    return "CirculoMovible [radio=" + this.radio + ", centro=" + this.centro + "]";
  }
}
