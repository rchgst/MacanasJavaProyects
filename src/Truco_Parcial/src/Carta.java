import java.util.Random;

public class Carta {
    private int carta;

    public Carta(){
        Random x = new Random();
        carta = x.nextInt(1,4);
    }

    public boolean mismoPalo(Carta otra){
        return this.carta == otra.carta;
    }

    public int getCarta(){
        return carta;
    }

    public void setCarta(int carta){
        this.carta = carta;
    }

    public String toString(){
        String mensaje = " ";
        switch (carta){
            case 1:
                mensaje +="ESPADA";
                break;
            case 2:
                mensaje += "BASTO";
                break;
            case 3:
                mensaje+="ORO";
                break;
            case 4:
                mensaje+="COPA";
                break;
        }
        return mensaje;
    }
}
