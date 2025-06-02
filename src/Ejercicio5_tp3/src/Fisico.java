public class Fisico extends Libro{
    private int paginas;
    private double peso;

    public Fisico(String codigo,String titulo, Autor autor,Fecha fchPublicacion,Fecha fchIngreso,int paginas,int peso){
        super(codigo,titulo,autor,fchPublicacion,fchIngreso);
        this.paginas=paginas;
        this.peso = peso;
    }

    public double montoAsegurado(){
        double antiguedad;
        Fecha fecha = new Fecha();
        antiguedad = (double)fecha.diferenciaAnios(this.getFchPublicacion())*100;
        double montoExtra = (peso/100)*50;
        return antiguedad + montoExtra;
    }

    public double getPeso(){
        return peso;
    }

}
