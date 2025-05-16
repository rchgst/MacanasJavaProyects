import java.util.ArrayList;
import java.util.Collections;

public class ListaNumeros {
  private ArrayList<Integer> lista = new ArrayList<>();

  public void agregarElemento(int numero) {
    this.lista.add(numero);
  }

  public void eliminarElemento(int numero) {
    if (this.lista.contains(numero)) {
      this.lista.remove(Integer.valueOf(numero));
    } else {
      System.out.println("Ese numero no se encuentra en la lista");
    }
  }

  public void ordenarLista() {
    Collections.sort(this.lista);
  }

  public void buscarElemento(int numero) {
    int posicion;
    if (this.lista.contains(numero)) {
      posicion = this.lista.indexOf(Integer.valueOf(numero));
      System.out.println("El elemento se encuentra en la posicion " + posicion + " de la lista");
    } else {
      System.out.println("El numero no se encuentra en la lista.");
    }
  }

  public static void main(String[] args) {
    ListaNumeros listaNumeros = new ListaNumeros();
    listaNumeros.agregarElemento(10);
    listaNumeros.agregarElemento(5);
    listaNumeros.agregarElemento(40);
    listaNumeros.agregarElemento(8);
    listaNumeros.agregarElemento(28);
    listaNumeros.buscarElemento(10);
    listaNumeros.buscarElemento(100);
    listaNumeros.eliminarElemento(5);
    listaNumeros.eliminarElemento(32);
    listaNumeros.ordenarLista();
    listaNumeros.buscarElemento(28);
    listaNumeros.buscarElemento(35);
  }
}
