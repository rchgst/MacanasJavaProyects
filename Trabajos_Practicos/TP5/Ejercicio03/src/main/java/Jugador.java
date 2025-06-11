import java.util.Calendar;

public abstract class Jugador extends Persona {
  private String idJugador;
  protected Calendar fchInicio;

  public String getIdJugador() {
    return this.idJugador;
  }

  public void setIdJugador(String idJugador) {
    this.idJugador = idJugador;
  }

  public Jugador(String nombre, String apellido, int edad, String idJugador, Calendar fchInicio) {
    super(nombre, apellido, edad);
    this.idJugador = idJugador;
    this.fchInicio = fchInicio;
  }

  public abstract double importeNomina(Calendar hasta);

  @Override
  public String toString() {
    return "Jugador [idJugador=" + this.idJugador + ", fchInicio=" + this.fchInicio + ", nombre=" + getNombre()
        + ", apellido=" + getApellido() + ", edad=" + getEdad() + "]";
  }

}
