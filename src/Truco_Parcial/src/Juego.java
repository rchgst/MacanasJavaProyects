public class Juego {
    private Jugador[] jugadores;
    private Carta[] cartas;

    public Juego(){
        this.jugadores = new Jugador[4];
        this.cartas = new Carta[3];
    }

    public void reparteCartas(){
        for (int i=0;i<4;i++){
            jugadores[i].generaCartas();
        }
    }

    public void manosFlor(){
        boolean band=false;
        for(int i=0;i<4;i++){
            if(jugadores[i].flor()){
                System.out.println("mano con flor: "+jugadores[i]);
                band=true;
            }
        }
        if(band==false)
            System.out.println("ninguna mano tiene flor");
    }

    public void setJugador(int pos,Jugador jugador){
        this.jugadores[pos] = jugador;
    }

    public Jugador getJugador(int pos){
        return this.jugadores[pos];
    }

    public void mostrar(){
        for (int i=0;i<4;i++)
            System.out.println(jugadores[i]);
    }

}
