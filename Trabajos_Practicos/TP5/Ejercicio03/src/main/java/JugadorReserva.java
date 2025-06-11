import java.util.Calendar;

public class JugadorReserva extends Jugador {
  public JugadorReserva(String nombre, int edad, String apellido, String id, Calendar fchInicio) {
    super(nombre, apellido, edad, id, fchInicio);
  }

  @Override
  public double importeNomina(Calendar hasta) {
    double nomina = 0;
    if (this.fchInicio.before(hasta)) {
      int anios = hasta.get(Calendar.YEAR) - this.fchInicio.get(Calendar.YEAR);
      int meses = hasta.get(Calendar.MONTH) - this.fchInicio.get(Calendar.MONTH);
      if (hasta.get(Calendar.DAY_OF_MONTH) < this.fchInicio.get(Calendar.DAY_OF_MONTH)) {
        --meses;
      }
      nomina = ((anios * 12) + meses) * 15000;
    }
    return nomina;
  }

  @Override
  public String toString() {
    return "JugadorPrimera [Id del Jugador=" + getIdJugador() + ", Nombre=" + getNombre() + getIdJugador()
        + ", Apellido=" + getApellido() + ", Edad=" + getEdad() + ", fchInicio="
        + this.fchInicio.get(Calendar.DAY_OF_MONTH) + "/" + (this.fchInicio.get(Calendar.MONTH) + 1) + "/"
        + this.fchInicio.get(Calendar.YEAR) + "]";
  }
}
