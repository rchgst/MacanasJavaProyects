public class CajaDeAhorro {

  private float saldo;
  private int cantExtraciones;
  private final static int MAX_EXTRACCIONES = 15;

  public float getSaldo() {
    return this.saldo;
  }

  public void setSaldo(float saldo) {
    this.saldo = saldo;
  }

  public int getCantExtraciones() {
    return this.cantExtraciones;
  }

  public void setCantExtraciones(int cantExtraciones) {
    this.cantExtraciones = cantExtraciones;
  }

  public static int getMaxExtracciones() {
    return CajaDeAhorro.MAX_EXTRACCIONES;
  }

  public CajaDeAhorro(float saldo) {
    this.saldo = saldo;
  }

  public CajaDeAhorro() {
  }

  public void deposito(float monto) {
    setSaldo(getSaldo() + monto);
    System.out.println("Se ha depositado $" + monto + " en su cuenta");
  }

  public void extraccion(float monto) {
    if (getCantExtraciones() <= getMaxExtracciones() && monto <= getSaldo()) {
      setSaldo(getSaldo() - monto);
      ++this.cantExtraciones;
      System.out.println("Se extrajo " + monto + " de su cuenta");
    } else {
      System.out.println("Ha superado la cantidad de extracciones de este mes o no tiene ese monto disponible!");
    }
  }

  public void consultaSaldo() {
    System.out.println("Su saldo es: $" + getSaldo());
  }

  public static void main(String[] args) {
    CajaDeAhorro caja1 = new CajaDeAhorro(100);
    CajaDeAhorro caja2 = new CajaDeAhorro();
    caja1.consultaSaldo();
    caja2.setSaldo(200);
    caja2.deposito(100);
    caja1.extraccion(200);
    caja1.deposito(300);
    caja2.extraccion(100);
    caja1.consultaSaldo();
    caja2.consultaSaldo();
  }
}
