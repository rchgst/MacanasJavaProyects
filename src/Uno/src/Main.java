public class Main {
    public static void main(String[] args) {
        Juego juego = new Juego();
        juego.iniciaJuego();

        while (!juego.hayGanador() && juego.mazoConCartas()) {

        juego.jugada();
            System.out.println("--------------------------");
        }

        if (!juego.mazoConCartas() && !juego.hayGanador()) {
            System.out.println("No hay más cartas y no hubo ganador. ¡Empate!");
        }

        System.out.println("Fin de la partida.");
    }
}
