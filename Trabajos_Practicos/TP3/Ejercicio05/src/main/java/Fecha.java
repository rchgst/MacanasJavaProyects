import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Fecha {
  private LocalDate fecha;

  public void setFecha() {
    fecha = LocalDate.now();
  }

  public void setFecha(int day, int month, int year) {
    fecha = LocalDate.of(year, month, day);
  }

  public Fecha() {
    this.fecha = LocalDate.now();
  }

  public Fecha(int year, int month, int day) {
    fecha = LocalDate.of(year, month, day);
  }

  public int calcularAnio(Fecha f) {
    return this.fecha.minusYears(f.fecha.getYear()).getYear();
  }

  public void sumarUnMes() {
    this.fecha.plusMonths(1);
  }

  @Override
  public String toString() {
    return "Fecha: " + fecha.format(DateTimeFormatter.ofPattern("dd/mm/yyyy"));
  }

}
