import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();
        MaxPooling matriz = new MaxPooling(4, 6);

        for (int i = 0; i < matriz.getNumFilas(); i++) {
            for (int j = 0; j < matriz.getNumColumnas(); j++) {
                matriz.setValor(i, j, (char) ('A' + rnd.nextInt(26)));
            }
        }

        System.out.println("MATRIZ ORIGINAL:");
        System.out.println(matriz); // usa el toString() que vos hiciste

        matriz.maxPoolear(2);

        System.out.println(matriz.toStringPooleada()); // imprimí la pooleada por separado
    }
}
