public class Efectivo extends TipoDePago {
    @Override
    public double pagar(double monto) {
        return monto-(monto*0.10);
    }
}
