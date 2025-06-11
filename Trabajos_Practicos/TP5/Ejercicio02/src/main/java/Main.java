public class Main {
  public static void main(String[] args) {
    Rectangulo rec = new Rectangulo("Rojo", true, 10, 5);
    Circulo cir = new Circulo("Azul", false, 8);
    Cuadrado cuad = new Cuadrado(4, "Rojo", true);
    System.out.println(rec);
    System.out.println(cir);
    System.out.println(cuad);
    System.out.println("Area y Perimetro del rectangulo: " + rec.getArea() + "; " + rec.getPerimetro());
    System.out.println("Area y Perimetro del circulo: " + cir.getArea() + "; " + cir.getPerimetro());
    System.out.println("Area y Perimetro del cuadrado: " + cuad.getArea() + "; " + cuad.getPerimetro());
  }
}
