public class MercadoPago extends TipoDePago{
    @Override
    public double pagar(double monto) {
        return monto-(monto*0.15);
    }
}
