public class Persona {
  protected int dni;
  protected String nombre;
  protected char sexo;
  protected Fecha fchNac;

  public int getDni() {
    return this.dni;
  }

  public void setDni(int dni) {
    this.dni = dni;
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public char getSexo() {
    return this.sexo;
  }

  public void setSexo(char sexo) {
    this.sexo = sexo;
  }

  public Fecha getFchNac() {
    return this.fchNac;
  }

  public void setFchNac(Fecha fchNac) {
    this.fchNac = fchNac;
  }

  public Persona() {
  }

  public Persona(int dni, String nombre, char sexo, Fecha fchNac) {
    this.dni = dni;
    this.nombre = nombre;
    this.sexo = sexo;
    this.fchNac = fchNac;
  }

  @Override
  public String toString() {
    return "Persona\nDni: " + this.dni + "\nNombre: " + this.nombre + "\nSexo: " + this.sexo + "\nFecha de Nacimiento: "
        + this.fchNac.toString();
  }

}
