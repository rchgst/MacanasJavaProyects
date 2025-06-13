public class Main {
  public static void main(String[] args) {
    Jubilado jubilado = new Jubilado(34000, 3600, "Javier", "Geron", 78);
    System.out.println("Esperanza de vida de " + jubilado.getNombre() + ": " + jubilado.esperanzaDeVida());
    System.out.println("Estimacion de capital de " + jubilado.getNombre() + ": " + jubilado.estimarCapital());
  }
}
