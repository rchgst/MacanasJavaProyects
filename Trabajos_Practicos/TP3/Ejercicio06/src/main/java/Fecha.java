import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Fecha {
  private LocalDate fecha;

  public Fecha() {
    this.fecha = LocalDate.now();
  }

  public Fecha(LocalDate fecha) {
    this.fecha = fecha;
  }

  public Fecha(int year, int month, int day) {
    this.fecha = LocalDate.of(year, month, day);
  }

  public LocalDate getFecha() {
    return fecha;
  }

  public void setFecha(LocalDate fecha) {
    this.fecha = fecha;
  }

  public int calcularAnios(Fecha actual) {
    return actual.getFecha().minusYears(this.fecha.getYear()).getYear();
  }

  public int compararFechas(Fecha comparar) {
    if (this.fecha.isBefore(comparar.getFecha())) {
      return -1;
    } else if (this.fecha.isAfter(comparar.getFecha())) {
      return 1;
    }
    return 0;
  }

  @Override
  public String toString() {
    return "Fecha: " + this.fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
  }

}
