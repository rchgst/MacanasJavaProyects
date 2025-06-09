import java.util.ArrayList;

public class Red {
  private Direccion direccion;
  private ArrayList<Host> hosts;
  private Router routerAsociado;

  public Router getRouterAsociado() {
    return routerAsociado;
  }

  public Direccion getDireccion() {
    return this.direccion;
  }

  public void setDireccion(Direccion direccion) {
    this.direccion = direccion;
  }

  public ArrayList<Host> getHosts() {
    return this.hosts;
  }

  public Red(Direccion direccion) {
    this();
    this.direccion = direccion;
  }

  public Red() {
    this.hosts = new ArrayList<>();
  }

  public void conectar(Router router) {
    this.routerAsociado = router;
  }

  public void conectar(Host host) {
    if (!(this.hosts.contains(host))) {
      this.hosts.add(host);
      System.out.println("Host conectado!");
    } else {
      System.out.println("El host ya se encuentra conectado!");
    }
  }
}
