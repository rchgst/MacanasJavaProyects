public class ProgresionArit extends Progresion {
  protected long incr;

  public ProgresionArit() {
    this.incr = 1;
  }

  public ProgresionArit(long vincr) {
    this.incr = vincr;
  }

  protected long sgteValor() {
    this.actual += this.incr;
    return this.actual;
  }
}
