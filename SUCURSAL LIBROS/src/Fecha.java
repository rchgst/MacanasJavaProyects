import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
public class Fecha {
    LocalDate fecha;

    public Fecha(){
        this.fecha= LocalDate.now();
    }
    public Fecha(int anio,int mes,int dia){
        this.fecha=LocalDate.of(anio,mes,dia);
    }
    public int diferenciaAnios(Fecha otra){
        return (int) ChronoUnit.YEARS.between(this.fecha,otra.fecha);
    }
    @Override
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("'Fecha: dd/MM/yyyy");
        return this.fecha.format(formato);
    }
}
