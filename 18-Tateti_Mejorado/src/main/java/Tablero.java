import java.util.ArrayList;

public class Tablero {
  private int[][] tablero;

  public Tablero() {
    this.tablero = new int[3][3];
  }

  public void imprimirTablero() {
    for (int i = 0; i < this.tablero.length; i++) {
      for (int j = 0; j < this.tablero[0].length; j++) {
        if (this.tablero[i][j] == 1) {
          System.out.print(" X ");
        } else if (this.tablero[i][j] == -1) {
          System.out.print(" O ");
        } else {
          System.out.print("   ");
        }
        if (j < 2) {
          System.out.print("|");
        }
      }
      if (i < 2) {
        System.out.println("\n-----------");
      }
    }
    System.out.println();
  }

  public boolean dibujarMarca(int marca, int fila, int columna) {
    boolean seDibujo = false;
    if (fila >= 0 && columna >= 0 && fila < this.tablero.length && columna < this.tablero[0].length
        && this.tablero[fila][columna] == 0) {
      this.tablero[fila][columna] = marca;
      seDibujo = true;
    }
    return seDibujo;
  }

  public ArrayList<String> getMovimientosDisponibles() {
    ArrayList<String> disponibles = new ArrayList<String>();
    for (int i = 0; i < this.tablero.length; i++) {
      for (int j = 0; j < this.tablero[0].length; j++) {
        if (this.tablero[i][j] == 0) {
          disponibles.add(String.valueOf(i) + String.valueOf(j));
        }
      }
    }
    return disponibles;
  }

  public boolean hayCeldasDisponibles() {
    boolean hayCeldas = false;
    int i = 0;
    while (!(hayCeldas) && i < this.tablero.length) {
      int j = 0;
      while (!(hayCeldas) && j < this.tablero[0].length) {
        if (this.tablero[i][j] == 0) {
          hayCeldas = true;
        }
        ++j;
      }
      ++i;
    }
    return hayCeldas;
  }

  public int verificarGanador() {
    int posibleGanador = revisionHorizontal();
    if (posibleGanador != 0) {
      return posibleGanador;
    }
    posibleGanador = revisionVertical();
    if (posibleGanador != 0) {
      return posibleGanador;
    }
    if (this.tablero[0][0] != 0 && this.tablero[0][0] == this.tablero[1][1]
        && this.tablero[1][1] == this.tablero[2][2]) {
      return this.tablero[0][0];
    }
    if (this.tablero[0][2] != 0 && this.tablero[0][2] == this.tablero[1][1]
        && this.tablero[1][1] == this.tablero[2][0]) {
      return this.tablero[0][2];
    }
    return 0;
  }

  private int revisionHorizontal() {
    int posibleGanador = 0;
    int i = 0;
    int bandera = 0;
    while (i < this.tablero.length && bandera == 0) {
      if (this.tablero[i][0] != 0 && this.tablero[i][0] == this.tablero[i][1]
          && this.tablero[i][1] == this.tablero[i][2]) {
        posibleGanador = this.tablero[i][0];
        bandera = 1;
      }
      ++i;
    }
    return posibleGanador;
  }

  public int revisionVertical() {
    int posibleGanador = 0;
    int bandera = 0;
    int i = 0;
    while (i < this.tablero[0].length && bandera == 0) {
      if (this.tablero[0][i] != 0 && this.tablero[0][i] == this.tablero[1][i]
          && this.tablero[1][i] == this.tablero[2][i]) {
        posibleGanador = this.tablero[0][i];
        bandera = 1;
      }
      ++i;
    }
    return posibleGanador;
  }

  public int getValor(int fila, int columna) {
    return this.tablero[fila][columna];
  }

  public void setValor(int fila, int columna, int marca) {
    if (fila >= 0 && columna >= 0 && fila < this.tablero.length && columna < this.tablero[0].length) {
      this.tablero[fila][columna] = marca;
    }
  }
}
