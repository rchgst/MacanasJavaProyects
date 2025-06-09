public class Main {
    public static void main(String[] args) {
    Pedido carrito=new Pedido();
    Baldosa BRosa= new Baldosa(3,900,200);
    Azulejo Ablanc=new Azulejo(5,500,10);
    TarjetaDeCredito visa = new TarjetaDeCredito();
    carrito.agregarPieza(BRosa);
    carrito.agregarPieza(Ablanc);
    carrito.setFormaDePago(visa);
    carrito.pagar();
    }
}