public class Vegetal {
  private double porcentajeJugo;
  private double peso;
  private double porcentajePesoExtra;

  public double getPorcentajeJugo() {
    return this.porcentajeJugo;
  }

  public void setPorcentajeJugo(double porcentajeJugo) {
    if (porcentajeJugo > 0) {
      this.porcentajeJugo = porcentajeJugo;
    }
  }

  public double getPeso() {
    return this.peso;
  }

  public void setPeso(double peso) {
    if (peso > 0) {
      this.peso = peso;
    }
  }

  public double getPorcentajePesoExtra() {
    return this.porcentajePesoExtra;
  }

  public void setPorcentajePesoExtra(double porcentajePesoExtra) {
    if (porcentajePesoExtra > 0) {
      this.porcentajePesoExtra = porcentajePesoExtra;
    }
  }

  public Vegetal() {
  }

  public Vegetal(double porcentajePesoExtra) {
    this.porcentajePesoExtra = porcentajePesoExtra;
  }

  public Vegetal(double porcentajeJugo, double peso, double porcentajePesoExtra) {
    this(porcentajePesoExtra, porcentajeJugo);
    this.peso = peso;
  }

  public Vegetal(double porcentajePesoExtra, double porcentajeJugo) {
    this(porcentajePesoExtra);
    this.porcentajeJugo = porcentajeJugo;
  }

  public double calcularCantidadJugo() {
    if (this.peso == 0) {
      return 0;
    } else {
      return (this.peso * this.porcentajeJugo) - (this.peso * this.porcentajePesoExtra);
    }
  }
}
