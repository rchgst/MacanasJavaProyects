import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    ListaNumerosReales lista = new ListaNumerosReales(20);
    lista.agregarNumero(3.8);
    lista.agregarNumero(-3.8);
    lista.agregarNumero(100);
    lista.agregarNumero(-10);
    lista.agregarNumero(-10);
    lista.agregarNumero(-10);
    lista.agregarNumero(-10);
    lista.agregarNumero(5);
    lista.agregarNumero(5);
    lista.agregarNumero(5);
    lista.agregarNumero(-29);
    lista.agregarNumero(-29);
    lista.agregarNumero(-29);
    lista.agregarNumero(-29);
    lista.agregarNumero(-29);
    lista.agregarNumero(-29);
    System.out.println("El menor de la lista es: " + lista.menorDeLaLista());
    System.out.println("El mayor de la lista es: " + lista.mayorDeLaLista());
    System.out.println("El número que aparece con mas frecuencia es: " + lista.elementoMasFrecuente());
    boolean existe3 = lista.existeElemento(3);
    System.out.println("Existe el numero 3 en la lista?: " + existe3);
    System.out.println("La suma de todos los elementos de la lista es: " + lista.sumarElementosLista());
    System.out.println("El promedio de la lista es: " + lista.promedioDeLaLista());
    ArrayList<Double> operar = new ArrayList<>();
    operar.add(Double.valueOf(20));
    operar.add(Double.valueOf(20));
    operar.add(Double.valueOf(20));
    operar.add(Double.valueOf(20));
    operar.add(Double.valueOf(-20));
    operar.add(Double.valueOf(-20));
    operar.add(Double.valueOf(-20));
    operar.add(Double.valueOf(-20));
    operar.add(Double.valueOf(40));
    operar.add(Double.valueOf(40));
    operar.add(Double.valueOf(40));
    operar.add(Double.valueOf(40));
    operar.add(Double.valueOf(100));
    operar.add(Double.valueOf(100));
    operar.add(Double.valueOf(100));
    operar.add(Double.valueOf(100));
    ArrayList<Double> suma = lista.sumaDeListas(operar);
    System.out.println("Imprimiendo la suma de listas");
    for (Double double1 : suma) {
      System.out.println(double1);
    }
    ArrayList<Double> multiplicacion = lista.multiplicarLista(operar);
    System.out.println("Imprimiendo la multiplicacion de las listas");
    for (Double double1 : multiplicacion) {
      System.out.println(double1);
    }
    multiplicacion = lista.multiplicarLista(5);
    System.out.println("Imprimiendo la multiplicacion de la lista");
    for (Double double1 : multiplicacion) {
      System.out.println(double1);
    }
    ArrayList<Double> ordenada = lista.listaOrdenada();
    System.out.println("Imprimiendo la lista ordenada");
    for (Double double1 : ordenada) {
      System.out.println(double1);
    }
    System.out.println("La suma del indice 1 y 4 de la lista es: " + lista.sumarDosElementos(1, 4));
  }
}
