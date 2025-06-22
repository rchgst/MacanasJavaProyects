public abstract class PiezaCeramica {
    private int code;
    private double precioBase;
    public PiezaCeramica(int cod, double pb){
        this.code=cod;
        this.precioBase=pb;
    }
    public double getprecioBase(){
        return this.precioBase;
    }
    public int getcode(){
        return this.code;
    }
    public abstract double getPrecioFinal();
    
}
