import java.util.Random;
public class Main {
    public static void main(String[] args) {
        int i, j;
        Random rand=new Random();
        char letra;
        Espejo A = new Espejo(2, 2);
        for (i = 0; i < A.getFilas(); i++) {
            for (j = 0; j < A.getColumnas(); j++) {
                letra=(char) ('A'+ rand.nextInt(26));
                A.setValor(i, j, letra);
            }
        }
        System.out.println(A);
        A.invertir();
        System.out.println(A);
    }
}
