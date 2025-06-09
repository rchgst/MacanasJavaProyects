public class Profesional extends Persona {
  private int matricula;

  public int getMatricula() {
    return this.matricula;
  }

  public void setMatricula(int matricula) {
    this.matricula = matricula;
  }

  public Profesional() {
  }

  public Profesional(int dni, String nombre, char sexo, Fecha fchNac, int matricula) {
    super(dni, nombre, sexo, fchNac);
    this.matricula = matricula;
  }

  @Override
  public String toString() {
    String sexo = (this.sexo == 'M') ? "Masculino" : "Femenino";
    return "Profesional\nDni: " + this.dni + "\nNombre: " + this.nombre + "\nSexo: " + sexo
        + "\nFecha de Nacimiento: " + this.fchNac.toString() + "\nMatricula: " + this.matricula + "\n";
  }

}
