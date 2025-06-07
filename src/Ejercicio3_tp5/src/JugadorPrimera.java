import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class JugadorPrimera extends Jugador{
    private LocalDate fchFin;
    public JugadorPrimera(String nombre, String apellido, int edad, String idJugador, LocalDate fchInicio,LocalDate fchFin) {
        super(nombre, apellido, edad, idJugador,fchInicio);
        this.fchFin = fchFin;
    }

    public LocalDate getFchFin() {
        return fchFin;
    }

    @Override
    public double importaNomina(LocalDate hasta) {
        long cantMeses = ChronoUnit.MONTHS.between(fchInicio,hasta);
        return cantMeses*2500;
    }

    public String toString(){
        return super.toString()+" fecha final: "+fchFin + " jugador de primera";
    }
}
