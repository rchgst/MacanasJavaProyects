public class JugadorReserva extends Jugador{
    public JugadorReserva(String n,String a,int e,String id,Fecha fchI){
        super(n,a,e,id,fchI);
    }

    @Override
    public double importeNominal(Fecha hasta) {
        int difMeses=this.fchInicio.diferenciaMeses(hasta);
        return difMeses*15000;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
