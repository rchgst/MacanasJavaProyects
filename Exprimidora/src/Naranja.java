public class Naranja extends Fruta{

    public Naranja(String nombre,double peso){
        super(nombre, peso);
    }

    @Override
    public double calulaJugo() {
        return (this.peso*0.90)-pesoExtra;
    }
}
