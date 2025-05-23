import java.util.ArrayList;
public class EquipoF5 {
    private ArrayList<Jugadores> Jugadores;

    public EquipoF5(){
        super();
        this.Jugadores= new ArrayList<>();
    }
    public void AgregaJugador(Jugadores Jugador){
        this.Jugadores.add(Jugador);
    }
    public void EliminaJugador(Jugadores Jugador){
        this.Jugadores.remove(Jugador);
    }
    public String toString(){
        int i;
         String FichaJugadores ="\nla ficha del equipo es:  ";
         for(i=0;i<Jugadores.size();i++){
               FichaJugadores=Jugadores.toString();}
         return FichaJugadores;
    }
}