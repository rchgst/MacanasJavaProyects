public class Vegetal {
    protected double peso;
    protected double porcentajeJugo;

    public Vegetal(double peso){
        this.peso = peso;
    }

    public double getPesoExtra(){
        return this.peso;
    }

    public double getPorcentajeJugo(){
        return this.porcentajeJugo;
    }
}