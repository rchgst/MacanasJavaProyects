import java.util.Scanner;

public class Fotografia {
  private int[][] imagen;
  private int[][] tablaEstrellas;

  public int[][] getImagen() {
    return this.imagen;
  }

  public void setImagen(int[][] imagen) {
    this.imagen = imagen;
    this.tablaEstrellas = new int[imagen.length][imagen[0].length];
  }

  public Fotografia() {
  }

  public Fotografia(int[][] imagen) {
    this.imagen = imagen;
    this.tablaEstrellas = new int[imagen.length][imagen[0].length];
  }

  public Fotografia(int alto, int ancho) {
    this.imagen = new int[alto][ancho];
    this.tablaEstrellas = new int[alto][ancho];
  }

  public void ingresarValoresFotografia() {
    Scanner scanner = new Scanner(System.in);
    if (this.imagen == null) {
      int columnas = 0;
      int filas = 0;
      do {
        System.out.print("Ingrese el ancho de la imagen: ");
        columnas = Integer.parseInt(scanner.nextLine());
      } while (columnas <= 0);
      do {
        System.out.print("Ingrese la altura de la imagen: ");
        filas = Integer.parseInt(scanner.nextLine());
      } while (filas <= 0);
      this.imagen = new int[filas][columnas];
      this.tablaEstrellas = new int[filas][columnas];
    }
    for (int i = 0; i < this.imagen.length; i++) {
      for (int j = 0; j < this.imagen[0].length; j++) {
        System.out.print("Ingrese el valor de la casilla [" + i + "][" + j + "]: ");
        this.imagen[i][j] = Integer.parseInt(scanner.nextLine());
      }
    }
  }

  public void ingresarValorFotografia(int fila, int columna, int valor) {
    if (fila >= 0 && columna >= 0 && fila < this.imagen.length && columna < this.imagen[0].length) {
      this.imagen[fila][columna] = valor;
    }
  }

  public void mostrarValoresImagen() {
    if (this.imagen != null) {
      for (int i = 0; i < this.imagen.length; i++) {
        for (int j = 0; j < this.imagen[0].length; j++) {
          if (this.imagen[i][j] < 10) {
            System.out.print("  " + this.imagen[i][j] + "  ");
          } else if (this.imagen[i][j] < 100) {
            System.out.print(" " + this.imagen[i][j] + " ");
          } else {
            System.out.print(" " + this.imagen[i][j] + " ");
          }
          if (j < this.imagen[0].length - 1) {
            System.out.print("|");
          }
        }
        System.out.println();
        if (i < this.imagen.length - 1) {
          for (int j = 0; j < imagen.length; j++) {
            System.out.print("--------");
          }
        }
        System.out.println();
      }
    } else {
      System.out.println("No se cargo una imagen!");
    }
  }

  public void detectarEstrellas() {
    if (this.imagen != null) {
      for (int i = 1; i < this.imagen.length - 1; i++) {
        for (int j = 1; j < this.imagen[0].length - 1; j++) {
          if ((this.imagen[i][j] + this.imagen[i - 1][j] + this.imagen[i + 1][j] + this.imagen[i][j - 1]
              + this.imagen[i][j + 1]) > 600) {
            this.tablaEstrellas[i][j] = 1;
          }
        }
      }
    }
  }

  public void imprimirEstrellas() {
    if (this.tablaEstrellas != null) {
      detectarEstrellas();
      for (int i = 0; i < this.tablaEstrellas.length; i++) {
        for (int j = 0; j < this.tablaEstrellas[0].length; j++) {
          if (this.tablaEstrellas[i][j] == 0) {
            System.out.print("   ");
          } else {
            System.out.print(" * ");
          }
          if (j < this.tablaEstrellas[0].length - 1) {
            System.out.print("|");
          }
        }
        System.out.println();
        if (i < this.tablaEstrellas.length - 1) {
          for (int j = 0; j < this.tablaEstrellas[0].length; j++) {
            System.out.print("----");
          }
        }
        System.out.println();
      }
    } else {
      System.out.println("No se ha cargado la fotografia!");
    }
  }
}
