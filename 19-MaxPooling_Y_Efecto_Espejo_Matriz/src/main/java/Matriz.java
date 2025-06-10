public class Matriz {
  private char[][] matriz;
  private int filas;
  private int columnas;

  public Matriz(int m, int n) {
    this.matriz = new char[m][n];
    this.filas = m;
    this.columnas = n;
  }

  public int getFilas() {
    return this.filas;
  }

  public int getColumnas() {
    return this.columnas;
  }

  public void setValor(int x, int y, char valor) {
    if (x >= 0 && x < getFilas() && y >= 0 && y < getColumnas()) {
      this.matriz[x][y] = valor;
    }
  }

  public char getValor(int x, int y) {
    char valor = ' ';
    if (x >= 0 && x < getFilas() && y >= 0 && y < getColumnas()) {
      valor = this.matriz[x][y];
    }
    return valor;
  }

  @Override
  public String toString() {
    String aux = "";
    for (int i = 0; i < getFilas(); i++) {
      for (int j = 0; j < getColumnas(); j++) {
        aux += getValor(i, j) + "\t";
      }
      aux += "\n";
    }
    return aux;
  }
}
