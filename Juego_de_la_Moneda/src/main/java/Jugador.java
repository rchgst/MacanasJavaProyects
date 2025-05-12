import java.util.Scanner;

public class Jugador {
  private String nombre;
  private double dinero;

  public String getNombre() {
    return nombre;
  }

  public double getDinero() {
    return dinero;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setDinero(double dinero) {
    this.dinero = dinero;
  }

  public Jugador(String nombre, double dinero) {
    this.nombre = nombre;
    this.dinero = dinero;
  }

  public Jugador() {
  }

  public double apostar() {
    Scanner scanner = new Scanner(System.in);
    double apuesta = 0;
    do {
      System.out.print("Indique la cantidad de dinero a apostar: ");
      apuesta = Double.parseDouble(scanner.nextLine());
      if (apuesta >= getDinero() || apuesta < 0) {
        System.out.println("No tienes esa cantidad de dinero!");
        System.out.println("Dinero actual: " + getDinero());
      }
    } while (apuesta >= getDinero() || apuesta < 0);
    setDinero(getDinero() - apuesta);
    return apuesta;
  }
}
