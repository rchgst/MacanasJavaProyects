import java.util.Random;
import java.util.Scanner;

public class TatetiTonto {
  private char[][] tablero;
  private char marcaComputadora;
  private char marcaUsuario;
  private int posDisponibles;

  public TatetiTonto() {
    this.tablero = new char[3][3];
    this.posDisponibles = 9;
  }

  public void imprimirTablero() {
    for (int i = 0; i < this.tablero.length; i++) {
      for (int j = 0; j < this.tablero[0].length; j++) {
        switch (this.tablero[i][j]) {
          case 'x':
          case 'X':
            System.out.print(" X ");
            break;
          case 'o':
          case 'O':
            System.out.print(" O ");
            break;
          default:
            System.out.print("   ");
            break;
        }
        if (j != this.tablero[0].length - 1) {
          System.out.print("|");
        }
      }
      if (i != this.tablero.length - 1) {
        System.out.println("\n------------");
      }
    }
    System.out.println();
  }

  public boolean marcarCasilla(char caracter, int fila, int columna) {
    boolean seEjecutoBien = false;
    if (this.tablero[fila][columna] != 'X' && this.tablero[fila][columna] != 'O') {
      this.tablero[fila][columna] = caracter;
      seEjecutoBien = true;
    }
    if (seEjecutoBien) {
      --this.posDisponibles;
    }
    return seEjecutoBien;
  }

  public void marcarCasillaUsuario(int fila, int columna) {
    if ((fila >= 0 && columna >= 0) && (fila < this.tablero.length && columna < this.tablero[0].length)) {
      if (!(marcarCasilla(this.marcaUsuario, fila, columna))) {
        System.out.println("Ese espacio esta ocupado! Intente de nuevo");
      }
    } else {
      System.out.println("Estas marcando fuera del tablero! Intentalo de nuevo");
    }
  }

  public void marcarCasillaComputadora() {
    Random random = new Random();
    int fila = 0, columna = 0;
    boolean marcoCasilla = false;
    do {
      fila = random.nextInt(3);
      columna = random.nextInt(3);
      marcoCasilla = marcarCasilla(this.marcaComputadora, fila, columna);
    } while (!(marcoCasilla));
  }

  public char getMarcaComputadora() {
    return this.marcaComputadora;
  }

  public char getMarcaUsuario() {
    return this.marcaUsuario;
  }

  public void elegirMarcas() {
    Scanner scanner = new Scanner(System.in);
    int eleccion = 0;
    do {
      System.out.println("Elija su marca");
      System.out.println("1 - Cruz");
      System.out.println("2 - Circulo");
      System.out.print("Su eleccion: ");
      eleccion = Integer.parseInt(scanner.nextLine());
    } while (eleccion < 1 || eleccion > 2);
    if (eleccion == 1) {
      this.marcaUsuario = 'X';
      this.marcaComputadora = 'O';
    } else {
      this.marcaUsuario = 'O';
      this.marcaComputadora = 'X';
    }
  }

  // Devuelve verdadero si empieza el usuario, falso de lo contrario
  public boolean elegirQuienEmpieza() {
    Scanner scanner = new Scanner(System.in);
    int eleccion = 0;
    do {
      System.out.println("Usted irá primero?");
      System.out.println("1 - Si");
      System.out.println("2 - No");
      System.out.print("Su eleccion: ");
      eleccion = Integer.parseInt(scanner.nextLine());
    } while (eleccion < 1 || eleccion > 2);
    return eleccion == 1;
  }

  public boolean tatetiFilas() {
    boolean hayGanador = false;
    for (int i = 0; i < this.tablero.length; i++) {
      if (this.tablero[i][0] == 'X' || this.tablero[i][0] == 'O') {
        if (this.tablero[i][0] == this.tablero[i][1] && this.tablero[i][1] == this.tablero[i][2]) {
          hayGanador = true;
        }
      }
    }
    return hayGanador;
  }

  public boolean tatetiColumnas() {
    boolean hayGanador = false;
    for (int i = 0; i < this.tablero[0].length; i++) {
      if (this.tablero[0][i] == 'X' || this.tablero[0][i] == 'O') {
        if (this.tablero[0][i] == this.tablero[1][i] && this.tablero[1][i] == this.tablero[2][i]) {
          hayGanador = true;
        }
      }
    }
    return hayGanador;
  }

  public boolean tatetiDiagonal() {
    boolean hayGanador = true;
    for (int i = 0; i < this.tablero.length - 1; i++) {
      if (this.tablero[i][i] == 'X' || this.tablero[i][i] == 'O') {
        if (this.tablero[i][i] != this.tablero[i + 1][i + 1]) {
          hayGanador = false;
        }
      } else {
        hayGanador = false;
      }
    }
    return hayGanador;
  }

  public boolean tatetiDiagonalOpuesta() {
    boolean hayGanador = true;
    for (int i = this.tablero.length - 1; i > 0; i--) {
      for (int j = 0; j < this.tablero.length - 2; j++) {
        if (this.tablero[i][j] == 'X' || this.tablero[i][j] == 'O') {
          if (this.tablero[i][j] != this.tablero[i - 1][j + 1]) {
            hayGanador = false;
          }
        } else {
          hayGanador = false;
        }
      }
    }
    return hayGanador;
  }

  public boolean tateti() {
    return tatetiFilas() || tatetiColumnas() || tatetiDiagonal() | tatetiDiagonalOpuesta();
  }

  public void jugar() {
    int filaUsuario = 0, columnaUsuario = 0;
    Scanner scanner = new Scanner(System.in);
    elegirMarcas();
    if (elegirQuienEmpieza()) {
      System.out.println("Ingrese la fila y columna en donde poner su marca");
      System.out.println("Recuerde que los valores van de 0 a 2 en ambos casos!");
      do {
        System.out.print("Fila: ");
        filaUsuario = Integer.parseInt(scanner.nextLine());
        System.out.print("Columna: ");
        columnaUsuario = Integer.parseInt(scanner.nextLine());
      } while (filaUsuario < 0 || columnaUsuario < 0 || filaUsuario > 2 || columnaUsuario > 2);
      marcarCasillaUsuario(filaUsuario, columnaUsuario);
      imprimirTablero();
      System.out.println("Ahora es el turno de la computadora.");
      marcarCasillaComputadora();
      imprimirTablero();
      System.out.println("Vuelve a ser tu turno!");
    } else {
      marcarCasillaComputadora();
      imprimirTablero();
      System.out.println("Ahora es tu turno!");
    }
    while (!(tateti()) && this.posDisponibles > 0) {
      System.out.println("Ingrese la fila y columna en donde poner su marca");
      System.out.println("Recuerde que los valores van de 0 a 2 en ambos casos!");
      do {
        System.out.print("Fila: ");
        filaUsuario = Integer.parseInt(scanner.nextLine());
        System.out.print("Columna: ");
        columnaUsuario = Integer.parseInt(scanner.nextLine());
      } while (filaUsuario < 0 || columnaUsuario < 0 || filaUsuario > 2 || columnaUsuario > 2);
      marcarCasillaUsuario(filaUsuario, columnaUsuario);
      imprimirTablero();
      System.out.println("Ahora es el turno de la computadora.");
      marcarCasillaComputadora();
      imprimirTablero();
    }
    System.out.println("Ha terminado el juego!!");
  }
}
