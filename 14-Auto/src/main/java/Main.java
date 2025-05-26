public class Main {
  public static void main(String[] args) {
    Motor motor1 = new Motor(1, 12, true);
    Tanque tanque1 = new Tanque(15, 5);
    Auto auto1 = new Auto(motor1, tanque1, 15);
    Motor motor2 = new Motor(2, 9, true);
    Tanque tanque2 = new Tanque(25, 5);
    Auto auto2 = new Auto(motor2, tanque2, 200);
    Motor motor3 = new Motor(1.5, 8);
    Tanque tanque3 = new Tanque(20, 5);
    Auto auto3 = new Auto(motor3, tanque3, 0);
    for (int i = 0; i < 5; i++) {
      auto1.mover();
      auto2.mover();
      auto3.mover();
      System.out.println("Distancia recorrida del primer auto: " + auto1.getDistanciaRecorrida());
      System.out.println("Distancia recorrida del segundo auto: " + auto2.getDistanciaRecorrida());
      System.out.println("Distancia recorrida del tercer auto: " + auto3.getDistanciaRecorrida());
    }
    auto1.cargarNafta();
    auto2.cargarNafta();
    auto3.cargarNafta();
    for (int i = 0; i < 5; i++) {
      auto1.mover();
      auto2.mover();
      auto3.mover();
      System.out.println("Distancia recorrida del primer auto: " + auto1.getDistanciaRecorrida());
      System.out.println("Distancia recorrida del segundo auto: " + auto2.getDistanciaRecorrida());
      System.out.println("Distancia recorrida del tercer auto: " + auto3.getDistanciaRecorrida());
    }
  }
}
