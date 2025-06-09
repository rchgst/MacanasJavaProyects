import java.util.Random;
import java.util.Scanner;

public class SimuladorSurtidor {
  public static void main(String[] args) {
    new SimuladorSurtidor().simulador();
  }

  public void simulador() {
    int n = 0;
    System.out.print("Ingrese la cantidad de veces que se repetira el algoritmo de prueba: ");
    Scanner scanner = new Scanner(System.in);
    n = Integer.parseInt(scanner.nextLine());
    for (int i = 0; i < n; i++) {
      testSurtidor();
    }
  }

  public void testSurtidor() {
    Surtidor surtidor1 = new Surtidor();
    System.out.println("=== Cantidad actual en el deposito de cada combustible ===");
    System.out.println("Ultra Diesel: " + surtidor1.getCantUDiesel());
    System.out.println("Euro Diesel: " + surtidor1.getCantEDiesel());
    System.out.println("Nafta Super: " + surtidor1.getCantNSuper());
    System.out.println("Nafta Infinia: " + surtidor1.getCantInfinia());
    Random random = new Random();
    int opcion = random.nextInt(24) + 1;
    int litros = random.nextInt(51) + 10;
    switch (opcion) {
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
        System.out.print("Cuantos litros de Ultra Diesel desea cargar?: ");
        surtidor1.cargarUDiesel(litros);
        break;
      case 6:
      case 7:
      case 8:
      case 9:
      case 10:
        System.out.print("Cuantos litros de Euro Diesel desea cargar?: ");
        surtidor1.cargarEDiesel(litros);
        break;
      case 11:
      case 12:
      case 13:
      case 14:
      case 15:
        System.out.print("Cuantos litros de Nafta Super desea cargar?: ");
        surtidor1.cargarNSuper(litros);
        break;
      case 16:
      case 17:
      case 18:
      case 19:
      case 20:
        System.out.print("Cuantos litros de Nafta Infinia desea cargar?: ");
        surtidor1.cargarInfinia(litros);
      case 21:
        surtidor1.llenarDepositoUDiesel();
        break;
      case 22:
        surtidor1.llenarDepositoEDiesel();
        break;
      case 23:
        surtidor1.llenarDepositoNSuper();
        break;
      case 24:
        surtidor1.llenarDepositoInfinia();
        break;
      default:
        System.out.println("Opcion no reconocida");
        break;
    }
  }
}
