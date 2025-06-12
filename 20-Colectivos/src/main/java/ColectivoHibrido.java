public class ColectivoHibrido extends Colectivo implements IDiesel, IElectrico {
  private double voltaje;
  private double distancia;
  private int nivelContaminacion;

  public ColectivoHibrido(int capacidad, double costo, double voltaje, double distancia, int nivelContaminacion) {
    super(capacidad, costo);
    this.voltaje = voltaje;
    this.distancia = distancia;
    this.nivelContaminacion = nivelContaminacion;
  }

  @Override
  public double getVoltaje() {
    return this.voltaje;
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
    return 4.0;
  }
}
