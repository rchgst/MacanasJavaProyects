import java.util.Calendar;

public class JugadorPrimera extends Jugador {
  private Calendar fchFin;

  public Calendar getFchFin() {
    return this.fchFin;
  }

  public JugadorPrimera(String nombre, String apellido, int edad, String idJugador, Calendar fchInicio,
      Calendar fchFin) {
    super(nombre, apellido, edad, idJugador, fchInicio);
    this.fchFin = fchFin;
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
      nomina = ((anios * 12) + meses) * 25000;
    }
    return nomina;
  }

  @Override
  public String toString() {
    return "JugadorPrimera [Id del Jugador=" + getIdJugador() + ", Nombre=" + getNombre() + getIdJugador()
        + ", Apellido=" + getApellido() + ", Edad=" + getEdad() + ", fchInicio="
        + this.fchInicio.get(Calendar.DAY_OF_MONTH)
        + "/" + (this.fchInicio.get(Calendar.MONTH) + 1) + "/" + this.fchInicio.get(Calendar.YEAR) + ", fchFin="
        + this.fchFin.get(Calendar.DAY_OF_MONTH) + "/" + (this.fchFin.get(Calendar.MONTH) + 1) + "/"
        + this.fchFin.get(Calendar.YEAR) + "]";
  }

}
