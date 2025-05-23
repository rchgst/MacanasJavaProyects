public class Remolacha extends Hortaliza{

    public Remolacha(String nombre,double peso){
        super(nombre, peso);
    }

    @Override
    public double calulaJugo() {
        return (this.peso*0.70)-pesoExtra;
    }
}
