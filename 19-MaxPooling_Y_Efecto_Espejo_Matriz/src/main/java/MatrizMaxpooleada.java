public class MatrizMaxpooleada extends Matriz {
  private int n;

  public MatrizMaxpooleada(int filas, int columnas) {
    super(filas, columnas);
  }

  public MatrizMaxpooleada(int m, int n, int n2) {
    super(m, n);
    this.n = n2;
  }

  public int getN() {
    return this.n;
  }

  public void setN(int n) {
    if (getFilas() % n == 0 && getColumnas() % n == 0) {
      this.n = n;
    } else {
      System.out.println("La cantidad de filas y columnas deben ser divisibles por N!");
    }
  }

  public MatrizMaxpooleada matrizMaxpooleada() {
    MatrizMaxpooleada matriz = null;
    if (this.n > 0 && getFilas() % this.n == 0 && getColumnas() % this.n == 0) {
      matriz = new MatrizMaxpooleada(getFilas() / this.n, getColumnas() / this.n);
      int iniSubMatrizFilas = 0;
      int iniSubMatrizCol = 0;
      int finSubMatrizFil = this.n;
      int finSubMatrizCol = this.n;
      char mayor;
      for (int i = 0; i < matriz.getFilas(); i++) {
        for (int j = 0; j < matriz.getColumnas(); j++) {
          mayor = getValor(iniSubMatrizFilas, iniSubMatrizCol);
          for (int k = iniSubMatrizFilas; k < finSubMatrizFil; k++) {
            for (int l = iniSubMatrizCol; l < finSubMatrizCol; l++) {
              if (Character.compare(getValor(k, l), mayor) > 0) {
                mayor = getValor(k, l);
              }
            }
          }
          matriz.setValor(i, j, mayor);
          iniSubMatrizCol += this.n;
          finSubMatrizCol += this.n;
        }
        iniSubMatrizCol = 0;
        finSubMatrizCol = this.n;
        iniSubMatrizFilas += this.n;
        finSubMatrizFil += this.n;
      }
    }
    return matriz;
  }
}
