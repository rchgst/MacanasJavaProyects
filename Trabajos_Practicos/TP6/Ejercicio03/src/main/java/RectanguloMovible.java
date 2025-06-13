public class RectanguloMovible implements Movible {
  private PuntoMovible supIzq;
  private PuntoMovible infDer;

  public RectanguloMovible(int x1, int y1, int x2, int y2, int xVelocidad, int yVelocidad) {
    if (x1 != x2 || y1 != y2) {
      this.supIzq = new PuntoMovible(x1, y1, xVelocidad, yVelocidad);
      this.infDer = new PuntoMovible(x2, y2, xVelocidad, yVelocidad);
    }
  }

  @Override
  public void moverArriba() {
    this.supIzq.moverArriba();
    this.infDer.moverArriba();
  }

  @Override
  public void moverAbajo() {
    this.supIzq.moverAbajo();
    this.infDer.moverAbajo();
  }

  @Override
  public void moverIzquierda() {
    this.supIzq.moverIzquierda();
    this.infDer.moverIzquierda();
  }

  @Override
  public void moverDerecha() {
    this.supIzq.moverDerecha();
    this.infDer.moverDerecha();
  }

  @Override
  public String toString() {
    return "RectanguloMovible [supIzq=" + this.supIzq + ", infDer=" + this.infDer + "]";
  }

}
