import java.util.ArrayList;

public class ListadoJugadores {
    private ArrayList<Jugador> jugadores;

    public ListadoJugadores(){
        this.jugadores=new ArrayList<Jugador>();
    }
    public void agregarJugador(Jugador x){
        this.jugadores.add(x);
    }
    public void imprimirLista(){
        for(int i=0;i<this.jugadores.size();i++)
            System.out.println(this.jugadores.get(i));
    }
    public double importeTotalNominaJugadores(Fecha hasta){
        double ac=0;
        for (int i=0;i<this.jugadores.size();i++)
            ac+=this.jugadores.get(i).importeNominal(hasta);
        return ac;
    }
}
