import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ListaNumerosReales {
  private int n;
  private int m;
  private ArrayList<Double> listaNumerosReales;

  public int getN() {
    return this.n;
  }

  public void setN(int n) {
    this.n = n;
  }

  public int getM() {
    return this.m;
  }

  public ArrayList<Double> getListaNumerosReales() {
    return this.listaNumerosReales;
  }

  public void setListaNumerosReales(ArrayList<Double> listaNumerosReales) {
    if (this.n >= listaNumerosReales.size()) {
      this.listaNumerosReales = listaNumerosReales;
      this.m = listaNumerosReales.size();
    } else {
      System.out.println("La lista es demasiado grande para este objeto");
      System.out.println("El limite de elementos es de " + this.n);
    }
  }

  public ListaNumerosReales() {
    this.listaNumerosReales = new ArrayList<>();
  }

  public ListaNumerosReales(int n) {
    this();
    this.n = n;
  }

  public void agregarNumero(double num) {
    if (this.n > this.m) {
      this.listaNumerosReales.add(num);
      ++this.m;
    } else {
      System.out.println("No se pueden agregar mas elmentos a esta lista!");
    }
  }

  public void eliminarNumero(double num) {
    this.listaNumerosReales.remove(Double.valueOf(num));
    --this.m;
  }

  public boolean existeElemento(double num) {
    return this.listaNumerosReales.contains(Double.valueOf(num));
  }

  public double sumarElementosLista() {
    double suma = 0;
    for (Double double1 : this.listaNumerosReales) {
      suma += double1;
    }
    return suma;
  }

  public double menorDeLaLista() {
    if (this.listaNumerosReales.size() > 0) {
      return this.listaNumerosReales.stream().min((d1, d2) -> d1.compareTo(d2)).get();
    } else {
      System.out.println("No hay elementos cargados en la lista.");
      return 0.0;
    }
  }

  public double mayorDeLaLista() {
    if (this.listaNumerosReales.size() > 0) {
      return this.listaNumerosReales.stream().max((d1, d2) -> d1.compareTo(d2)).get();
    } else {
      System.out.println("No hay elementos cargados en la lista.");
      return 0.0;
    }
  }

  public double elementoMasFrecuente() {
    if (this.listaNumerosReales.size() > 0) {
      List<Double> list = this.listaNumerosReales.stream().distinct().collect(Collectors.toList());
      double masRepetido = 0;
      int repeticion = 0, mayorRepeticion = 0;
      for (Double double1 : list) {
        repeticion = Collections.frequency(this.listaNumerosReales, double1);
        if (repeticion > mayorRepeticion) {
          masRepetido = double1;
          mayorRepeticion = repeticion;
        }
        repeticion = 0;
      }
      return masRepetido;
    } else {
      System.out.println("No hay elementos cargados en la lista.");
      return 0.0;
    }
  }

  public double promedioDeLaLista() {
    if (this.listaNumerosReales.size() > 0) {
      int suma = 0;
      for (Double double1 : this.listaNumerosReales) {
        suma += double1;
      }
      return suma / this.listaNumerosReales.size();
    } else {
      System.out.println("La lista esta vacia!");
      return 0;
    }
  }

  public ArrayList<Double> sumaDeListas(ArrayList<Double> lista) {
    ArrayList<Double> suma = new ArrayList<>();
    if (lista.size() == this.m) {
      for (int i = 0; i < this.m; i++) {
        suma.add(lista.get(i) + this.listaNumerosReales.get(i));
      }
    } else {
      System.out.println("No se puede realizar la suma entre ambas listas!");
    }
    return suma;
  }

  public ArrayList<Double> multiplicarLista(ArrayList<Double> lista) {
    ArrayList<Double> multiplicacion = new ArrayList<Double>();
    if (this.listaNumerosReales.size() == lista.size()) {
      for (int i = 0; i < this.listaNumerosReales.size(); i++) {
        multiplicacion.add(this.listaNumerosReales.get(i) * lista.get(i));
      }
    } else {
      System.out.println("No se puede realizar la multiplicacion entre las listas!");
    }
    return multiplicacion;
  }

  public ArrayList<Double> multiplicarLista(double valor) {
    ArrayList<Double> multiplicacion = new ArrayList<>();
    if (this.listaNumerosReales.size() > 0) {
      for (Double double1 : this.listaNumerosReales) {
        multiplicacion.add(valor * double1);
      }
    } else {
      System.out.println("La lista esta vacia!");
    }
    return multiplicacion;
  }

  public double sumarDosElementos(int i1, int i2) {
    int mayor = (i1 >= i2) ? i1 : i2;
    double resultado = 0;
    if (this.listaNumerosReales.size() >= mayor) {
      resultado = this.listaNumerosReales.get(i1) + this.listaNumerosReales.get(i2);
    } else {
      System.out.println("No es posible realizar la suma con esos valores");
    }
    return resultado;
  }

  public ArrayList<Double> listaOrdenada() {
    return (ArrayList<Double>) this.listaNumerosReales.stream().sorted().collect(Collectors.toList());
  }
}
