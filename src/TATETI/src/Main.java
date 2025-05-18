import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
            boolean b=false;
            int jugadaUsuario,jugadaComputadora;
            int[][] matriz = new int[3][3];
            Tablero tablero = new Tablero(matriz);
            Algoritmo algoritmo = new Algoritmo(tablero);
            for(int i=0;i<3;i++){
                for (int j=0;j<3;j++){
                    tablero.tablero[i][j] = 0;
                }
            }

            ArrayList<Integer> posicionesDisp = new ArrayList<>(Arrays.asList(0,1,2,10,11,12,20,21,22));
            Juego partida = new Juego(tablero,posicionesDisp);
            Jugador usuario,compu;
            usuario = new Usuario(posicionesDisp,tablero);
            compu = new Computadora(posicionesDisp,tablero,algoritmo);


            while (partida.juegoTerminado() == false){
                jugadaUsuario = usuario.generarJugada();
                partida.juegaU(jugadaUsuario);
                if (partida.ganadorU()){
                    System.out.println("ganaste");
                    break;
                }
                System.out.println("juega el jugador: ");
                System.out.println();
                partida.mostrarTablero();
                jugadaComputadora = compu.generarJugada();
                partida.juegaC(jugadaComputadora);
                if(partida.ganadorC()){
                    System.out.println("TE GANO LA COMPU JAJJAJAJAJAJAJAJAJAJAJAJAJAJA");
                    break;
                }
                System.out.println("juega la computadora: ");
                System.out.println();
                partida.mostrarTablero();
            }
            System.out.println();
            partida.mostrarTablero();
            System.out.println("El juego a terminado");

        }
    }
