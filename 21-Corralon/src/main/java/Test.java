public class Test {
  public static void main(String[] args) {
    Pedido pedido = new Pedido();
    Azulejo azulejo = new Azulejo(500, 8247, 10);
    Baldosa baldosa = new Baldosa(900, 5723, 200);
    TarjetaDeCredito tarjeta = new TarjetaDeCredito();
    pedido.agregarPieza(azulejo);
    pedido.agregarPieza(baldosa);
    pedido.setFormaDePago(tarjeta);
    pedido.pagar();
  }
}
