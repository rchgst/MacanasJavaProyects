import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Fecha {
    private LocalDateTime fechaYHora;

    public Fecha(int anio, int mes, int dia, int hora, int min){
        this.fechaYHora = LocalDateTime.of(anio, mes, dia, hora, min);
    }

    public long diferencia2Fechas() {
        return ChronoUnit.DAYS.between(this.fechaYHora, LocalDateTime.now()); //Retorna la cantidad de días que transcurrieron desde fecha de ingreso del empleado hasta fecha actual
    }

    public String toString(){
        String cadena = "";
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("'Fecha: ' dd/MM/yyyy 'Hora: ' HH:mm");
        cadena += this.fechaYHora.format(formato) + "\n";
        return cadena;
    }
}