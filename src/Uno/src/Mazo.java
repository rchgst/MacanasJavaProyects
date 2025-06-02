import java.util.ArrayList;
import java.util.Collections;

public class Mazo {
    private ArrayList<Carta> cartas;

    public Mazo() {
        this.cartas = new ArrayList<>();
    }

    public void mezclaMazo() {
        Collections.shuffle(this.cartas);
    }

    public Carta sacaCarta() {
        if (!cartas.isEmpty()) {
            Carta aux = cartas.get(0);
            cartas.remove(0);
            return aux;
        } else {
            return null; // O lanzar excepción si lo preferís
        }
    }

    public ArrayList<Carta> reparte() {
        ArrayList<Carta> cartasJugador = new ArrayList<>();
        for (int i = 0; i < 7 && !cartas.isEmpty(); i++) {
            cartasJugador.add(this.sacaCarta());
        }
        return cartasJugador;
    }

    public void generarMazo() {
        cartas.clear(); // Limpiar por si ya tenía contenido

        // Colores: 0 = rojo, 1 = verde, 2 = azul, 3 = amarillo
        for (int color = 0; color < 4; color++) {
            cartas.add(new CartaComun(color, 0)); // Una sola carta 0

            for (int num = 1; num <= 9; num++) {
                cartas.add(new CartaComun(color, num));
                cartas.add(new CartaComun(color, num));
            }

            for (int i = 0; i < 2; i++) {
                cartas.add(new CartaEspecial(color, 0)); // Reversa
                cartas.add(new CartaEspecial(color, 1)); // Bloqueo
                cartas.add(new CartaEspecial(color, 2)); // +2
            }
        }

        // Cartas negras: +4 y cambiar color
        for (int i = 0; i < 4; i++) {
            cartas.add(new CartaEspecial(4, 3)); // +4
            cartas.add(new CartaEspecial(4, 4)); // Cambiar color
        }
    }

    public int getCantidad() {
        return cartas.size();
    }
}
