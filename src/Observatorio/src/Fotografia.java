import java.util.Random;

public class Fotografia {

    protected int[][] foto;

    public Fotografia(int[][] foto){
        this.foto = foto;
    }

    public void almacenar(){
        Random rnd = new Random();
        this.foto = new int[this.foto.length][this.foto[0].length];
        for(int i=0;i<this.foto.length;i++){
            for(int j=0;j<this.foto[0].length;j++){
                this.foto[i][j] = rnd.nextInt(256);
            }
        }
    }

    public boolean validaPunto(int i, int j){
        return i > 0 && i < foto.length - 1 && j > 0 && j < foto[0].length - 1;
    }

    public boolean validaEstrella(int i, int j){
        int suma = foto[i][j] + foto[i-1][j] + foto[i+1][j] + foto[i][j-1] + foto[i][j+1];
        return suma > 600;
    }

    public char[][] tablaDeEstrella(){
        char[][] matrizEstrella = new char[foto.length][foto[0].length];

        for(int i = 0; i < foto.length; i++){
            for(int j = 0; j < foto[0].length; j++){
                if(validaPunto(i, j) && validaEstrella(i, j)){
                    matrizEstrella[i][j] = '*';
                } else {
                    matrizEstrella[i][j] = ' ';
                }
            }
        }

        return matrizEstrella;
    }

    public void imprimir(char[][] estrellas){
        for (int i = 0; i < estrellas.length; i++) {
            for (int j = 0; j < estrellas[0].length; j++) {
                System.out.print(estrellas[i][j] + " ");
            }
            System.out.println();
        }
    }

}
