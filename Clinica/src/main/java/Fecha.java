import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class Fecha {
  LocalDate fecha;

  public LocalDate getFecha() {
    return fecha;
  }

  // Este metodo es solo para realizar pruebas
  public void setFecha(int year, int month, int day) {
    Month mes = Month.JANUARY;
    switch (month) {
      case 1:
        mes = Month.JANUARY;
        break;
      case 2:
        mes = Month.FEBRUARY;
        break;
      case 3:
        mes = Month.MARCH;
        break;
      case 4:
        mes = Month.APRIL;
        break;
      case 5:
        mes = Month.MAY;
        break;
      case 6:
        mes = Month.JUNE;
        break;
      case 7:
        mes = Month.JULY;
        break;
      case 8:
        mes = Month.AUGUST;
        break;
      case 9:
        mes = Month.SEPTEMBER;
        break;
      case 10:
        mes = Month.OCTOBER;
        break;
      case 11:
        mes = Month.NOVEMBER;
        break;
      case 12:
        mes = Month.DECEMBER;
        break;
    }
    this.fecha = LocalDate.of(year, mes, day);
  }

  public void fechaActual() {
    this.fecha = LocalDate.now();
  }

  @Override
  public String toString() {
    return this.fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
  }

}
