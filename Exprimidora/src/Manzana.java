public class Manzana extends Fruta{

    public Manzana(String nombre,double peso){
        super(nombre, peso);
    }

    @Override
    public double calulaJugo() {
        return (this.peso*0.75)-pesoExtra;
    }
}
