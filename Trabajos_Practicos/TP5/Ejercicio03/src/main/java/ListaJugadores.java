import java.util.ArrayList;
import java.util.Calendar;

public class ListaJugadores {
  private ArrayList<Jugador> jugadores;

  public ListaJugadores() {
    this.jugadores = new ArrayList<>();
  }

  public void agregarJugador(Jugador jugador) {
    this.jugadores.add(jugador);
  }

  public void imprimirListado() {
    for (Jugador jugador : this.jugadores) {
      if (jugador instanceof JugadorPrimera) {
        System.out.println("Jugador de Primera");
      } else {
        System.out.println("Jugador de Reserva");
      }
      System.out.println(jugador);
    }
  }

  public double importeTotalNominaJugadores(Calendar hasta) {
    double nominaTotal = 0;
    if (!(this.jugadores.isEmpty())) {
      for (Jugador jugador : this.jugadores) {
        nominaTotal += jugador.importeNomina(hasta);
      }
    }
    return nominaTotal;
  }
}
