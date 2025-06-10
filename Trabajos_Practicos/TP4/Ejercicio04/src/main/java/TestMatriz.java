public class TestMatriz {
  public static void main(String[] args) {
    Matriz m = new Matriz(3, 3);
    m.setElem(0, 0, 1);
    m.setElem(1, 1, 1);
    m.setElem(2, 2, 1);
    m.mostrar();
    System.out.println("Existe la posicion 5, 5? " + m.existePos(5, 5));
    Matriz copia = new Matriz(3, 3);
    copia.copy(m);
    System.out.println("Mostrando una copia de la matriz");
    copia.mostrar();
    double contador = 0;
    for (int i = 0; i < copia.getCantFil(); i++) {
      for (int j = 0; j < copia.getCantCol(); j++) {
        copia.setElem(i, j, ++contador);
      }
    }
    System.out.println("Copia modificada");
    copia.mostrar();
    try {
      Matriz clon = copia.clone();
    } catch (CloneNotSupportedException e) {
      System.out.println("Error al clonar el objeto!");
    }
    System.out.println("Es la matriz original cuadrada? " + m.esCuadrada());
    System.out.println("Es la matriz original una de identidad? " + m.esIdentidad());
    System.out.println("Es la matriz original triangular superior? " + m.esTriangSup());
    System.out.println("Es la matriz original triangular inferior? " + m.esTriangInf());
    System.out.println("Es la matriz original simetrica? " + m.esSimetrica());
    System.out.println("Es la matriz original rala? " + m.esRala());
    System.out.println("Cantidad de unos en la matriz original: " + m.cantElem(1));
    System.out.println("En la matriz copia esta el numero 8? " + copia.estaElem(8));
    Vector mayores = copia.vectorMayores();
    mayores.mostrar();
    Matriz suma = copia.suma(m);
    System.out.println("Mostrando la suma de matrices de la copia y la original");
    suma.mostrar();
    Matriz producto = copia.producto(m);
    System.out.println("Mostrando el producto de matrices de la copia y la original");
    producto.mostrar();
    producto = copia.productox1Escalar(4);
    System.out.println("Mostrando la matriz copia multiplicada por el escalar 4");
    producto.mostrar();
    System.out.println("Mostrando la transpuesta de la copia");
    copia.transpuesta().mostrar();
  }
}
