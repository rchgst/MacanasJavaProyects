public class Hortaliza extends Vegetal {
    public Hortaliza(int peso,int porcentajeJugo){
        super(peso,porcentajeJugo);
    }
    public double Exprimir() {
        double pesoExtra=this.peso*0.05;
        double juguito=(this.peso*this.porcentajeJugo)/100;
        return juguito-pesoExtra;
    }
}
