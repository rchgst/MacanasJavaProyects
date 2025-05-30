public class Main {
    public static void main(String[] args) {
        Juego juego = new Juego();
        Jugador jugador1 = new Jugador("rich");
        Jugador jugador2 = new Jugador("lean");
        Jugador jugador3 = new Jugador("isa");
        Jugador jugador4 = new Jugador("agus");

        juego.setJugador(0,jugador1);
        juego.setJugador(1,jugador2);
        juego.setJugador(2,jugador3);
        juego.setJugador(3,jugador4);

        juego.reparteCartas();
        System.out.println("manos de los jugadores: ");
        juego.mostrar();

        juego.manosFlor();

    }
}