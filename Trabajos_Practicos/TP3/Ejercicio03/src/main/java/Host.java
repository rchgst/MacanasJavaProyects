public class Host {
  private Direccion direccion;
  private Red redAsociada;

  public Direccion getDireccion() {
    return this.direccion;
  }

  public Red getRedAsociada() {
    return this.redAsociada;
  }

  public Host() {
  }

  public Host(Direccion direccion) {
    this.direccion = direccion;
  }

  public void conectar(Red red) {
    if (this.direccion.getX() == red.getDireccion().getX()) {
      this.redAsociada = red;
      System.out.println("Host conectado a la red!");
    } else {
      System.out.println("No se puede realizar la conexion con esta red!");
    }
  }
}
