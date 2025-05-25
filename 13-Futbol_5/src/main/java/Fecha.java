import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Fecha {
  private LocalDate fecha;

  public String getFecha() {
    return this.fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
  }

  public void setFecha(int day, int month, int year) {
    this.fecha = LocalDate.of(year, month, day);
  }

  public Fecha() {
  }

  public Fecha(int day, int month, int year) {
    this.fecha = LocalDate.of(year, month, day);
  }

  @Override
  public String toString() {
    return "Fecha: " + this.fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
  }
}
