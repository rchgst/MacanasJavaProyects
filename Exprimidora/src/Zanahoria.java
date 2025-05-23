public class Zanahoria extends Hortaliza{

    public Zanahoria(String nombre,double peso){
        super(nombre, peso);
    }

    @Override
    public double calulaJugo() {
        return (this.peso*0.40)-pesoExtra;
    }
}
