public class TCredito {
  private String numero;
  private String nombre;
  private String banco;
  private double balance;
  private double limite;

  public TCredito(String vnumero, String vnombre, String vbanco, double vbalance, double vlimite) {
    this.limite = vlimite;
    this.numero = vnumero;
    this.nombre = vnombre;
    this.banco = vbanco;
    this.balance = vbalance;
  }

  public String getNumero() {
    return this.numero;
  }

  public String getNombre() {
    return this.nombre;
  }

  public String getBanco() {
    return this.banco;
  }

  public double getBalance() {
    return this.balance;
  }

  public double getLimite() {
    return this.limite;
  }

  public boolean puedoComprar(double vprecio) {
    if (vprecio + this.balance > this.limite) {
      return false;
    } else {
      this.balance += vprecio;
      return true;
    }
  }

  public void pagarTarjeta(double vmonto) {
    this.balance -= vmonto;
  }

  public void muestraDatos() {
    System.out.println("numero = " + getNumero());
    System.out.println("nombre = " + getNombre());
    System.out.println("banco = " + getBanco());
    System.out.println("balance = $" + getBalance());
    System.out.println("limite = $" + getLimite());
  }

  public void aumentarBalance(double monto) {
    this.balance += monto;
  }

}

class Tarjeta {
  public static void main(String[] args) {
    TCredito JPTarjeta = new TCredito("666", "JPerez", "BcoPatagonia", 2000, 10000);
    TCredito DMTarjeta = new TCredito("777", "DMaradona", "BcoGalicia", 5000, 100000);
    JPTarjeta.muestraDatos();
    if (JPTarjeta.puedoComprar(16000)) {
      JPTarjeta.pagarTarjeta(16000);
      System.out.println("La compra se pudo realizar con exito!");
    } else {
      System.out.println("No se puede realizar esta compra");
    }
    System.out.println("DMTarjeta, debe pagar su deuda!");
    DMTarjeta.aumentarBalance(1500);
    DMTarjeta.muestraDatos();
  }
}
