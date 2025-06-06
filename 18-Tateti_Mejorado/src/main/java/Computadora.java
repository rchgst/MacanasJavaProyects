import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Computadora extends Jugador {
  public Computadora(int marca) {
    super(marca);
  }

  @Override
  public String hacerMovimiento(Tablero tablero, Scanner scanner) {
    String mejorMovimiento = buscarMovimientoGanador(tablero, getMarca());
    if (mejorMovimiento != null) {
      return mejorMovimiento;
    }
    int marcaHumano = (getMarca() == 1) ? -1 : 1;
    mejorMovimiento = buscarMovimientoGanador(tablero, marcaHumano);
    if (mejorMovimiento != null) {
      return mejorMovimiento;
    }
    if (tablero.getValor(1, 1) == 0) {
      return "11";
    }
    mejorMovimiento = tomarEsquina(tablero);
    if (mejorMovimiento != null) {
      return mejorMovimiento;
    }
    ArrayList<String> disponibles = tablero.getMovimientosDisponibles();
    return disponibles.get(new Random().nextInt(disponibles.size()));
  }

  private String buscarMovimientoGanador(Tablero tablero, int marca) {
    ArrayList<String> disponibles = tablero.getMovimientosDisponibles();
    String movGanador = null;
    int i = 0;
    String movimiento = null;
    while (i < disponibles.size() && movGanador == null) {
      movimiento = disponibles.get(i);
      tablero.setValor(Integer.parseInt(movimiento) / 10, Integer.parseInt(movimiento) % 10, marca);
      if (tablero.verificarGanador() == marca) {
        movGanador = movimiento;
      }
      tablero.setValor(Integer.parseInt(movimiento) / 10, Integer.parseInt(movimiento) % 10, 0);
      ++i;
    }
    return movGanador;
  }

  private String tomarEsquina(Tablero tablero) {
    ArrayList<String> esquinas = new ArrayList<>();
    esquinas.add("00");
    esquinas.add("02");
    esquinas.add("20");
    esquinas.add("22");
    ArrayList<String> disponibles = new ArrayList<>();
    for (String string : esquinas) {
      if (tablero.getValor(Integer.parseInt(string) / 10, Integer.parseInt(string) % 10) == 0) {
        disponibles.add(string);
      }
    }
    if (!(disponibles.isEmpty())) {
      return disponibles.get(new Random().nextInt(disponibles.size()));
    }
    return null;
  }
}
