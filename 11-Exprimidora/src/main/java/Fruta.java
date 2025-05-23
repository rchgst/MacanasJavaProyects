public class Fruta extends Vegetal {
  public Fruta() {
    super(0.1);
  }

  public Fruta(double porcentajeJugo) {
    super(0.1, porcentajeJugo);
  }

  public Fruta(double porcentajeJugo, double peso) {
    super(porcentajeJugo, peso, 0.1);
  }
}
