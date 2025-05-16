public class TestEj3 {
  public static void main(String[] args) {
    System.out.println("serie aritmetica con incr por defecto ");
    ProgresionArit progUno = new ProgresionArit();
    progUno.imprProgresion(10);
    System.out.println("serie aritmetica con incre de 7 ");
    ProgresionArit progDos = new ProgresionArit(7);
    progDos.imprProgresion(10);
  }
}
