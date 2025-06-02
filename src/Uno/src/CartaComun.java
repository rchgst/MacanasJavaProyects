public class CartaComun extends Carta{
    private int num;

    public CartaComun(int color,int num){
        super(color);
        this.num = num;
    }

    public int getNum(){
        return num;
    }

    public boolean esEspecial(){
        return false;
    }

    public boolean igualCarta(Carta carta){
        if(carta instanceof CartaComun)
            return this.getColor()==carta.getColor() && this.num == ((CartaComun) carta).getNum();
        return false;
    }

    public String toString(){
        return super.toString() + num;
    }


}
