public class Docente extends Votante {
  private boolean cargoRegularEnAsignatura;

  @Override
  public boolean puedeVotar() {
    return this.cargoRegularEnAsignatura;
  }

  public boolean isCargoRegularEnAsignatura() {
    return cargoRegularEnAsignatura;
  }

  public void setCargoRegularEnAsignatura(boolean cargoRegularEnAsignatura) {
    this.cargoRegularEnAsignatura = cargoRegularEnAsignatura;
  }

  public Docente() {
  }

  public Docente(boolean cargoRegularEnAsignatura, String nombre, int dni) {
    super(nombre, dni);
    this.cargoRegularEnAsignatura = cargoRegularEnAsignatura;
  }

}
