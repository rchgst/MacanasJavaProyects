public class Tomate extends Fruta{

    public Tomate(String nombre,double peso){
        super(nombre, peso);
    }

    @Override
    public double calulaJugo() {
        return (this.peso*0.80)-pesoExtra;
    }
}
