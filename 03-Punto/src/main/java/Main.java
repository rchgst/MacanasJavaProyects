public class Main {
  public static void main(String[] args) {
    Punto principal = new Punto();
    principal.setX(3.5);
    principal.setY(5);
    System.out.println("Punto principal: (" + principal.getX() + "," + principal.getY() + ")");
    Punto aux = new Punto(4, 4);
    System.out.println("Punto auxiliar: (" + aux.getX() + "," + aux.getY() + ")");
    System.out.println("Distancia euclidea entre el punto principal y el aux: " + principal.distanciaEuclidea(aux));
    aux = new Punto(-4, -5);
    System.out.println("Punto auxiliar: (" + aux.getX() + "," + aux.getY() + ")");
    System.out.println("Esta dentro del radio? " + principal.estaDentroRadio(aux, 5.5));
  }
}
