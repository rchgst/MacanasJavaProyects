public class Main {
  public static void main(String[] args) {
    CirculoMovible circulo = new CirculoMovible(0, 0, 4, 4, 3);
    System.out.println(circulo);
    circulo.moverAbajo();
    System.out.println(circulo);
    circulo.moverArriba();
    circulo.moverIzquierda();
    System.out.println(circulo);
    circulo.moverDerecha();
    System.out.println(circulo);
    RectanguloMovible rectangulo = new RectanguloMovible(0, 0, 3, 3, 2, 2);
    rectangulo.moverArriba();
    rectangulo.moverDerecha();
    System.out.println(rectangulo);
    rectangulo.moverIzquierda();
    rectangulo.moverAbajo();
    System.out.println(rectangulo);
  }
}
