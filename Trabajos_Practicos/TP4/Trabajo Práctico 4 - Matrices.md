**Ejercicio 1**: Considere el siguiente cuadro con cuatro filas y cinco columnas. La tabla contiene la tarifa por hora de programadores en función de su nivel o grado de habilidad. Las filas (horizontales) representan los niveles de habilidad, y las columnas (verticales) representan las etapas dentro de un nivel. Un programador con grado de habilidad 2, etapa 1 gana u$97,89 por hora.

![[1-TP4.png]]

- Declare una clase TablaEscaladeSueldos, con los atributos necesarios.
- Proporcione un método que permita obtener el promedio de paga horaria según el grado determinado de habilidad.
- Escriba un método que proporcione la diferencia entre la mayor y la menor paga horaria dentro de un nivel de habilidad determinada.
- Escriba un método que aumente cierto monto para todo un nivel determinado.

```java
public class TablaEscalaDeSueldos {
  private double[][] tabla;

  public double[][] getTabla() {
    return this.tabla;
  }

  public void setTabla(double[][] tabla) {
    this.tabla = tabla;
  }

  public TablaEscalaDeSueldos() {
    this.tabla = new double[4][5];
    this.tabla[0][0] = 28.16;
    this.tabla[0][1] = 32.18;
    this.tabla[0][2] = 38.89;
    this.tabla[0][3] = 44.92;
    this.tabla[0][4] = 48.27;
    this.tabla[1][0] = 54.98;
    this.tabla[1][1] = 59.67;
    this.tabla[1][2] = 64.37;
    this.tabla[1][3] = 70.40;
    this.tabla[1][4] = 75.09;
    this.tabla[2][0] = 91.18;
    this.tabla[2][1] = 97.89;
    this.tabla[2][2] = 101.91;
    this.tabla[2][3] = 108.21;
    this.tabla[2][4] = 115.32;
    this.tabla[3][0] = 134.10;
    this.tabla[3][1] = 160.91;
    this.tabla[3][2] = 187.73;
    this.tabla[3][3] = 214.55;
    this.tabla[3][4] = 268.16;
  }

  public double promedioSegunGradoHabilidad(int grado) {
    double promedio = 0;
    if (grado >= 0 && grado < 4) {
      double suma = 0;
      for (int i = 0; i < this.tabla[0].length; i++) {
        suma += this.tabla[grado][i];
      }
      promedio = suma / this.tabla[0].length;
    }
    return promedio;
  }

  public double diferenciaEntreMenorMayorPaga(int grado) {
    double diferencia = 0;
    if (grado >= 0 && grado < this.tabla[0].length) {
      diferencia = this.tabla[grado][4] - this.tabla[grado][0];
    }
    return diferencia;
  }

  public void aumentarMontoGrado(int grado, double monto) {
    if (grado >= 0 && grado < this.tabla[0].length && monto > 0) {
      for (int i = 0; i < this.tabla[0].length; i++) {
        this.tabla[grado][i] += monto;
      }
    }
  }

  @Override
  public String toString() {
    String cadena = "";
    for (int i = 0; i < this.tabla.length; i++) {
      for (int j = 0; j < this.tabla[0].length; j++) {
        cadena += "Grado " + i + ", Habilidad " + j + ": " + this.tabla[i][j] + "\n";
      }
    }
    return cadena;
  }

}
```

***

**Ejercicio 2**: Se tiene la información de la producción total de toneladas de cereales (arroz, avena, cebada, trigo) cosechadas durante cada mes del año anterior. Implemente una clase y los métodos que considere necesarios para proporcionar lo siguiente:

- El promedio anual de toneladas cosechadas por tipo de cereal.
- ¿Cuántos meses tuvieron una cosecha superior al promedio anual?
- ¿Cuántos meses tuvieron una cosecha inferior al promedio anual?
- ¿Cuál fue el mes en el que se produjo el mayor número de toneladas de cada cereal? ¿Puede utilizar la clase definida en el ejercicio anterior?

No se podría haber usado la clase del anterior ejercicio porque la tabla está construida de otra forma (tiene que haber sí o sí solo 12 columnas). Y hay algunas diferencias con la clase. Sin embargo, comparten algunas similitudes. Aquí la clase en sí:

Clase TablaProduccionAnualCereales:

```java
import java.util.ArrayList;

public class TablaProduccionAnualCereales {
  private int[][] tablaProduccion;

  public TablaProduccionAnualCereales(int[][] tablaProduccion) {
    if (tablaProduccion[0].length == 12) {
      this.tablaProduccion = tablaProduccion;
    }
  }

  public TablaProduccionAnualCereales(int cantidadCereales) {
    this.tablaProduccion = new int[cantidadCereales][12];
  }

  public TablaProduccionAnualCereales() {
  }

  public int[][] getTablaProduccion() {
    return this.tablaProduccion;
  }

  public void setTablaProduccion(int[][] tablaProduccion) {
    if (tablaProduccion[0].length == 12) {
      this.tablaProduccion = tablaProduccion;
    }
  }

  public ArrayList<Double> promedioAnualPorCereal() {
    ArrayList<Double> promedios = null;
    if (this.tablaProduccion != null) {
      promedios = new ArrayList<>();
      double suma = 0;
      for (int i = 0; i < this.tablaProduccion.length; i++) {
        for (int j = 0; j < this.tablaProduccion[0].length; j++) {
          suma += this.tablaProduccion[i][j];
        }
        promedios.add(suma / this.tablaProduccion[0].length);
      }
    }
    return promedios;
  }

  public ArrayList<Integer> cantidadMesesConMayorProduccionAlPromedio() {
    ArrayList<Integer> cantidad = null;
    if (this.tablaProduccion != null) {
      int contador = 0;
      cantidad = new ArrayList<>();
      ArrayList<Double> promedios = promedioAnualPorCereal();
      for (int i = 0; i < this.tablaProduccion.length; i++) {
        for (int j = 0; j < this.tablaProduccion[0].length; j++) {
          if (promedios.get(i) < this.tablaProduccion[i][j]) {
            ++contador;
          }
        }
        cantidad.add(contador);
      }
    }
    return cantidad;
  }

  public ArrayList<Integer> cantidadMesesConMenorProduccionAlPromedio() {
    ArrayList<Integer> cantidad = null;
    if (this.tablaProduccion != null) {
      int contador = 0;
      cantidad = new ArrayList<>();
      ArrayList<Double> promedios = promedioAnualPorCereal();
      for (int i = 0; i < this.tablaProduccion.length; i++) {
        for (int j = 0; j < this.tablaProduccion[0].length; j++) {
          if (promedios.get(i) > this.tablaProduccion[i][j]) {
            ++contador;
          }
        }
        cantidad.add(contador);
      }
    }
    return cantidad;
  }

  public ArrayList<String> mesesDeMayorProduccion() {
    ArrayList<String> meses = null;
    if (this.tablaProduccion != null) {
      meses = new ArrayList<>();
      int mes = 0;
      int mayor = 0;
      for (int i = 0; i < this.tablaProduccion.length; i++) {
        for (int j = 0; j < this.tablaProduccion[0].length; j++) {
          if (this.tablaProduccion[i][j] > mayor) {
            mayor = this.tablaProduccion[i][j];
            mes = j;
          }
        }
        mayor = 0;
        meses.add(mes(mes));
      }
    }
    return meses;
  }

  private String mes(int mes) {
    String mesCadena = null;
    switch (mes) {
      case 0:
        mesCadena = "Enero";
        break;
      case 1:
        mesCadena = "Febrero";
        break;
      case 2:
        mesCadena = "Marzo";
        break;
      case 3:
        mesCadena = "Abril";
        break;
      case 4:
        mesCadena = "Mayo";
        break;
      case 5:
        mesCadena = "Junio";
        break;
      case 6:
        mesCadena = "Julio";
        break;
      case 7:
        mesCadena = "Agosto";
        break;
      case 8:
        mesCadena = "Septiembre";
        break;
      case 9:
        mesCadena = "Octubre";
        break;
      case 10:
        mesCadena = "Noviembre";
        break;
      case 11:
        mesCadena = "Diciembre";
        break;
      default:
        System.out.println("Mes no reconocido");
        break;
    }
    return mesCadena;
  }

  @Override
  public String toString() {
    String cadena = "";
    if (this.tablaProduccion != null) {
      for (int i = 0; i < this.tablaProduccion.length; i++) {
        for (int j = 0; j < this.tablaProduccion[0].length; j++) {
          cadena += "Cereal " + i + ", Mes: " + mes(j) + ", Toneladas cosechadas: " + this.tablaProduccion[i][j] + "\n";
        }
      }
    }
    return cadena;
  }

}
```

***

**Ejercicio 3**: Un observatorio astronómico requiere analizar la fotografía del cielo tomada por la noche. La información de la fotografía está almacenada en forma de tabla, donde cada elemento representa la cantidad de luz registrada para cada punto. Los valores registrados van desde 0 a 255.

![[3a-TP4.png]]

De esta manera para cada imagen obtendríamos su tabla correspondiente:

![[3b-TP4.png]]

Para analizar la información se supone que hay una estrella en (i, j) si:
- el punto no se encuentra en las orillas de la fotografía (primero o último renglón o columna).
- (imagen\[i,j] + imagen\[i - 1,j] + imagen\[i + 1, j] + imagen\[i, j-1] + imagen\[i, j + 1]) > 600

Se espera como resultado del análisis, una nueva tabla de estrellas con un "\*" en las parejas (i, j) en las que se supone que hay una estrella. El resto de la tabla debe quedar lleno de espacios.

![[3c-TP4.png]]

Implemente las clases necesarias para:
- Almacenar los valores de la fotografía.
- Leer los valores de cada elemento de la fotografía.
- Construir la "tabla" de salida Estrellas.
- Imprima la tabla Estrellas.

```java
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
```

***

**Ejercicio 4**: Para el siguiente diagrama:

![[4-TP4.png]]

Donde:
```equals(m: Matriz): boolean``` Decide si la Matriz es igual a una recibida como parámetro.
```esTriangSup(): boolean``` Decide si la matriz es triangular superior si los elementos por debajo de su diagonal principal son cero.
```esTriangInf(): boolean``` Decide si la matriz es triangular inferior si los elementos por encima de su diagonal principal son cero.
```esRala(): boolean``` Una matriz es rala si más de la mitad de los elementos son cero.
```vectoresMayores(): Vector``` Genera un vector con los mayores elementos de cada fila de modo tal que el iésimo elemento del vector sea el mayor elemento de la fila i de la matriz.
```suma(m: Matriz): Matriz``` Computa la matriz suma con una matriz dada, asumiendo que los subíndices han sido validados.
```producto(m: Matriz): Matriz``` Computa la matriz producto con una matriz dada, asumiendo que los subíndices han sido validados.
```productox1Escalar(m: Matriz): Matriz``` Computa la matriz producto con un escalar real dado.
```transpuesta(): Matriz``` Computa la matriz transpuesta.

Se pide:
- Implementar la clase Matriz modelada en el diagrama.
- Implementar un TestMatriz para la clase Matriz, definiendo adecuadamente los casos de prueba.

Clase Matriz:

```java
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
```

Clase Vector:

```java
public class Vector {
  double[] vector;

  public double[] getVector() {
    return this.vector;
  }

  public void setVector(double[] vector) {
    this.vector = vector;
  }

  public Vector(double[] vector) {
    this.vector = vector;
  }

  public Vector(int tam) {
    this.vector = new double[tam];
  }

  public void insertarElem(double elem, int indice) {
    if (indice >= 0 && indice < this.vector.length) {
      this.vector[indice] = elem;
    }
  }

  public void mostrar() {
    for (int i = 0; i < this.vector.length; i++) {
      System.out.println("Vector[" + i + "]: " + this.vector[i]);
    }
  }
}
```

Clase TestMatriz:

```java
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
```