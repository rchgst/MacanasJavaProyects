public class CartaEspecial extends Carta{
    private int habilidad;

    public CartaEspecial(int color,int habilidad){
        super(color);
        this.habilidad = habilidad;
    }

    public int getHabilidad(){
        return habilidad;
    }

    public boolean esEspecial(){
        return true;
    }

    public boolean igualCarta(Carta carta){
        if(carta instanceof CartaEspecial)
            return this.getColor() == carta.getColor() && this.habilidad == ((CartaEspecial) carta).getHabilidad();
        return false;
    }

    public String toString(){
        String mensaje = "";

        switch (habilidad){
            case 0:
                mensaje+="reversa";
                break;
            case 1:
                mensaje+="bloqueo";
                break;
            case 2:
                mensaje+="+2";
                break;
            case 3:
                mensaje+="+4";
        }

        return super.toString() + mensaje;
    }

}
