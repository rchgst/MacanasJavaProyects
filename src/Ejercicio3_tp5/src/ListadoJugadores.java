import java.time.LocalDate;
import java.util.ArrayList;

public class ListadoJugadores {
    private ArrayList<Jugador>jugadores;

    public ListadoJugadores(){jugadores = new ArrayList<Jugador>();}

    public void agregarJugador(Jugador jugador){
        jugadores.add(jugador);
    }

    public void imprimirListado(){
        for (int i=0;i<jugadores.size();i++){
            System.out.println("jugador "+i+jugadores.get(i));
        }
    }

    public double importeTotalNominaJugadores(LocalDate hasta){
        double acu=0;
        for (int i=0;i<jugadores.size();i++){
            acu+=jugadores.get(i).importaNomina(hasta);
        }
        return acu;
    }
}
