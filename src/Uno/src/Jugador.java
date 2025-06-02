import java.util.ArrayList;
import java.util.Scanner;

public class Jugador {
    private ArrayList<Carta> mano;
    private int cantCartas;
    private String nombre;


    public Jugador(ArrayList<Carta> mano,String nombre){
        this.mano = mano;
        this.cantCartas = mano.size();
        this.nombre = nombre;
    }

    public boolean estaEnMano(Carta carta){
        for (int i=0;i<cantCartas;i++){
            if(mano.get(i).igualCarta(carta))
                return true;
        }
        return false;
    }

    public void mostrarMano(){
        System.out.println();
        for (int i=0;i<cantCartas;i++){
            System.out.print("carta nro "+ i +"  |"+ mano.get(i)+"|  ");
        }
        System.out.println();
    }

    public void jugar(int carta){
        for (int i=0;i<cantCartas;i++){
            if(mano.get(i).igualCarta(mano.get(carta))){
                mano.remove(i);
                --cantCartas;
                return;
            }
        }
        System.out.println("carta no encontrada");
    }

    public Carta getCarta(int pos){
        return mano.get(pos);
    }

    public int retornaJugada(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("elige la carta a jugar ingresando el numero de la posicion: ");
        this.mostrarMano();
        System.out.println("elige -1 si quiere levantar del maso");
        int opc = scanner.nextInt();
        if(opc != -1)
            return opc;
        return -1;
    }

    public void tomarCarta(Carta carta){
        mano.add(carta);
        cantCartas++;
    }

    public String getNombre(){
        return nombre;
    }

    public int getCantCartas(){
        return mano.size();
    }

    public String toString(){
        return nombre;
    }

}
