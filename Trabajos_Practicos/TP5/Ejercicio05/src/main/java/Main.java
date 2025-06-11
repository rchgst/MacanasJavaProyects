import java.util.Random;

public class Main {
  public static void main(String[] args) {
    // ListaEnteros lista = new ListaEnteros();
    Random random = new Random();
    // int numero = random.nextInt(100);
    // for (int i = 0; i < 10; i++) {
    // lista.meter(numero);
    // numero = random.nextInt(100);
    // }
    // lista.mostrar();
    // lista.ordenar();
    // lista.mostrar();
    ListadeCuenta lista = new ListadeCuenta();
    for (int i = 0; i < 6; i++) {
      CuentaBancaria cuentaBancaria = new CuentaBancaria(i, "Titular " + i, 10);
      cuentaBancaria.depositar(random.nextInt(5000) + 1);
      lista.meter(cuentaBancaria);
    }
    lista.mostrar();
  }
}
