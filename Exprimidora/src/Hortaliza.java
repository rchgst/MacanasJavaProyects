public class Hortaliza extends Vegetales{
    protected double pesoExtra;

    public Hortaliza(String nombre, double peso){
        super(nombre, peso);
        this.pesoExtra=calculaPesoExtra();
    }
    public double calculaPesoExtra(){
        return  this.peso * 0.05;
    }
    @Override
    public double calulaJugo() {
        return this.peso-this.pesoExtra;
    }
}
