import java.util.ArrayList;

public class Jugador {
    protected ArrayList<Integer> posicionesDisp;
    protected Tablero matriz;

    public Jugador(ArrayList<Integer> posicionesDisp,Tablero matriz){
        this.posicionesDisp = posicionesDisp;
        this.matriz = matriz;
    }

    int generarJugada(){
        return 0;
    }
}
