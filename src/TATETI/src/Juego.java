import java.util.ArrayList;
import java.util.Arrays;

public class Juego {
    protected  Tablero matriz;
    protected ArrayList<Integer>posicionesDisp;

    public Juego(Tablero matriz,ArrayList<Integer> posicionesDisp){
        this.matriz = matriz;
        this.posicionesDisp = posicionesDisp;
    }

    public void juegaU(int pos) {
        this.matriz.tablero[pos/10][pos%10] = 1;
        this.posicionesDisp.remove(this.posicionesDisp.indexOf(pos));
    }

    public void juegaC(int pos) {
        this.matriz.tablero[pos/10][pos%10] = -1;
        this.posicionesDisp.remove(this.posicionesDisp.indexOf(pos));
    }

    public boolean ganadorU(){
        return this.matriz.recorreFila(3,1) || this.matriz.recorreCol(3,1)||this.matriz.recorreDiagP(3,1) || this.matriz.recorrerDiagS(3,1);
    }
    public boolean ganadorC(){
        return this.matriz.recorreFila(3,-1) || this.matriz.recorreCol(3,-1)||this.matriz.recorreDiagP(3,-1) || this.matriz.recorrerDiagS(3,-1);
    }

    public boolean juegoTerminado(){
        return this.ganadorU()||this.ganadorC() || this.matriz.tableroCompleto();
    }

    public void mostrarTablero() {
        for (int i = 0; i < 3; i++) {
            // Imprimir cada fila con separadores de columnas
            for (int j = 0; j < 3; j++) {
                if (this.matriz.tablero[i][j] == 1) {
                    System.out.print(" X ");
                } else if (this.matriz.tablero[i][j] == -1) {
                    System.out.print(" O ");
                } else {
                    System.out.print("   ");
                }

                // Agregar separador de columnas, excepto al final
                if (j < 2) {
                    System.out.print("|");
                }
            }

            System.out.println(); // Fin de fila

            // Agregar separador de filas, excepto al final
            if (i < 2) {
                System.out.println("---+---+---");
            }
        }
        System.out.println();
        System.out.println();
    }

}

