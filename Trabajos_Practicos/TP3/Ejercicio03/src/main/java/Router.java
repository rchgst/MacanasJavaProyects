import java.util.ArrayList;

public class Router {
  private Direccion direccion;
  private int cantPuertos;
  private ArrayList<Router> routers;
  private ArrayList<Red> redes;

  public Router(Direccion direccion, int cantPuertos) {
    this(cantPuertos);
    this.direccion = direccion;
  }

  public Router(int cantPuertos) {
    this.cantPuertos = cantPuertos;
    this.routers = new ArrayList<>();
    this.redes = new ArrayList<>();
  }

  public Direccion getDireccion() {
    return this.direccion;
  }

  public void setDireccion(Direccion direccion) {
    this.direccion = direccion;
  }

  public int getCantPuertos() {
    return this.cantPuertos;
  }

  public void conectar(Router router) {
    if (this.routers.size() + this.redes.size() < this.cantPuertos) {
      this.routers.add(router);
      System.out.println("Se ha conectado el router con exito!");
    } else {
      System.out.println("No hay puertos disponibles!");
    }
  }

  public void conectar(Red red) {
    if (this.routers.size() + this.redes.size() < this.cantPuertos) {
      this.redes.add(red);
      System.out.println("Se ha conecto la red con exito!");
    } else {
      System.out.println("No hay puertos disponibles!");
    }
  }
}
