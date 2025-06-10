public class MatrizEspejo extends Matriz {

  public MatrizEspejo(int filas, int columnas) {
    super(filas, columnas);
  }

  public void espejo() {
    char[][] matrizEspejo = new char[getFilas()][getColumnas()];
    int k = getColumnas() - 1;
    for (int i = 0; i < getFilas(); i++) {
      for (int j = 0; j < getColumnas(); j++) {
        matrizEspejo[i][j] = getValor(i, k);
        --k;
      }
      k = getColumnas() - 1;
    }
    for (int i = 0; i < getFilas(); i++) {
      for (int j = 0; j < getColumnas(); j++) {
        setValor(i, j, matrizEspejo[i][j]);
      }
    }
  }
}
