import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class Fecha {
    private LocalDate fecha;

    public Fecha() {
        this.fecha = LocalDate.now();
    }

    public Fecha(int anio, int mes, int dia) {
        this.fecha = LocalDate.of(anio, mes, dia);
    }

    public int comparaFechas(Fecha otra) {
        return this.fecha.compareTo(otra.fecha);
    }
    public int diferenciaAnios(Fecha otra){
        return (int) ChronoUnit.YEARS.between(this.fecha,otra.fecha);
    }

    public void nextMonth(){
        fecha.plusMonths(1);
    }

    @Override
    public String toString() {
        DateTimeFormatter formato=DateTimeFormatter.ofPattern("'Fecha: 'dd/MM/yyyy");
        return this.fecha.format(formato);
    }
}