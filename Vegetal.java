public class Vegetal {
    protected int peso;
    protected int porcentajeJugo;

    public Vegetal(int peso,int porcentajeJugo){
        this.peso=peso;
        this.porcentajeJugo=porcentajeJugo;
    }
    public double Exprimir(){
    return 0;
    }

    @Override
    public String toString() {
    return  " Jugo obtenido: "+ this.Exprimir();
    }
}
