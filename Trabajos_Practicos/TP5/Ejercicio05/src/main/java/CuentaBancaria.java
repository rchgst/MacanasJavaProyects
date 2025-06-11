public class CuentaBancaria {
  private int numero;
  private String titular;
  private double saldo;
  private int maxExtr;
  private int cantExtr;

  public CuentaBancaria(int numero, String titular, int maxExtr) {
    this.numero = numero;
    this.titular = titular;
    this.maxExtr = maxExtr;
  }

  public double getSaldo() {
    return this.saldo;
  }

  public void depositar(double monto) {
    this.saldo += monto;
  }

  public boolean extraer(double monto) {
    if (monto > this.saldo) {
      return false;
    } else if (this.cantExtr != this.maxExtr) {
      this.saldo -= monto;
      ++this.cantExtr;
      return true;
    } else {
      System.out.println("Llego al limite maximo de extracciones");
      return false;
    }
  }

  public void mostrarDatos() {
    System.out.print("Numero de cuenta: " + this.numero);
    System.out.println("\t Titular: " + this.titular);
    System.out.println("Saldo: " + this.saldo);
  }
}
