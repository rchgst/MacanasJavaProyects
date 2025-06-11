import java.util.ArrayList;

public abstract class ListaAbs {
  private int cantelementos;
  private ArrayList<Object> elementos;
  private boolean ordenada;

  public ListaAbs() {
    elementos = new ArrayList<>();
    setCantElem(0);
    setOrdenada(true);
  }

  public int getCantElem() {
    return this.cantelementos;
  }

  public boolean estaOrdenada() {
    return this.ordenada;
  }

  public boolean estaVacia() {
    return getCantElem() == 0;
  }

  private void setOrdenada(boolean valor) {
    this.ordenada = valor;
  }

  private void setCantElem(int valor) {
    this.cantelementos = valor;
  }

  public abstract boolean mayor(Object elemento, Object otroelemento);// métodos abstractos que se definirán en
                                                                      // subclases

  public abstract boolean menor(Object elemento, Object otroelemento);

  public abstract boolean iguales(Object elemento, Object otroelemento);

  public abstract void imprimir(Object elemento);

  public Object getElemento(int pos) {
    Object elemento = null;
    if (pos < getCantElem()) {
      elemento = elementos.get(pos);
    }
    return elemento;
  }

  public Object getUltimo() {
    Object ultimo = null;
    if (!estaVacia()) {
      ultimo = getElemento(getCantElem() - 1);
    }
    return ultimo;
  }

  public void meter(Object elemento) {
    if (!estaVacia()) {
      if (mayor(getUltimo(), elemento)) {
        setOrdenada(false);
      }
    }
    elementos.add(elemento);
    setCantElem(getCantElem() + 1);
  }

  public void setElemento(Object elemento, int pos) {// pone un elemento en una posición determinada
    if (pos < getCantElem() && pos >= 0) {
      elementos.set(pos, elemento);
      setOrdenada(false);// ¿cómo podría mejorar esto?
    }
  }

  public void ordenar() {
    if (!estaOrdenada()) {
      Object aux;
      int pos_menor;
      for (int i = 0; i < getCantElem(); i++) {
        aux = getElemento(i);
        pos_menor = posDelMenor(i);
        setElemento(getElemento(pos_menor), i);
        setElemento(aux, pos_menor);
      }
      setOrdenada(true);
    }
  }

  public int posDelMenor(int desde) {
    if (desde == getCantElem() - 1) {
      return desde;
    } else {
      int men = posDelMenor(desde + 1);
      if (menor(getElemento(desde), getElemento(men))) {
        return desde;
      } else {
        return men;
      }
    }
  }

  public boolean buscar(Object elemento) {
    if (estaOrdenada()) {
      return busquedaBinaria(elemento, 0, getCantElem() - 1);
    } else {
      boolean encontrado = false;
      int k = 0;
      while (k < getCantElem() && !encontrado) {
        if (iguales(elemento, getElemento(k))) {
          encontrado = true;
        } else {
          k++;
        }
      }
      return encontrado;
    }
  }

  public boolean busquedaBinaria(Object x, int primero, int ultimo) {
    int medio;
    if (primero > ultimo) {
      return false;
    } else {
      medio = (primero + ultimo) / 2;
      if (iguales(x, getElemento(medio))) {
        return true;
      } else {
        if (menor(x, getElemento(medio))) {
          return busquedaBinaria(x, primero, medio - 1);
        } else {
          return busquedaBinaria(x, medio + 1, ultimo);
        }
      }
    }
  }

  public void mostrar() {
    for (int k = 0; k < getCantElem(); k++) {
      imprimir(getElemento(k));
    }
  }
}
