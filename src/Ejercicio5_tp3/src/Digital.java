import java.time.temporal.ChronoUnit;

public class Digital extends Libro{
    private String formato;
    private double peso;


    public Digital(String codigo,String titulo, Autor autor,Fecha fchPublicacion,Fecha fchIngreso,String formato,double peso){
        super(codigo,titulo,autor,fchPublicacion,fchIngreso);
        this.formato = formato;
        this.peso = peso;
    }

    public double montoAsegurado(){
        double antiguedad;
        Fecha fecha = new Fecha();
        antiguedad = (double)fecha.diferenciaAnios(this.getFchPublicacion())*100;
        return antiguedad;
    }

    public double getPeso(){
        return peso;
    }

}
