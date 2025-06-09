public class JugadorPrimera extends Jugador {
    private Fecha fchFin;

    public JugadorPrimera(String n,String a,int e,String id,Fecha fchI,Fecha fchF){
        super(n,a,e,id,fchI);
        this.fchFin=fchF;
    }
    public Fecha getFchFin(){
        return this.fchFin;
    }

    @Override
    public double importeNominal(Fecha hasta) {
        int cantMeses=this.fchInicio.diferenciaMeses(hasta);
        return cantMeses*25000;
    }

    @Override
    public String toString() {
        return super.toString()+" FECHA DE FINALIZACION DE CONTRATO: "+getFchFin();
    }
}
