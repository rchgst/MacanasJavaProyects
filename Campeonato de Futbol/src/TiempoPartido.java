import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TiempoPartido {
    LocalTime tiempo;

    public  TiempoPartido(int hora, int min){
        this.tiempo = LocalTime.of(hora,min);
    }

    @Override
    public String toString() {
        String cadena="";
        DateTimeFormatter formato = DateTimeFormatter.ofPattern(" hh:mm 'Horas'");
        return  cadena = this.tiempo.format(formato);
    }
}
