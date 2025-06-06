import java.util.ArrayList;
import java.util.Scanner;

public class Juego {
  private Tablero tablero;
  private ArrayList<Jugador> jugadores;
  private int jugadorActualIndex;

  public Juego() {
    this.tablero = new Tablero();
    this.jugadores = new ArrayList<>();
  }

  public void jugar() {
    Scanner scanner = new Scanner(System.in);
    prepararJuego(scanner);
    while (tablero.hayCeldasDisponibles() && tablero.verificarGanador() == 0) {
      Jugador jugadorActual = this.jugadores.get(this.jugadorActualIndex);
      System.out.println("\nTurno de " + ((jugadorActual.getMarca() == 1) ? "O" : "X"));
      this.tablero.imprimirTablero();
      String movimiento = jugadorActual.hacerMovimiento(this.tablero, scanner);
      if (tablero.dibujarMarca(jugadorActual.getMarca(), Integer.parseInt(movimiento) / 10,
          Integer.parseInt(movimiento) % 10)) {
        this.jugadorActualIndex = (this.jugadorActualIndex + 1) % this.jugadores.size();
      } else {
        System.out.println("Movimiento invalido! Intente de nuevo.");
      }
    }
    this.tablero.imprimirTablero();
    int ganador = tablero.verificarGanador();
    if (ganador != 0) {
      System.out.println("¡Ganador: " + ((ganador == 1) ? "X" : "O") + "!");
    } else if (!(tablero.hayCeldasDisponibles())) {
      System.out.println("¡Empate!");
    }
  }

  private void prepararJuego(Scanner scanner) {
    int eleccion;
    System.out.println("=== TaTeTi o Tres en Raya ===");
    System.out.print("¿Jugar contra la computadora? (s/n): ");
    String vsCompu = scanner.nextLine().toLowerCase();
    System.out.println("¿Usara cruz o circulo? Su oponente tendra el simbolo contrario");
    System.out.println("1 - Cruz");
    System.out.println("2 - Circulo");
    System.out.print("Su eleccion: ");
    do {
      eleccion = Integer.parseInt(scanner.nextLine());
    } while (eleccion < 1 || eleccion > 2);
    if (vsCompu.equals("s")) {
      if (eleccion == 1) {
        this.jugadores.add(new JugadorHumano(1));
        this.jugadores.add(new Computadora(-1));
      } else {
        this.jugadores.add(new JugadorHumano(-1));
        this.jugadores.add(new Computadora(1));
      }
    } else {
      if (eleccion == 1) {
        this.jugadores.add(new JugadorHumano(1));
        this.jugadores.add(new JugadorHumano(-1));
      } else {
        this.jugadores.add(new JugadorHumano(-1));
        this.jugadores.add(new JugadorHumano(1));
      }
    }
    System.out.println("¿Quien empieza?");
    System.out.println("1 - Jugador1");
    System.out.println("2 - Jugador2");
    System.out.print("Su eleccion: ");
    do {
      eleccion = Integer.parseInt(scanner.nextLine());
    } while (eleccion < 1 || eleccion > 2);
    this.jugadorActualIndex = eleccion - 1;
  }
}
