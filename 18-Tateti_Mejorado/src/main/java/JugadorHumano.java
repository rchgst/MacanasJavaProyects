import java.util.ArrayList;
import java.util.Scanner;

public class JugadorHumano extends Jugador {
  public JugadorHumano(int marca) {
    super(marca);
  }

  @Override
  public String hacerMovimiento(Tablero tablero, Scanner scanner) {
    ArrayList<String> movimientosDisponibles = tablero.getMovimientosDisponibles();
    System.out.println("Movimientos disponibles: ");
    for (int i = 0; i < movimientosDisponibles.size(); i++) {
      System.out.print("[" + movimientosDisponibles.get(i) + "]");
    }
    System.out.println();
    String movimiento = null;
    do {
      System.out.print("Ingrese la celda a marcar: ");
      movimiento = scanner.nextLine();
      if (!(movimientosDisponibles.contains(movimiento))) {
        System.out.println("Movimiento invalido! Intente de nuevo.");
      }
    } while (!(movimientosDisponibles.contains(movimiento)));
    return movimiento;
  }
}
