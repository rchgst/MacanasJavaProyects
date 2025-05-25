import java.util.ArrayList;

public class Equipo {
  private ArrayList<Jugador> jugadores;

  public Equipo() {
    this.jugadores = new ArrayList<>();
  }

  public void agregarJugador(Jugador jugador) {
    if (this.jugadores.size() < 10) {
      this.jugadores.add(jugador);
    } else {
      System.out.println("No se pueden agregar mas jugadores en este equipo!");
    }
  }

  public void eliminarJugador(Jugador jugador) {
    this.jugadores.remove(jugador);
  }

  @Override
  public String toString() {
    String cadena = "";
    if (this.jugadores.size() > 0) {
      for (Jugador jugador : this.jugadores) {
        cadena += jugador.toString();
      }
    }
    return cadena;
  }
}
