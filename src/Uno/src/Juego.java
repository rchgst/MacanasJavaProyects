import java.util.ArrayList;
import java.util.Scanner;

public class Juego {
    private Mazo mazo;
    private ArrayList<Jugador> jugadores;
    private Control control;
    private Scanner scanner;

    public Juego() {
        mazo = new Mazo();
        mazo.generarMazo();
        jugadores = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void agregaJugador(String nombre) {
        ArrayList<Carta> cartas = mazo.reparte();
        Jugador jugador = new Jugador(cartas, nombre);
        jugadores.add(jugador);
    }

    public void iniciaJuego() {
        int cantJugadores=2;

        mazo.mezclaMazo();

        for (int i = 0; i < cantJugadores; i++) {
            System.out.println("Ingrese el nombre del jugador " + (i + 1) + ":");
            String nombre = scanner.nextLine();
            this.agregaJugador(nombre);
        }

        System.out.println("Mezclando el mazo y repartiendo las cartas ...");

        control = new Control(0, true, mazo.sacaCarta(), cantJugadores,false);

        System.out.println("El juego está listo para iniciar, comienza el jugador 1: " + jugadores.get(0));
        System.out.println("Carta en el pozo: " + control.getPozo());
    }

    public boolean preJugada() {
        int turno = control.getTurno();
        if (control.getPozo() instanceof CartaEspecial && control.getFlujopozo()) {
            if (control.pozoAdd()) {
                int suma = control.cuantoSuma();
                System.out.println("El jugador " + jugadores.get(turno) + " agarra " + suma + " cartas y pierde el turno.");
                for (int i = 0; i < suma; i++)
                    jugadores.get(turno).tomarCarta(mazo.sacaCarta());
                control.siguienteTurno();
                control.ajusteTurno();
                return false;
            }

            if (control.pozoReverse()) {
                System.out.println("___Se invierte la ronda___");
                control.cambioFlujo();
                control.siguienteTurno();
                control.ajusteTurno();
                return false;
            }

            if (control.pozoBlock()) {
                System.out.println("Jugador " + jugadores.get(turno) + " bloqueado");
                control.siguienteTurno();
                control.ajusteTurno();
                return false;
            }
        }
        return true;
    }

    public void jugada() {
        int turno = control.getTurno();
        System.out.println("Juega el jugador: " + jugadores.get(turno));
        control.setFlujoPozo();
        if (this.preJugada()) {
            System.out.println("Elija la posición de la carta que desea jugar, las cartas de su mano son:");
            jugadores.get(turno).mostrarMano();

            int jugada;
            do {
                jugada = jugadores.get(turno).retornaJugada();
                if (jugada == -1) break;

                if (jugada < 0 || jugada >= jugadores.get(turno).getCantCartas()) {
                    System.out.println("Índice inválido. Intente de nuevo.");
                } else if (!control.validaJugada(jugadores.get(turno).getCarta(jugada))) {
                    System.out.println("Por favor ingrese una jugada válida. La carta no coincide con el pozo.");
                    System.out.println("La carta del pozo es: " + control.getPozo());
                } else {
                    break; // jugada válida
                }
            } while (true);

            if (jugada == -1) {
                System.out.println("Tomando una carta del mazo");
                jugadores.get(turno).tomarCarta(mazo.sacaCarta());
            } else {
                control.setPozo(jugadores.get(turno).getCarta(jugada));
                jugadores.get(turno).jugar(jugada);

                if (control.pozoNegro()) {
                    int opc;
                    do {
                        System.out.println("Jugador " + jugadores.get(turno) + ", elija el nuevo color:");
                        System.out.println("Opciones:\n\t0: Rojo\n\t1: Verde\n\t2: Azul\n\t3: Amarillo");
                        opc = scanner.nextInt();
                        if (opc < 0 || opc > 3)
                            System.out.println("Opción inválida, intente de nuevo.");
                    } while (opc < 0 || opc > 3);
                    control.setColorPozo(opc);
                    scanner.nextLine(); // limpiar buffer
                }
            }
            control.siguienteTurno();
            control.ajusteTurno();
        }
    }

    public boolean hayGanador() {
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).getCantCartas() == 0) {
                System.out.println("El jugador: " + jugadores.get(i) + " es el ganador");
                return true;
            }
        }
        return false;
    }

    public boolean mazoConCartas() {
        return mazo.getCantidad() > 0;
    }
}
