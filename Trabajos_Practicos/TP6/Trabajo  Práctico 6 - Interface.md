**Ejercicio 1**: De acuerdo al siguiente diagrama de clases implementar la clase Linea que utilice la interface ```Relacion``` para comparar longitudes.

![[1-TP6.png]]

Interface Relacion:

```java
public interface Relacion {
  public abstract boolean esMasGrande(Object otro);

  public abstract boolean esMasChico(Object otro);

  public abstract boolean esIgual(Object otro);
}
```

Clase LInea:

```java
public class Linea implements Relacion {
  private double x1;
  private double y1;
  private double x2;
  private double y2;

  public Linea(double x1, double y1, double x2, double y2) {
    this.y2 = y2;
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
  }

  public double getLongitud() {
    double longitud = 0;
    if (this.x1 != this.x2 || this.y1 != this.y2) {
      longitud = Math.sqrt(Math.pow(this.x2 - this.x1, 2) + Math.pow(this.y2 - this.y1, 2));
    }
    return longitud;
  }

  @Override
  public boolean esMasGrande(Object otro) {
    boolean loEs = false;
    if (otro instanceof Linea) {
      loEs = ((Linea) otro).getLongitud() < getLongitud();
    }
    return loEs;
  }

  @Override
  public boolean esMasChico(Object otro) {
    boolean loEs = false;
    if (otro instanceof Linea) {
      loEs = ((Linea) otro).getLongitud() > getLongitud();
    }
    return loEs;
  }

  @Override
  public boolean esIgual(Object otro) {
    boolean loEs = false;
    if (otro instanceof Linea) {
      loEs = ((Linea) otro).getLongitud() == getLongitud();
    }
    return loEs;
  }
}
```

***

**Ejercicio 2**: Dadas las siguientes interfaces:

```java
public interface InterfacePersona {
  double estimarCapital();
  String getNombre();
}

public interface InterfaceMortandad {
  public double esperanzaDeVida();
}
```

Cree una clase ```Jubilado``` que, además de implementar las interfaces, tenga los siguientes atributos: ```dineroAhorrado```, ```jubilacionAnual```, ```nombre```, ```apellido```, ```edad```. Los datos para calcular la esperanza de vida a la edad exacta $x$ se obtienen de la ```Tabla``` suministrada (con valores $l_{x}, L_{x}$) y se utilizan en la siguiente fórmula:

$$
e_{x}=\frac{T_{x}}{l_{x}}, \text{ donde } T_{x}=\sum ^{n}_{i=x}L_{i}
$$
$e$: esperanza de vida a la edad exacta $x$.
$l_{x}$: número de personas vivas a la edad exacta $x$.
$L_{x}$: número promedio de personas vivas en el intervalo $[x, x+h]$
$T_{x}$: población total con edad $\geq x$

Tenga en cuenta que para estimar el capital deberá considerar el dinero ahorrado, la edad del jubilado, su esperanza de vida y su jubilación anual.

| Edad  | $l_{x}$ | $L_{x}$ |
| :---: | :-----: | :-----: |
|  <1   | 100.000 | 98.700  |
|  1-4  | 98.660  | 395.000 |
|  5-9  | 98.430  | 491.500 |
| 10-14 | 98.304  | 491.000 |
| 15-19 | 98.153  | 489.500 |
| 20-24 | 97.713  | 487.000 |
| 25-29 | 97.090  | 484.000 |
| 30-34 | 96.354  | 479.000 |
| 35-39 | 95.482  | 475.000 |
| 40-44 | 94.428  | 469.000 |
| 45-49 | 93.164  | 461.000 |
| 50-54 | 91.374  | 450.000 |
| 55-59 | 88.737  | 433.000 |
| 60-64 | 84.833  | 410.000 |
| 65-69 | 79.152  | 376.000 |
| 70-74 | 71.439  | 330.000 |
| 75-79 | 60.710  | 270.000 |
| 80-84 | 47.119  | 198.000 |
| 85-89 | 32.208  | 125.000 |
| 90-94 | 17.889  | 58.500  |
| 95-99 |  7.562  | 19.000  |
| 100+  |  2.243  |  5.000  |

Clase Tabla:

```java
public class Tabla {
  private int[][] tabla;

  public Tabla() {
    this.tabla = new int[22][2];
    cargarTabla();
  }

  private void cargarTabla() {
    this.tabla[0][0] = 100000;
    this.tabla[0][1] = 98700;
    this.tabla[1][0] = 98660;
    this.tabla[1][1] = 395000;
    this.tabla[2][0] = 98430;
    this.tabla[2][1] = 491500;
    this.tabla[3][0] = 98304;
    this.tabla[3][1] = 491000;
    this.tabla[4][0] = 98153;
    this.tabla[4][1] = 489500;
    this.tabla[5][0] = 97713;
    this.tabla[5][1] = 487000;
    this.tabla[6][0] = 97090;
    this.tabla[6][1] = 484000;
    this.tabla[7][0] = 96354;
    this.tabla[7][1] = 479000;
    this.tabla[8][0] = 95482;
    this.tabla[8][1] = 475000;
    this.tabla[9][0] = 94428;
    this.tabla[9][1] = 469000;
    this.tabla[10][0] = 93164;
    this.tabla[10][1] = 461000;
    this.tabla[11][0] = 91374;
    this.tabla[11][1] = 450000;
    this.tabla[12][0] = 88737;
    this.tabla[12][1] = 433000;
    this.tabla[13][0] = 84833;
    this.tabla[13][1] = 410000;
    this.tabla[14][0] = 79152;
    this.tabla[14][1] = 376000;
    this.tabla[15][0] = 71439;
    this.tabla[15][1] = 330000;
    this.tabla[16][0] = 60710;
    this.tabla[16][1] = 270000;
    this.tabla[17][0] = 47119;
    this.tabla[17][1] = 198000;
    this.tabla[18][0] = 32208;
    this.tabla[18][1] = 125000;
    this.tabla[19][0] = 17889;
    this.tabla[19][1] = 58500;
    this.tabla[20][0] = 7562;
    this.tabla[20][1] = 19000;
    this.tabla[21][0] = 2243;
    this.tabla[21][1] = 5000;
  }

  public double calcularEsperanzaDeVida(int edadActual) {
    double esperanzaDeVida = 0;
    int pos = posEdadTabla(edadActual);
    if (pos < 21) {
      int sumatoria = 0;
      for (int i = pos; i < this.tabla.length; i++) {
        sumatoria += this.tabla[i][1];
      }
      esperanzaDeVida = (double) sumatoria / this.tabla[pos][0];
    } else {
      esperanzaDeVida = (double) this.tabla[pos][1] / this.tabla[pos][0];
    }
    return esperanzaDeVida;
  }

  private int posEdadTabla(int edad) {
    int pos;
    switch (edad) {
      case 1:
      case 2:
      case 3:
      case 4:
        pos = 1;
        break;
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
        pos = 2;
        break;
      case 10:
      case 11:
      case 12:
      case 13:
      case 14:
        pos = 3;
        break;
      case 15:
      case 16:
      case 17:
      case 18:
      case 19:
        pos = 4;
        break;
      case 20:
      case 21:
      case 22:
      case 23:
      case 24:
        pos = 5;
        break;
      case 25:
      case 26:
      case 27:
      case 28:
      case 29:
        pos = 6;
        break;
      case 30:
      case 31:
      case 32:
      case 33:
      case 34:
        pos = 7;
        break;
      case 35:
      case 36:
      case 37:
      case 38:
      case 39:
        pos = 8;
        break;
      case 40:
      case 41:
      case 42:
      case 43:
      case 44:
        pos = 9;
        break;
      case 45:
      case 46:
      case 47:
      case 48:
      case 49:
        pos = 10;
        break;
      case 50:
      case 51:
      case 52:
      case 53:
      case 54:
        pos = 11;
        break;
      case 55:
      case 56:
      case 57:
      case 58:
      case 59:
        pos = 12;
        break;
      case 60:
      case 61:
      case 62:
      case 63:
      case 64:
        pos = 13;
        break;
      case 65:
      case 66:
      case 67:
      case 68:
      case 69:
        pos = 14;
        break;
      case 70:
      case 71:
      case 72:
      case 73:
      case 74:
        pos = 15;
        break;
      case 75:
      case 76:
      case 77:
      case 78:
      case 79:
        pos = 16;
        break;
      case 80:
      case 81:
      case 82:
      case 83:
      case 84:
        pos = 17;
        break;
      case 85:
      case 86:
      case 87:
      case 88:
      case 89:
        pos = 18;
        break;
      case 90:
      case 91:
      case 92:
      case 93:
      case 94:
        pos = 19;
        break;
      case 95:
      case 96:
      case 97:
      case 98:
      case 99:
        pos = 20;
        break;
      default:
        pos = 21;
        break;
    }
    if (edad < 1) {
      pos = 0;
    }
    return pos;
  }
}
```

Clase Jubilado:

```java
public class Jubilado implements InterfacePersona, InterfaceMortandad {
  private double dineroAhorrado;
  private double jubilacionAnual;
  private String nombre;
  private String apellido;
  private int edad;
  private Tabla tablaMortandad;

  public Jubilado(double dineroAhorrado, double jubilacionAnual, String nombre, String apellido, int edad) {
    this.dineroAhorrado = dineroAhorrado;
    this.jubilacionAnual = jubilacionAnual;
    this.nombre = nombre;
    this.apellido = apellido;
    this.edad = edad;
    this.tablaMortandad = new Tabla();
  }

  @Override
  public double esperanzaDeVida() {
    return tablaMortandad.calcularEsperanzaDeVida(this.edad);
  }

  @Override
  public double estimarCapital() {
    return this.dineroAhorrado + (this.tablaMortandad.calcularEsperanzaDeVida(this.edad) * this.jubilacionAnual);
  }

  @Override
  public String getNombre() {
    return this.nombre + " " + this.apellido;
  }
}
```

***

**Ejercicio 3**: Supongamos que tenemos un conjunto de objetos con algunos comportamientos comunes: se pueden mover hacia arriba, abajo, izquierda o derecha. Las conductas exactas (por ejemplo, cómo moverse y que tan lejos moverse) dependen de los objetos mismos.

![[3a-TP6.png]]

Teniendo en cuenta el diagrama de clases, implementar las clases y métodos correspondientes. En otra clase instancie objetos de tipo ```CirculoMovible``` y pruebe sus movimientos.
Escriba una nueva clase ```RectanguloMovible```, compuesta por dos puntos movibles, e implemente la interface ```Movible```, tenga en cuenta que los dos puntos deben tener la misma velocidad.

![[3b-TP6.png]]

Interface Movible:

```java
public interface Movible {
  public abstract void moverArriba();

  public abstract void moverAbajo();

  public abstract void moverIzquierda();

  public abstract void moverDerecha();
}
```

Clase PuntoMovible: 

```java
public class PuntoMovible implements Movible {
  private int x;
  private int y;
  private int xVelocidad;
  private int yVelocidad;

  public PuntoMovible(int x, int y, int xVelocidad, int yVelocidad) {
    this.x = x;
    this.y = y;
    this.xVelocidad = xVelocidad;
    this.yVelocidad = yVelocidad;
  }

  @Override
  public void moverArriba() {
    this.y += this.yVelocidad;
  }

  @Override
  public void moverAbajo() {
    this.y -= this.yVelocidad;
  }

  @Override
  public void moverIzquierda() {
    this.x -= this.xVelocidad;
  }

  @Override
  public void moverDerecha() {
    this.x += this.xVelocidad;
  }

  public int getX() {
    return this.x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return this.y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public int getxVelocidad() {
    return this.xVelocidad;
  }

  public void setxVelocidad(int xVelocidad) {
    this.xVelocidad = xVelocidad;
  }

  public int getyVelocidad() {
    return this.yVelocidad;
  }

  public void setyVelocidad(int yVelocidad) {
    this.yVelocidad = yVelocidad;
  }

  @Override
  public String toString() {
    return "PuntoMovible [x=" + this.x + ", y=" + this.y + ", xVelocidad=" + this.xVelocidad + ", yVelocidad="
        + this.yVelocidad + "]";
  }

}
```

Clase CirculoMovible:

```java
public class CirculoMovible implements Movible {
  private int radio;
  private PuntoMovible centro;

  public CirculoMovible(int x, int y, int xVelocidad, int yVelocidad, int radio) {
    this.radio = radio;
    this.centro = new PuntoMovible(x, y, xVelocidad, yVelocidad);
  }

  @Override
  public void moverArriba() {
    this.centro.moverArriba();
  }

  @Override
  public void moverAbajo() {
    this.centro.moverAbajo();
  }

  @Override
  public void moverIzquierda() {
    this.centro.moverIzquierda();
  }

  @Override
  public void moverDerecha() {
    this.centro.moverDerecha();
  }

  @Override
  public String toString() {
    return "CirculoMovible [radio=" + this.radio + ", centro=" + this.centro + "]";
  }
}
```

Clase RectanguloMovible:

```java
public class RectanguloMovible implements Movible {
  private PuntoMovible supIzq;
  private PuntoMovible infDer;

  public RectanguloMovible(int x1, int y1, int x2, int y2, int xVelocidad, int yVelocidad) {
    if (x1 != x2 || y1 != y2) {
      this.supIzq = new PuntoMovible(x1, y1, xVelocidad, yVelocidad);
      this.infDer = new PuntoMovible(x2, y2, xVelocidad, yVelocidad);
    }
  }

  @Override
  public void moverArriba() {
    this.supIzq.moverArriba();
    this.infDer.moverArriba();
  }

  @Override
  public void moverAbajo() {
    this.supIzq.moverAbajo();
    this.infDer.moverAbajo();
  }

  @Override
  public void moverIzquierda() {
    this.supIzq.moverIzquierda();
    this.infDer.moverIzquierda();
  }

  @Override
  public void moverDerecha() {
    this.supIzq.moverDerecha();
    this.infDer.moverDerecha();
  }

  @Override
  public String toString() {
    return "RectanguloMovible [supIzq=" + this.supIzq + ", infDer=" + this.infDer + "]";
  }

}
```

Clase Main:

```java
public class Main {
  public static void main(String[] args) {
    CirculoMovible circulo = new CirculoMovible(0, 0, 4, 4, 3);
    System.out.println(circulo);
    circulo.moverAbajo();
    System.out.println(circulo);
    circulo.moverArriba();
    circulo.moverIzquierda();
    System.out.println(circulo);
    circulo.moverDerecha();
    System.out.println(circulo);
    RectanguloMovible rectangulo = new RectanguloMovible(0, 0, 3, 3, 2, 2);
    rectangulo.moverArriba();
    rectangulo.moverDerecha();
    System.out.println(rectangulo);
    rectangulo.moverIzquierda();
    rectangulo.moverAbajo();
    System.out.println(rectangulo);
  }
}
```

***

**Ejercicio 4**: Escribir las clases correspondientes al siguiente diagrama de clases y pruebe los métodos definidos en ```CirculoRedimensionable``` en una ```TestCirculoRedimensionable```.

![[4-TP6.png]]

Interface ObjetoGeometrico:

```java
public interface ObjetoGeometrico {

  public abstract double getArea();

  public abstract double getPerimetro();
}
```

Interface Redimensionable:

```java
public interface Redimensionable {
  public abstract void redimensionar(int porcentaje);
}
```

Clase Circulo:

```java
public class Circulo implements ObjetoGeometrico {
  protected double radio;

  public Circulo(double radio) {
    this.radio = radio;
  }

  @Override
  public double getArea() {
    double area = 0;
    if (this.radio > 0) {
      area = Math.PI * Math.pow(this.radio, 2);
    }
    return area;
  }

  @Override
  public double getPerimetro() {
    double perimetro = 0;
    if (this.radio > 0) {
      perimetro = 2 * Math.PI * this.radio;
    }
    return perimetro;
  }

}
```

Clase CirculoRedimensionable:

```java
public class CirculoRedimensionable extends Circulo implements Redimensionable {

  public CirculoRedimensionable(double radio) {
    super(radio);
  }

  @Override
  public void redimensionar(int porcentaje) {
    double redimension = this.radio * ((double) porcentaje / 100);
    this.radio = redimension;
  }

}
```

Clase TestCirculoRedimensionable:

```java
public class TestCirculoRedimensionable {
  public static void main(String[] args) {
    CirculoRedimensionable circulo = new CirculoRedimensionable(5);
    System.out.println("El area del circulo es: " + circulo.getArea());
    System.out.println("El perimetro del circulo es: " + circulo.getPerimetro());
    System.out.println("Ahora el circulo se redimensiona a un 30%");
    circulo.redimensionar(30);
    System.out.println("Area del nuevo circulo: " + circulo.getArea());
    System.out.println("Perimetro del nuevo circulo: " + circulo.getPerimetro());
  }
}
```

***

**Ejercicio 5**: De acuerdo al siguiente diagrama de clases, escribir las clases ```Jeep```, ```Aerodeslizador``` y ```Crucero```, con todos sus atributos y métodos necesarios.

![[5-TP6.png]]

En otra clase ```TestTransportes``` cargar un arreglo de distintos transportes y hacer que los vehículos terrestres toquen bocina.
Escriba una nueva interface ```Emergencia```, que no extienda de ninguna de las otras interfaces y que tenga un sólo método ```sonarSirena()``` que no devuelva ningún valor.
Crear una clase ```Patrullero``` que implementa las interfaces ```Emergencia``` y ```TransporteTerrestre```.

Interface Transporte:

```java
public interface Transporte {
  public abstract String getNombre();

  public abstract void setNombre(String nombre);

  public abstract int getMaxPasajeros();

  public abstract void setMaxPasajeros(int maxp);

  public abstract int getMaxVelocidad();

  public abstract void setMaxVelocidad(int maxv);
}
```

Interface TransporteMaritimo:

```java
public interface TransporteMaritimo extends Transporte {
  public abstract int getDesplazamiento();

  public abstract void setDesplazamiento(int desplazamiento);

  public abstract void zarpar();
}
```

Interface TransporteTerrestre:

```java
public interface TransporteTerrestre extends Transporte {
  public abstract int getNumRuedas();

  public abstract void setNumRuedas(int numRuedas);

  public abstract void manejar();

  public abstract void tocarBocina();
}
```

Clase Jeep:

```java
public class Jeep implements TransporteTerrestre {
  private String nombre;
  private int maxPasajeros;
  private int maxVelocidad;
  private int numRuedas;

  public Jeep() {
  }

  public Jeep(String nombre, int maxPasajeros, int maxVelocidad, int numRuedas) {
    this.nombre = nombre;
    this.maxPasajeros = maxPasajeros;
    this.maxVelocidad = maxVelocidad;
    this.numRuedas = numRuedas;
  }

  @Override
  public String getNombre() {
    return this.nombre;
  }

  @Override
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  @Override
  public int getMaxPasajeros() {
    return this.maxPasajeros;
  }

  @Override
  public void setMaxPasajeros(int maxp) {
    this.maxPasajeros = maxp;
  }

  @Override
  public int getMaxVelocidad() {
    return this.maxVelocidad;
  }

  @Override
  public void setMaxVelocidad(int maxv) {
    this.maxVelocidad = maxv;
  }

  @Override
  public int getNumRuedas() {
    return this.numRuedas;
  }

  @Override
  public void setNumRuedas(int numRuedas) {
    this.numRuedas = numRuedas;
  }

  @Override
  public void manejar() {
    System.out.println("Manjeando...");
  }

  @Override
  public void tocarBocina() {
    System.out.println("Hacer ruido de bocina");
  }

}
```

Clase Crucero:

```java
public class Crucero implements TransporteMaritimo {
  private String nombre;
  private int maxPasajeros;
  private int maxVelocidad;
  private int desplazamiento;

  public Crucero() {
  }

  public Crucero(String nombre, int maxPasajeros, int maxVelocidad, int desplazamiento) {
    this.nombre = nombre;
    this.maxPasajeros = maxPasajeros;
    this.maxVelocidad = maxVelocidad;
    this.desplazamiento = desplazamiento;
  }

  @Override
  public String getNombre() {
    return this.nombre;
  }

  @Override
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  @Override
  public int getMaxPasajeros() {
    return this.maxPasajeros;
  }

  @Override
  public void setMaxPasajeros(int maxp) {
    this.maxPasajeros = maxp;
  }

  @Override
  public int getMaxVelocidad() {
    return this.maxVelocidad;
  }

  @Override
  public void setMaxVelocidad(int maxv) {
    this.maxVelocidad = maxv;
  }

  @Override
  public int getDesplazamiento() {
    return this.desplazamiento;
  }

  @Override
  public void setDesplazamiento(int desplazamiento) {
    this.desplazamiento = desplazamiento;
  }

  @Override
  public void zarpar() {
    System.out.println("Zarpando...");
  }

  public void disparar() {
    System.out.println("Disparando...");
  }
}
```

Clase Aerodeslizador:

```java
public class Aerodeslizador implements TransporteMaritimo, TransporteTerrestre {
  private String nombre;
  private int maxPasajeros;
  private int maxVelocidad;
  private int desplazamiento;
  private int numRuedas;

  public Aerodeslizador() {
  }

  public Aerodeslizador(String nombre, int maxPasajeros, int maxVelocidad, int desplazamiento, int numRuedas) {
    this.nombre = nombre;
    this.maxPasajeros = maxPasajeros;
    this.maxVelocidad = maxVelocidad;
    this.desplazamiento = desplazamiento;
    this.numRuedas = numRuedas;
  }

  @Override
  public String getNombre() {
    return this.nombre;
  }

  @Override
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  @Override
  public int getMaxPasajeros() {
    return this.maxPasajeros;
  }

  @Override
  public void setMaxPasajeros(int maxp) {
    this.maxPasajeros = maxp;
  }

  @Override
  public int getMaxVelocidad() {
    return this.maxVelocidad;
  }

  @Override
  public void setMaxVelocidad(int maxv) {
    this.maxVelocidad = maxv;
  }

  @Override
  public int getNumRuedas() {
    return this.numRuedas;
  }

  @Override
  public void setNumRuedas(int numRuedas) {
    this.numRuedas = numRuedas;
  }

  @Override
  public void manejar() {
    System.out.println("Manejando...");
  }

  @Override
  public void tocarBocina() {
    System.out.println("Ruido de bocina");
  }

  @Override
  public int getDesplazamiento() {
    return this.desplazamiento;
  }

  @Override
  public void setDesplazamiento(int desplazamiento) {
    this.desplazamiento = desplazamiento;
  }

  @Override
  public void zarpar() {
    System.out.println("Zarpando...");
  }

  public void viajarPorTierra() {
    manejar();
  }

  public void viajarPorAgua() {
    zarpar();
  }
}
```

Clase TestTransporte:

```java
import java.util.ArrayList;

public class TestTransportes {
  public static void main(String[] args) {
    ArrayList<Transporte> transportes = new ArrayList<>();
    Jeep jeep = new Jeep("Gladiator", 5, 280, 4);
    Aerodeslizador aerodeslizador = new Aerodeslizador("Aero", 3, 400, 200, 4);
    Crucero crucero = new Crucero("Crux", 100, 400, 5000);
    transportes.add(jeep);
    transportes.add(aerodeslizador);
    transportes.add(crucero);
    for (Transporte transporte : transportes) {
      if (transporte instanceof TransporteTerrestre) {
        ((TransporteTerrestre) transporte).tocarBocina();
      }
    }
  }
}
```

Interface Emergencia:

```java
public interface Emergencia {
  public abstract void sonarSirena();
}
```

Clase Patrullero:

```java
public class Patrullero implements Emergencia, TransporteTerrestre {
  private String nombre;
  private int maxPasajeros;
  private int maxVelocidad;
  private int numRuedas;

  public Patrullero(String nombre, int maxPasajeros, int maxVelocidad, int numRuedas) {
    this.nombre = nombre;
    this.maxPasajeros = maxPasajeros;
    this.maxVelocidad = maxVelocidad;
    this.numRuedas = numRuedas;
  }

  public Patrullero() {
  }

  @Override
  public String getNombre() {
    return this.nombre;
  }

  @Override
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  @Override
  public int getMaxPasajeros() {
    return this.maxPasajeros;
  }

  @Override
  public void setMaxPasajeros(int maxp) {
    this.maxPasajeros = maxp;
  }

  @Override
  public int getMaxVelocidad() {
    return this.maxVelocidad;
  }

  @Override
  public void setMaxVelocidad(int maxv) {
    this.maxVelocidad = maxv;
  }

  @Override
  public int getNumRuedas() {
    return this.numRuedas;
  }

  @Override
  public void setNumRuedas(int numRuedas) {
    this.numRuedas = numRuedas;
  }

  @Override
  public void manejar() {
    System.out.println("Manjeando...");
  }

  @Override
  public void tocarBocina() {
    System.out.println("Ruido de bocina");
  }

  @Override
  public void sonarSirena() {
    System.out.println("Sirena de emergencia!!");
  }

}
```
