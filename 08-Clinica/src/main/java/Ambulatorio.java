public class Ambulatorio extends Paciente {
  private String observaciones;

  public String getObservaciones() {
    return this.observaciones;
  }

  public void setObservaciones(String observaciones) {
    this.observaciones = observaciones;
  }

  public Ambulatorio(String nombre, int dni, String domicilio, String telefono, String observaciones) {
    super(nombre, dni, domicilio, telefono);
    this.observaciones = observaciones;
  }

  public Ambulatorio() {
  }

  @Override
  public String toString() {
    return super.toString() + "\nObservaciones:" + observaciones;
  }

}
