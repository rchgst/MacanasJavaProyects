public class Internado extends Paciente {
  private Fecha fechaAlta;

  // Este metodo es solo para realizar pruebas
  public void setFechaAlta(int year, int month, int day) {
    this.fechaAlta.setFecha(year, month, day);
  }

  public void setFechaAlta() {
    this.fechaAlta.fechaActual();
  }

  public Fecha getFechaAlta() {
    return fechaAlta;
  }

  public Internado() {
  }

  public Internado(String nombre, int dni, String domicilio, String telefono) {
    super(nombre, dni, domicilio, telefono);
  }

  @Override
  public String toString() {
    if (this.fechaAlta == null) {
      return super.toString() + "\nFecha de alta: -";
    } else {
      return super.toString() + "\nFecha de alta: " + fechaAlta.toString();
    }
  }
}
