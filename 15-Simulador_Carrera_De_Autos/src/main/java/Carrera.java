import java.util.ArrayList;

public class Carrera {
  private ArrayList<Auto> autos;
  private double distancia;

  public ArrayList<Auto> getAutos() {
    return this.autos;
  }

  public void setAutos(ArrayList<Auto> autos) {
    this.autos = autos;
  }

  public double getDistancia() {
    return distancia;
  }

  public void setDistancia(double distancia) {
    this.distancia = distancia;
  }

  public Carrera() {
    this.autos = new ArrayList<>();
  }

  public Carrera(ArrayList<Auto> autos, double distancia) {
    this.autos = autos;
    this.distancia = distancia;
  }

  public Carrera(double distancia) {
    this();
    this.distancia = distancia;
  }

  public void simular() {
    ArrayList<Auto> puestos = new ArrayList<Auto>();
    ArrayList<Auto> competidores = new ArrayList<Auto>();
    competidores.addAll(this.autos);
    int indice = 0;
    do {
      for (Auto auto : competidores) {
        auto.mover();
        if (auto.getTanque().isVacio() || auto.getTanque().getCapActual() < auto.getMotor().getConsumoXMin()) {
          System.out.println("El auto de " + auto.getConductor().getNombre() + " esta cargando nafta!");
          auto.cargarNafta();
        }
        if (auto.getDistanciaRecorrida() >= this.distancia && !(puestos.contains(auto))) {
          puestos.add(auto);
        }
      }
    } while (puestos.size() < this.autos.size());
    System.out.println("=== La Carrera ha terminado! ===");
    for (int i = 0; i < puestos.size(); i++) {
      System.out.println("Puesto N° " + ++indice + ": " + puestos.get(i).getConductor().getNombre());
    }
  }

  public void cargarCorredores() {
    Conductor corredor1 = new Conductor("Rayo McQueen");
    Conductor corredor2 = new Conductor("Francesco Virgollini");
    Conductor corredor3 = new Conductor("Franco Colapinto");
    Motor motor1 = new Motor(3, 50);
    Motor motor2 = new Motor(5, 70);
    Motor motor3 = new Motor(4.5, 65);
    Tanque tanque1 = new Tanque(100, 100);
    Tanque tanque2 = new Tanque(50, 50);
    Tanque tanque3 = new Tanque(60, 50);
    Auto auto1 = new Auto(corredor1, motor1, tanque1);
    Auto auto2 = new Auto(corredor2, motor2, tanque2);
    Auto auto3 = new Auto(corredor3, motor3, tanque3);
    this.autos.add(auto1);
    this.autos.add(auto2);
    this.autos.add(auto3);
  }
}
