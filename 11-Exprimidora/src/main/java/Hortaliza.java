public class Hortaliza extends Vegetal {
  public Hortaliza() {
    super(0.05);
  }

  public Hortaliza(double porcentajeJugo) {
    super(0.05, porcentajeJugo);
  }

  public Hortaliza(double porcentajeJugo, double peso) {
    super(porcentajeJugo, peso, 0.05);
  }
}
