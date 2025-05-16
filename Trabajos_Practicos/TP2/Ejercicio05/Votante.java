public class Votante {
  private String nombre;
  private int dni;

  public int votar(int partido) {
    return partido += 3;
  }

  public boolean puedeVotar() {
    return true;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getDni() {
    return dni;
  }

  public void setDni(int dni) {
    this.dni = dni;
  }

  public Votante(String nombre, int dni) {
    this.nombre = nombre;
    this.dni = dni;
  }

  public Votante() {
  }

  @Override
  public String toString() {
    return "Votante [nombre=" + nombre + ", dni=" + dni + "]";
  }
}
