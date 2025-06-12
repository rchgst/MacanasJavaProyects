public class ColectivoElectrico extends Colectivo implements IElectrico {
  private double voltaje;

  public ColectivoElectrico(int capacidad, double costo, double voltaje) {
    super(capacidad, costo);
    this.voltaje = voltaje;
  }

  @Override
  public double getVoltaje() {
    return this.voltaje;
  }

  @Override
  public double getAccel() {
    return 5.0;
  }

}
