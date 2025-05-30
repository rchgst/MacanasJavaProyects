import java.util.Random;

public class Jugador {
    private Carta[] cartas;
    private String nombre;
    public Jugador(Carta[] cartas,String nombre){
        this.cartas = cartas;
        this.nombre = nombre;
    }
    public Jugador(String nombre){
        this.cartas = new Carta[3];
        this.nombre = nombre;
    }

    public boolean flor(){
        return cartas[0].mismoPalo(cartas[1]) && cartas[1].mismoPalo(cartas[2]);
    }

    public void generaCartas(){
        Random x = new Random();
        int r=x.nextInt(1,4);
        cartas[0]=new Carta();
        cartas[1]=new Carta();
        cartas[2]=new Carta();
    }

    @Override
    public String toString(){
        return "Jugador: "+nombre + "\npalos de cartas: " + cartas[0] + cartas[1] + cartas[2];
    }

}
