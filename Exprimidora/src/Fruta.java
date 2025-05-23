public class Fruta extends Vegetal{

    public Fruta(double peso){
        super(peso);
    }

    public double getPesoExtra(){
        return super.getPesoExtra()*0.1;
    }
}