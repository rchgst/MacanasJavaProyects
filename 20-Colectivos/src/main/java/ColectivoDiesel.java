public class ColectivoDiesel extends Colectivo implements IDiesel {
  private double distancia;
  private int nivelContaminacion;

  public ColectivoDiesel(int capacidad, double costo, double distancia, int nivelContaminacion) {
    super(capacidad, costo);
    this.distancia = distancia;
    this.nivelContaminacion = nivelContaminacion;
  }

  @Override
  public double getDistancia() {
    return this.distancia;
  }

  @Override
  public double getNivelContaminacion() {
    return this.nivelContaminacion;
  }

  @Override
  public double getAccel() {
    return 3.0;
  }
}
