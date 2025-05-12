import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Juego {
  private int sombreroGanador;
  private ArrayList<Jugador> jugadores = new ArrayList<>();

  public static void main(String[] args) {
    new Juego().run();
  }

  public void run() {
    Scanner scanner = new Scanner(System.in);
    prepararJuego(scanner);
    double[] apuestas = new double[3];
    int[] elecciones = new int[3];
    int cont = 0;
    do {
      for (Jugador jugador : this.jugadores) {
        System.out.println("Hola " + jugador.getNombre());
        System.out.print("Cual es el sombrero que oculta la moneda? (ingresar un numero de entre 1 y 3) ");
        elecciones[cont] = Integer.parseInt(scanner.nextLine());
        apuestas[cont] = jugador.apostar();
        ++cont;
      }
      anunciarGanadores(scanner, apuestas, elecciones);
      if (this.jugadores.size() < 3) {
        System.out
            .println("Hay mas jugadores que quieran participar? Pueden sumarse otros " + (3 - this.jugadores.size()));
        int agregar = 0;
        do {
          System.out.print("Cuantos jugadores desea agregar? ");
          agregar = Integer.parseInt(scanner.nextLine());
          if (agregar < 0 || agregar > (3 - this.jugadores.size())) {
            System.out.println("Valor invalido. Intente de nuevo");
          }
        } while (agregar < 0 || agregar > (3 - this.jugadores.size()));
        for (int i = 0; i < agregar; i++) {
          agregarJugador(scanner);
        }
      }
    } while (!this.jugadores.isEmpty());
    System.out.println("El juego ha terminado!! Gracias por participar!");
  }

  private void prepararJuego(Scanner scan) {
    Random random = new Random();
    this.sombreroGanador = random.nextInt(3) + 1;
    int j;
    do {
      System.out.print("Indique la cantidad de jugadores que participaran (max. 3): ");
      j = Integer.parseInt(scan.nextLine());
    } while (j < 1 || j > 3);
    for (int i = 1; i <= j; i++) {
      agregarJugador(scan);
    }
  }

  private void agregarJugador(Scanner scan) {
    System.out.print("Ingrese el nombre del jugador: ");
    String nombre = scan.nextLine();
    System.out.print("Ingrese la cantidad de dinero que posee: ");
    double dinero = Double.parseDouble(scan.nextLine());
    Jugador jugador = new Jugador(nombre, dinero);
    this.jugadores.add(jugador);
  }

  private void anunciarGanadores(Scanner scanner, double[] apuestas, int[] elecciones) {
    for (int i = 0; i < this.jugadores.size(); i++) {
      if (elecciones[i] == this.sombreroGanador) {
        System.out.println("Felicidades " + this.jugadores.get(i).getNombre() + ". Has ganado!");
        jugadores.get(i).setDinero(jugadores.get(i).getDinero() + apuestas[i] * 2);
      } else {
        System.out.println("Has perdido " + this.jugadores.get(i).getNombre() + "!");
      }
      System.out.println("Te quedan $" + this.jugadores.get(i).getDinero() + " en tu bolsillo.");
      System.out.println("Continuaras jugando?");
      System.out.println("1- Si");
      System.out.println("2- No");
      System.out.print("Su eleccion: ");
      int seguira = Integer.parseInt(scanner.nextLine());
      if (seguira != 1) {
        this.jugadores.remove(i);
        --i;
      }
    }
  }
}
