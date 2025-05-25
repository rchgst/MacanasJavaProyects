import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Fecha {
    LocalDate Fecha;

    public Fecha(){
        this.Fecha = LocalDate.now();
    }

    public Fecha(int anio,int mes,int dia){
        this.Fecha = LocalDate.of(anio, mes, dia);
    }

    @Override
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String cadena = this.Fecha.format(formato);
        return  cadena;
    }
}
