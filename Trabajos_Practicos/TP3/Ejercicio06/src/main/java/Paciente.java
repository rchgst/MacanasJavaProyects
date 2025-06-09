public class Paciente extends Persona {
  private ObraSocial obraSocial;

  public boolean esIgual(Paciente otro) {
    return this.dni == otro.dni;
  }

  public int edad() {
    return fchNac.calcularAnios(new Fecha());
  }

  public Paciente(int dni, String nombre, char sexo, Fecha fchNac, ObraSocial obraSocial) {
    super(dni, nombre, sexo, fchNac);
    this.obraSocial = obraSocial;
  }

  public Paciente() {
  }

  public ObraSocial getObraSocial() {
    return this.obraSocial;
  }

  public void setObraSocial(ObraSocial obraSocial) {
    this.obraSocial = obraSocial;
  }

  @Override
  public String toString() {
    String sexo = (this.sexo == 'M') ? "Masculino" : "Femenino";
    return "Paciente\nDni: " + this.dni + "\nNombre: " + this.nombre + "\nSexo: " + sexo
        + "\nFecha de Nacimiento: " + this.fchNac.toString() + "\nObra Social: " + this.obraSocial.toString() + "\n";
  }

  public boolean equals(Paciente otro) {
    return this.dni == otro.getDni();
  }

}
