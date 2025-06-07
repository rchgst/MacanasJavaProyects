import java.util.Random;
public class Main {
    public static void main(String[] args) {
        ListaDeCuenta lista = new ListaDeCuenta();
        Random rand = new Random();

        // Crear y agregar cuentas con saldos aleatorios
        for (int i = 1; i <= 5; i++) {
            CuentaBancaria cuenta = new CuentaBancaria(i, "Titular " + i, 5);
            double deposito = 1000 + rand.nextInt(4001); // entre 1000 y 5000
            cuenta.depositar(deposito);
            lista.insertar(cuenta);
        }

        // Mostrar lista ordenada por saldo
        System.out.println("Listado de cuentas ordenadas por saldo:");
        for (int i = 0; i < lista.getTam(); i++) {
            CuentaBancaria c = (CuentaBancaria) lista.lista.get(i); // Acceso directo a lista protegida
            c.mostrarDatos();
            System.out.println("----------------------");
        }
    }
}