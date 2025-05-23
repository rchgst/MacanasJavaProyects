public class Pera extends Fruta{

    public Pera(String nombre,double peso){
        super(nombre, peso);
    }

    @Override
    public double calulaJugo() {
        return (this.peso*0.85)-pesoExtra;
    }
}
