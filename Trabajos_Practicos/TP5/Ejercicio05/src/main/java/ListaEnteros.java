public class ListaEnteros extends ListaAbs {

  @Override
  public boolean iguales(Object elemento, Object otroelemento) {
    int e = (Integer) elemento;
    int otroE = (Integer) otroelemento;
    return Integer.compare(e, otroE) == 0;
  }

  @Override
  public void imprimir(Object elemento) {
    int e = (Integer) elemento;
    System.out.println(e);
  }

  @Override
  public boolean mayor(Object elemento, Object otroelemento) {
    int e = (Integer) elemento;
    int otroE = (Integer) otroelemento;
    return Integer.compare(e, otroE) > 0;
  }

  @Override
  public boolean menor(Object elemento, Object otroelemento) {
    int e = (Integer) elemento;
    int otroE = (Integer) otroelemento;
    return Integer.compare(e, otroE) < 0;
  }

}
