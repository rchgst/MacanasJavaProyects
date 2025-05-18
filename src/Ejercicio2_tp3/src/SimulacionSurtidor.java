import java.util.Scanner;
import java.util.Random;

public class SimulacionSurtidor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Surtidor surtidor = new Surtidor();

        System.out.print("Ingrese la cantidad de iteraciones: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Iteración " + (i+1) + " ---");
            System.out.println("UltraDiesel disponible: " + surtidor.getCantUDiesel());
            System.out.println("EuroDiesel disponible: " + surtidor.getCantEDiesel());
            System.out.println("Nafta Súper disponible: " + surtidor.getCantNSuper());
            System.out.println("Nafta Infinia disponible: " + surtidor.getCantInfinia());

            int opcion = random.nextInt(24) + 1;

            switch (opcion) {
                case 1,2,3,4,5 -> {
                    System.out.print("Ingrese litros a cargar de UltraDiesel: ");
                    int litros = scanner.nextInt();
                    surtidor.cargarUDiesel(litros);
                }
                case 6,7,8,9,10 -> {
                    System.out.print("Ingrese litros a cargar de EuroDiesel: ");
                    int litros = scanner.nextInt();
                    surtidor.cargarEDiesel(litros);
                }
                case 11,12,13,14,15 -> {
                    System.out.print("Ingrese litros a cargar de Nafta Súper: ");
                    int litros = scanner.nextInt();
                    surtidor.cargarNSuper(litros);
                }
                case 16,17,18,19,20 -> {
                    System.out.print("Ingrese litros a cargar de Nafta Infinia: ");
                    int litros = scanner.nextInt();
                    surtidor.cargarInfinia(litros);
                }
                case 21 -> {
                    surtidor.llenarDepositoUDiesel();
                    System.out.println("UltraDiesel rellenado al máximo.");
                }
                case 22 -> {
                    surtidor.llenarDepositoEDiesel();
                    System.out.println("EuroDiesel rellenado al máximo.");
                }
                case 23 -> {
                    surtidor.llenarDepositoNSuper();
                    System.out.println("Nafta Súper rellenada al máximo.");
                }
                case 24 -> {
                    surtidor.llenarDepositoInfinia();
                    System.out.println("Nafta Infinia rellenada al máximo.");
                }
            }
        }

        scanner.close();
    }
}
