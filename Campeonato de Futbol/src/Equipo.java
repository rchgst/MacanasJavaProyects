import java.util.ArrayList;

public class Equipo {
    private String nombre;
    private ArrayList<Jugador> jugadores;
    private Tecnico tecnico;
    private ArrayList<Partido> partidos;

    public Equipo(Tecnico tecnico, String nombre){
        this.jugadores = new ArrayList<Jugador>();
        this.tecnico= tecnico;
        this.partidos = new ArrayList<Partido>();
        this.nombre= nombre;
    }

    public void agregarJugador(Jugador jugador){
        if(!this.jugadores.contains(jugador)){
            this.jugadores.add(jugador);
        }
    }
    public void eliminarJugador(Jugador jugador){
        this.jugadores.remove(jugador);
    }
    public void agregarPartido(Partido partido){
        this.partidos.add(partido);
    }
    @Override
    public String toString() {
        String cadena="";
        cadena += "Equipo: "+ this.nombre+"\n" +this.tecnico.toString();
        cadena += "Partidos: "+"\n";
        for (int j = 0; j < this.partidos.size(); j++) {
            cadena += this.partidos.get(j).toString();
        }
        cadena += "Jugadores: "+ "\n";
        for (int i = 0; i < this.jugadores.size(); i++) {
            cadena += this.jugadores.get(i).toString();
        }
        return cadena;
    }
}
