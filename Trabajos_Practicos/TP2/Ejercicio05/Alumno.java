public class Alumno extends Votante {
  private int materiasRendidas;

  @Override
  public boolean puedeVotar() {
    return this.materiasRendidas >= 2;
  }

  public int getMateriasRendidas() {
    return materiasRendidas;
  }

  public void setMateriasRendidas(int materiasRendidas) {
    this.materiasRendidas = materiasRendidas;
  }

  public Alumno() {
  }

  public Alumno(int materiasRendidas, String nombre, int dni) {
    super(nombre, dni);
    this.materiasRendidas = materiasRendidas;
  }

  @Override
  public int votar(int partido) {
    return partido += 1;
  }
}
