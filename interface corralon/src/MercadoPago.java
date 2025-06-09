public class MercadoPago implements FormaDePago{
    public double pagar(double monto){
        return monto-((7*monto)/100);
    }
}
