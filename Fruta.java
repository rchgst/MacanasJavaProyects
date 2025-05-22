public class Fruta extends Vegetal{
    public Fruta(int peso,int porcentajeJugo){
        super(peso,porcentajeJugo);
    }
    public double Exprimir() {
        double pesoExtra=this.peso*0.10;
        double juguito=(this.peso*this.porcentajeJugo)/100;
        return juguito-pesoExtra;
    }
}
