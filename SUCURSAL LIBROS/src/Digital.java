public class Digital extends Libro{
    private String Formato;
    private double peso;
    public double montoAsegurado(){
        Fecha actual = new Fecha();
        int anioAnt=actual.diferenciaAnios(this.getFchPublicacion());
        return 100*anioAnt;
    }
    public double getPeso(){
        return this.peso;
    }
}
