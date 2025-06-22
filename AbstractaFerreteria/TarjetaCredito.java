public class TarjetaCredito implements FormadePago {
    @Override
    public double pagar(double monto){
        return monto+240;
    }
    
}
