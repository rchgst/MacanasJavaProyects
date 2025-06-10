public class Matriz {
  private double[][] m;

  public Matriz(int filas, int columnas) {
    this.m = new double[filas][columnas];
  }

  public void setElem(int f, int c, double elem) {
    if (f < this.m.length && c < this.m[0].length && f >= 0 && c >= 0) {
      this.m[f][c] = elem;
    }
  }

  public void copy(Matriz m) {
    if (m.getCantFil() == this.m.length && m.getCantCol() == this.m[0].length) {
      for (int i = 0; i < this.m.length; i++) {
        for (int j = 0; j < this.m[0].length; j++) {
          this.m[i][j] = m.getElem(i, j);
        }
      }
    }
  }

  public boolean existePos(int f, int c) {
    return f >= 0 && c >= 0 && f < this.m.length && c < this.m[0].length;
  }

  public int getCantFil() {
    return this.m.length;
  }

  public int getCantCol() {
    return this.m[0].length;
  }

  public double getElem(int f, int c) {
    double elem = 0;
    if (f >= 0 && c >= 0 && f < this.m.length && c < this.m[0].length) {
      elem = this.m[f][c];
    }
    return elem;
  }

  public Matriz clone() throws CloneNotSupportedException {
    return (Matriz) super.clone();
  }

  public boolean equals(Matriz m) {
    boolean sonIguales = true;
    if (m.getCantFil() == this.m.length && m.getCantCol() == this.m[0].length) {
      int i = 0;
      int j = 0;
      while (i < this.m.length && sonIguales) {
        while (j < this.m[0].length && sonIguales) {
          if (this.m[i][j] != m.getElem(i, j)) {
            sonIguales = false;
          }
          ++j;
        }
        j = 0;
        ++i;
      }
    } else {
      sonIguales = false;
    }
    return sonIguales;
  }

  public boolean esCuadrada() {
    return this.m.length == this.m[0].length;
  }

  public boolean esIdentidad() {
    boolean esIdentidad = true;
    if (esCuadrada()) {
      int i = 0;
      int j = 0;
      while (esIdentidad && i < this.m.length) {
        if (this.m[i][i] != 1) {
          esIdentidad = false;
        }
        ++i;
      }
      i = 0;
      while (i < this.m.length && esIdentidad) {
        while (j < this.m[0].length && esIdentidad) {
          if (i != j && this.m[i][j] != 0) {
            esIdentidad = false;
          }
          ++j;
        }
        j = 0;
        ++i;
      }
    } else {
      esIdentidad = false;
    }
    return esIdentidad;
  }

  public boolean esTriangSup() {
    boolean esTriangSup = true;
    if (esCuadrada()) {
      int i = 0;
      int j = i + 1;
      while (esTriangSup && i < this.m[0].length - 1) {
        while (esTriangSup && j < this.m.length) {
          if (this.m[j][i] != 0) {
            esTriangSup = false;
          }
          ++j;
        }
        ++i;
        j = i + 1;
      }
    } else {
      esTriangSup = false;
    }
    return esTriangSup;
  }

  public boolean esTriangInf() {
    boolean esTriangInf = true;
    if (esCuadrada()) {
      int i = 1;
      int j = i - 1;
      while (esTriangInf && i < this.m[0].length) {
        while (esTriangInf && j >= 0) {
          if (this.m[j][i] != 0) {
            esTriangInf = false;
          }
          --j;
        }
        ++i;
        j = i - 1;
      }
    } else {
      esTriangInf = false;
    }
    return esTriangInf;
  }

  public boolean esSimetrica() {
    boolean esSimetrica = true;
    if (esCuadrada()) {
      int i = 0;
      int j = i + 1;
      while (esSimetrica && i < this.m.length - 1) {
        while (esSimetrica && j < this.m[0].length) {
          if (this.m[j][i] != this.m[i][j]) {
            esSimetrica = false;
          }
          ++j;
        }
        ++i;
        j = i + 1;
      }
    } else {
      esSimetrica = false;
    }
    return esSimetrica;
  }

  public boolean esRala() {
    int cantTotalElem = this.m.length * this.m[0].length;
    int contadorCeros = 0;
    for (int i = 0; i < this.m.length; i++) {
      for (int j = 0; j < this.m[0].length; j++) {
        if (this.m[i][j] == 0) {
          ++contadorCeros;
        }
      }
    }
    return contadorCeros >= cantTotalElem / 2;
  }

  public int cantElem(double elem) {
    int cantElem = 0;
    for (int i = 0; i < this.m.length; i++) {
      for (int j = 0; j < this.m[0].length; j++) {
        if (this.m[i][j] == elem) {
          ++cantElem;
        }
      }
    }
    return cantElem;
  }

  public boolean estaElem(double elem) {
    boolean esta = false;
    int i = 0;
    int j = 0;
    while (!(esta) && i < this.m.length) {
      while (!(esta) && j < this.m[0].length) {
        if (this.m[i][j] == elem) {
          esta = true;
        }
        ++j;
      }
      j = 0;
      ++i;
    }
    return esta;
  }

  public Vector vectorMayores() {
    Vector vector = new Vector(this.m.length);
    double mayor;
    for (int i = 0; i < this.m.length; i++) {
      mayor = this.m[i][0];
      for (int j = 1; j < this.m[0].length; j++) {
        if (this.m[i][j] > mayor) {
          mayor = this.m[i][j];
        }
      }
      vector.insertarElem(mayor, i);
    }
    return vector;
  }

  public Matriz suma(Matriz m) {
    Matriz suma = null;
    if (this.m.length == m.getCantFil() && this.m[0].length == m.getCantCol()) {
      suma = new Matriz(this.m.length, this.m[0].length);
      for (int i = 0; i < this.m.length; i++) {
        for (int j = 0; j < this.m[0].length; j++) {
          suma.setElem(i, j, this.m[i][j] + m.getElem(i, j));
        }
      }
    }
    return suma;
  }

  public Matriz producto(Matriz m) {
    Matriz producto = null;
    if (this.m[0].length == m.getCantFil()) {
      producto = new Matriz(this.m[0].length, m.getCantFil());
      for (int i = 0; i < this.m.length; i++) {
        for (int j = 0; j < this.m[0].length; j++) {
          producto.setElem(i, j, this.m[i][j] * m.getElem(j, i));
        }
      }
    }
    return producto;
  }

  public Matriz productox1Escalar(double k) {
    Matriz productox1Escalar = new Matriz(this.m.length, this.m[0].length);
    productox1Escalar.copy(this);
    for (int i = 0; i < this.m.length; i++) {
      for (int j = 0; j < this.m[0].length; j++) {
        productox1Escalar.setElem(i, j, productox1Escalar.getElem(i, j) * k);
      }
    }
    return productox1Escalar;
  }

  public Matriz transpuesta() {
    Matriz transpuesta = new Matriz(this.m[0].length, this.m.length);
    for (int i = 0; i < transpuesta.getCantFil(); i++) {
      for (int j = 0; j < transpuesta.getCantCol(); j++) {
        transpuesta.setElem(i, j, this.m[j][i]);
      }
    }
    return transpuesta;
  }

  public void mostrar() {
    for (int i = 0; i < this.m.length; i++) {
      for (int j = 0; j < this.m[0].length; j++) {
        System.out.println("Matriz[" + i + "][" + j + "]: " + this.m[i][j]);
      }
    }
  }
}
