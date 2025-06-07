public class ListaDeCuenta extends ListaOrdenada{

    @Override
    public boolean menor(Object objA, Object objB) {
        CuentaBancaria a = (CuentaBancaria) objA;
        CuentaBancaria b = (CuentaBancaria) objB;
        return a.getSaldo() < b.getSaldo();
    }

    @Override
    public boolean mayor(Object objA, Object objB) {
        CuentaBancaria a = (CuentaBancaria) objA;
        CuentaBancaria b = (CuentaBancaria) objB;
        return a.getSaldo() > b.getSaldo();
    }

    @Override
    public boolean igual(Object objA, Object objB) {
        CuentaBancaria a = (CuentaBancaria) objA;
        CuentaBancaria b = (CuentaBancaria) objB;
        return a.getSaldo() == b.getSaldo();
    }
}
