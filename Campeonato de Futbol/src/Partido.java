import java.time.LocalTime;
import java.util.ArrayList;

public class Partido {
    private Fecha fechaDelPartido;
    private String quipoRival;
    private int golesHechos;
    private int golesRecibidos;
    private String nomCompetencia;
    private TiempoPartido tiempoJuagodo;
    private ArrayList<Jugador> jugadoresConAmarilla;
    private ArrayList<Jugador> jugadoresExpulsados;

    public Partido(String equipoRival,int golesHechos,int golesRecibidos,String nomCompetencia,TiempoPartido tiempoJuagodo,Fecha fechaDelPartido){
        this.quipoRival= equipoRival;
        this.golesHechos= golesHechos;
        this.golesRecibidos= golesRecibidos;
        this.nomCompetencia= nomCompetencia;
        this.tiempoJuagodo= tiempoJuagodo;
        this.jugadoresConAmarilla = new ArrayList<Jugador>();
        this.jugadoresExpulsados = new ArrayList<Jugador>();
        this.fechaDelPartido= fechaDelPartido;
    }

    public void setJugadorConAmarilla(Jugador jugador) {
        jugadoresConAmarilla.add(jugador);
    }
    public void JugadoresExpulsados(){
        for (int i = 0; i < jugadoresConAmarilla.size(); i++) {
            Jugador bus = jugadoresConAmarilla.get(i);
            int cont = 0;
            for (int j = 0; j < jugadoresConAmarilla.size(); j++) {
                if(bus.equals(jugadoresConAmarilla.get(j))){
                    cont++;
                }
            }
            if (cont == 2) {
                jugadoresExpulsados.add(bus);
            }
        }
    }

    @Override
    public String toString() {
        String cadena="";
        cadena += "Comepetencia jugada: "+ this.nomCompetencia+"\n"+"Equipo Rival: "+ this.quipoRival +"\n";
        cadena += "Fecha del partido: " + this.fechaDelPartido.toString()+ "\n" + "Tiempo Jugado: " + this.tiempoJuagodo.toString() + "\n";
        cadena += "Goles Hechos: " + this.golesHechos+"\n"+"Goles Recividos: "+ this.golesRecibidos+"\n";
        cadena += "Jugadores amonestados: " + this.jugadoresConAmarilla.size()+"\n"+"Jugadores Expulsados: "+ this.jugadoresExpulsados.size()+"\n";
        return  cadena;
    }
}
