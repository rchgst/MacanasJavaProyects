public class Prestacion {
  protected int idPrestacion;
  protected String nombre;
  protected Paciente paciente;
  protected Profesional prestador;
  protected Fecha fchRealizacion;

  public int getIdPrestacion() {
    return this.idPrestacion;
  }

  public void setIdPrestacion(int idPrestacion) {
    this.idPrestacion = idPrestacion;
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Paciente getPaciente() {
    return this.paciente;
  }

  public void setPaciente(Paciente paciente) {
    this.paciente = paciente;
  }

  public Profesional getPrestador() {
    return this.prestador;
  }

  public void setPrestador(Profesional prestador) {
    this.prestador = prestador;
  }

  public Fecha getFchRealizacion() {
    return this.fchRealizacion;
  }

  public void setFchRealizacion(Fecha fchRealizacion) {
    this.fchRealizacion = fchRealizacion;
  }

  public Prestacion(int idPrestacion, String nombre, Paciente paciente, Profesional prestador, Fecha fchRealizacion) {
    this.idPrestacion = idPrestacion;
    this.nombre = nombre;
    this.paciente = paciente;
    this.prestador = prestador;
    this.fchRealizacion = fchRealizacion;
  }

  public Prestacion() {
  }
}
