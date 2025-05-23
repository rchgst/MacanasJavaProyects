public class Fruta extends Vegetales{
    protected double pesoExtra;

    public Fruta(String nombre, double peso){
        super(nombre, peso);
        this.pesoExtra=calculaPesoExtra();
    }
    public double calculaPesoExtra(){
        return  this.peso * 0.10;
    }
    @Override
    public double calulaJugo() {
        return this.peso-this.pesoExtra;
    }
}
