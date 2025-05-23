public class Jengibre extends Hortaliza{

    public Jengibre(String nombre,double peso){
        super(nombre, peso);
    }

    @Override
    public double calulaJugo() {
        return (this.peso*0.30)-pesoExtra;
    }
}
