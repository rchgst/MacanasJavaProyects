public class TestCirculoRedimensionable {
  public static void main(String[] args) {
    CirculoRedimensionable circulo = new CirculoRedimensionable(5);
    System.out.println("El area del circulo es: " + circulo.getArea());
    System.out.println("El perimetro del circulo es: " + circulo.getPerimetro());
    System.out.println("Ahora el circulo se redimensiona a un 30%");
    circulo.redimensionar(30);
    System.out.println("Area del nuevo circulo: " + circulo.getArea());
    System.out.println("Perimetro del nuevo circulo: " + circulo.getPerimetro());
  }
}
