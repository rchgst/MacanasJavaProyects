public class PagoFacil implements FormadePago {
    @Override
    public double pagar(double monto){
        return monto+(monto*0.10);
    }
    
}
