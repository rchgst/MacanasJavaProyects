public class TarjetaDeCredito extends TipoDePago{
    @Override
    public double pagar(double monto) {
        return monto+100;
    }
}
