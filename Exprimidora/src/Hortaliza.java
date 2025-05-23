public class Hortaliza extends Vegetal{

    public Hortaliza(double peso){
        super(peso);
    }

    @Override
    public double getPesoExtra() {
        return super.getPesoExtra()*0.05;
    }
}