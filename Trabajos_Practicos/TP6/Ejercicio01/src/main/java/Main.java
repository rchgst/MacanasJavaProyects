public class Main {
  public static void main(String[] args) {
    Linea linea1 = new Linea(0, 0, 4, 4);
    Linea linea2 = new Linea(1, 0, 5, 3);
    System.out.println("Es la primera linea igual a la segunda? " + linea1.esIgual(linea2));
    System.out.println("Es la primera linea mas grande que la segunda? " + linea1.esMasGrande(linea2));
    System.out.println("Es la primera linea mas chica que la segunda? " + linea1.esMasChico(linea2));
  }
}
