public class Jugador {
  private int dni;
  private String nombre;
  private Fecha fchNac;

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

  public Fecha getFchNac() {
    return fchNac;
  }

  public void setFchNac(Fecha fchNac) {
    this.fchNac = fchNac;
  }

  public Jugador(int dni, String nombre, Fecha fchNac) {
    this.dni = dni;
    this.nombre = nombre;
    this.fchNac = fchNac;
  }

  public Jugador(int dni, String nombre) {
    this.dni = dni;
    this.nombre = nombre;
  }

  @Override
  public String toString() {
    String cadena = "===Jugador===\nNombre: " + this.nombre + "\nDNI: " + this.dni + "\n";
    if (this.fchNac != null) {
      cadena += fchNac.toString() + "\n";
    }
    return cadena;
  }

}
