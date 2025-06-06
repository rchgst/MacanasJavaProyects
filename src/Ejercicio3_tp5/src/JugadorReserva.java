import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public class JugadorReserva extends Jugador{
    public JugadorReserva(String nombre, String apellido, int edad, String idJugador,LocalDate fchInicio) {
        super(nombre, apellido, edad, idJugador, fchInicio);
    }

    @Override
    public double importaNomina(LocalDate hasta) {
        long cantMeses = ChronoUnit.MONTHS.between(fchInicio,hasta);
        return cantMeses*1500;
    }
}
