import java.util.ArrayList;
import java.util.Scanner;

public class Usuario extends Jugador{

    public Usuario(ArrayList<Integer>posicionesDisp,Tablero matriz){
        super(posicionesDisp,matriz);
    }



    public int generarJugada(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("ingrese la posicion que desea jugar: "+this.posicionesDisp);

        int posicion = Integer.parseInt(entrada.nextLine());
        return posicion;
    }
}
