public class Main {
    public static void main(String[] args) {
        char[][] datos = {
                {'A', 'C', 'B', 'Z', '2', '4'},
                {'D', 'E', 'F', 'Y', '3', '1'},
                {'G', 'H', 'I', 'X', '0', '5'},
                {'J', 'K', 'L', 'W', '7', '6'},
                {'M', 'N', 'O', 'V', '8', '9'},
                {'P', 'Q', 'R', 'U', 'A', 'B'},
                {'S', 'T', 'U', 'T', 'C', 'D'},
                {'V', 'W', 'X', 'S', 'E', 'F'},
                {'Y', 'Z', '0', 'R', 'G', 'H'}
        };


        MaxPooling mp = new MaxPooling(datos);
        int N = 3;
        Matriz resultado = mp.matrizMP(N);

        System.out.println("Matriz original:");
        imprimirMatriz(datos);

        System.out.println("\nMatriz maxpooleada con N = " + N + ":");
        imprimirMatriz(resultado.getMatriz());
    }

    public static void imprimirMatriz(char[][] matriz) {
        for (char[] fila : matriz) {
            for (char c : fila) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
