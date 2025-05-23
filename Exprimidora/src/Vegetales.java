public class Vegetales {
    protected String nombre;
    protected double peso;

    public Vegetales(String nombre,double peso){
        this.nombre=nombre;
        this.peso=peso;
    }

    public double calulaJugo(){
        return this.peso;
    }
}
