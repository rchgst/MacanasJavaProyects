public class Fisico extends Libro{
    private int paginas;
    private int peso;
    public double montoAsegurado(){
        Fecha actual = new Fecha();
        int anioAnt=actual.diferenciaAnios(this.getFchPublicacion());
        int cienG=peso/100;
        return 200*anioAnt+50*cienG;
    }
    public double getPeso(){
        return this.peso;
    }
}
