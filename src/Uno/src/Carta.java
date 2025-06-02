import java.util.Random;

public abstract class Carta {
    private int color;

    public Carta(int color){
        this.color = color;
    }

    public abstract boolean esEspecial();
    public abstract boolean igualCarta(Carta carta);

    public int getColor(){
        return color;
    }

    public void setColor(int color){
        this.color = color;
    }

    public String toString(){
        String mensaje = "";
        switch (color){
            case 0:
                mensaje = "rojo";
                break;
            case 1:
                mensaje = "verde";
                break;
            case 2:
                mensaje = "azul";
                break;
            case 3:
                mensaje = "amarillo";
                break;
            case 4:
                mensaje = "negro";
                break;
        }
        return  mensaje + " ";
    }

}
