public class ListadeCuenta extends ListaAbs {

  @Override
  public boolean iguales(Object elemento, Object otroelemento) {
    CuentaBancaria elem = (CuentaBancaria) elemento;
    CuentaBancaria otro = (CuentaBancaria) otroelemento;
    return elem.getSaldo() == otro.getSaldo();
  }

  @Override
  public void imprimir(Object elemento) {
    CuentaBancaria elem = (CuentaBancaria) elemento;
    elem.mostrarDatos();
  }

  @Override
  public boolean mayor(Object elemento, Object otroelemento) {
    CuentaBancaria elem = (CuentaBancaria) elemento;
    CuentaBancaria otro = (CuentaBancaria) otroelemento;
    return elem.getSaldo() > otro.getSaldo();
  }

  @Override
  public boolean menor(Object elemento, Object otroelemento) {
    CuentaBancaria elem = (CuentaBancaria) elemento;
    CuentaBancaria otro = (CuentaBancaria) otroelemento;
    return elem.getSaldo() < otro.getSaldo();
  }

  @Override
  public void meter(Object elemento) {
    super.meter(elemento);
    ordenar();
  }
}
