import java.util.ArrayList;

public class Computadora extends Jugador {
    protected Algoritmo algoritmo;

    public Computadora(ArrayList<Integer>posicionesDisp,Tablero matriz,Algoritmo algoritmo){
        super(posicionesDisp,matriz);
        this.algoritmo = algoritmo;
    }

    private int jugadaAleatoria(){
        int tam = posicionesDisp.size();
        int aleatorio=(int)(Math.random() * tam);
        return this.posicionesDisp.get(aleatorio);
    }
    private int jugadaInteligente(){
        this.algoritmo = new Algoritmo(this.matriz);
        int analizaF = this.matriz.recorreFila(2);
        int analizaC = this.matriz.recorreCol(2);
        boolean analizaDP = this.matriz.recorreDiagP(2);
        boolean analizaDS = this.matriz.recorrerDiagS(2);
        int jugada;

        if(analizaF != -1){
            jugada = this.algoritmo.busFaltanteFila(analizaF);
            return jugada;
        }
        if(analizaC != -1){
            jugada = this.algoritmo.busFaltanteCol(analizaC);
            return jugada;
        }
        if(analizaDP == true){
            jugada = this.algoritmo.busFaltanteDiagP();
            return jugada;
        }
        if(analizaDS == true){
            jugada = this.algoritmo.busFaltanteDiagS();
            return jugada;
        }
        return -1;
    }



    public int generarJugada(){
        int jugada;
        jugada = this.jugadaInteligente();
        if(jugada != -1){
            return jugada;
        }
        jugada = this.jugadaAleatoria();
        return jugada;
    }

}
