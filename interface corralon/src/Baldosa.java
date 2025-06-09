public class Baldosa extends PiezaCeramica {
    private int peso;
    public Baldosa(int codigo,double precioBase,int peso){
        super(codigo,precioBase);
        this.peso=peso;
    }
    public double getPrecioFinal(){
        return getPrecioBase()+(this.peso*0.034);
    }
}
