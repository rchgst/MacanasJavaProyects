public class MaxPooling extends Matriz {
    public char[][] matrizPooleada;
    public MaxPooling(int M, int N) {
        super(M, N);
    }

    public void maxPoolear(int N) {
        if (this.numColumnas % N == 0 && this.numFilas % N == 0) {
            int nf, nc;
            char may;
            nf = this.numFilas / N;
            nc = this.numColumnas / N;
            int x, i, y, j;
            this.matrizPooleada= new char[nf][nc];
            for (x = 0; x < this.numFilas; x += N) {
                for (y = 0; y < this.numColumnas; y += N) {
                    may = this.matriz[x][y];
                    for (i = x; i < x + N; i++) {
                        for (j = y; j < y + N; j++) {
                            if (this.matriz[i][j] > may)
                                may = this.matriz[i][j];
                        }
                    }
                   this.matrizPooleada[x / N][y / N] = may;
                }
            }
        }
        else
            System.out.println("\nNo se puede aplicar maxPooling ");
    }

    @Override
    public String toString() {
        return super.toString(); // Mostrá solo la matriz original como vos querías
    }

    public String toStringPooleada() {
        String aux = "MATRIZ POOLEADA:\n";
        if (matrizPooleada == null) {
            aux += "MaxPooling no aplicado aún.\n";
        } else {
            for (int i = 0; i < matrizPooleada.length; i++) {
                for (int j = 0; j < matrizPooleada[0].length; j++) {
                    aux += matrizPooleada[i][j] + "\t";
                }
                aux += "\n";
            }
        }
        return aux;
    }
}