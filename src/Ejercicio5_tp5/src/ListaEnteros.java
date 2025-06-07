public class ListaEnteros extends ListaOrdenada{

    @Override
    public boolean menor(Object objA, Object objB) {
        int a = (int) objA;
        int b = (int) objB;
        return a<b;
    }

    @Override
    public boolean mayor(Object objA, Object objB) {
        int a = (int) objA;
        int b = (int) objB;
        return a>b;
    }

    @Override
    public boolean igual(Object objA, Object objB) {
        int a = (int) objA;
        int b = (int) objB;
        return a == b;
    }
}
