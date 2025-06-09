public class Cirugia extends Prestacion {
  private int minutosDuracion;

  public int getMinutosDuracion() {
    return this.minutosDuracion;
  }

  public void setMinutosDuracion(int minutosDuracion) {
    this.minutosDuracion = minutosDuracion;
  }

  public Cirugia(int idPrestacion, String nombre, Paciente paciente, Profesional prestador, Fecha fchRealizacion,
      int minutosDuracion) {
    super(idPrestacion, nombre, paciente, prestador, fchRealizacion);
    this.minutosDuracion = minutosDuracion;
  }

  public Cirugia() {
  }

  @Override
  public String toString() {
    return "Cirugia\n{\nID de la Prestacion: " + this.idPrestacion + "\nNombre: " + this.nombre + "\nPaciente: "
        + this.paciente + "\nPrestador: " + this.prestador + "\nFecha de Realizacion: " + this.fchRealizacion
        + "\nMinutos de Duracion: " + this.minutosDuracion + "\n}\n";
  }
}
