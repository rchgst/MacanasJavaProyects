**Ejercicio 1**: Desarrolle una clase que maneje una lista de números reales, usando la clase ArrayList de Java. Teniendo en cuenta que la Lista puede tener capacidad para $n$, pero sólo tener cargados $m$ elementos ($m\leq n$), definir sus atributos (si corresponde) y métodos de tal forma que la clase permita:
- Determinar si existe un elemento.
- Determinar la suma de todos los elementos de la lista.
- Determinar el menor elemento.
- Determinar el mayor elemento.
- Determinar el elemento más frecuente.
- Determinar el promedio de los elementos de la lista.
- Sumar componente a componente otra lista (verificar que sean del mismo tamaño).
- Multiplicar componente a componente por otra lista. (verificar que sean del mismo tamaño).
- Multiplicar todos los elementos  de la lista por un valor ingresado. Sobrecarga?
- Determinar la suma de los elementos de la lista entre dos posiciones dadas.
- Ordenar los elementos de menor a mayor.

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ListaNumerosReales {
  private int n;
  private int m;
  private ArrayList<Double> listaNumerosReales;

  public int getN() {
    return this.n;
  }

  public void setN(int n) {
    this.n = n;
  }

  public int getM() {
    return this.m;
  }

  public ArrayList<Double> getListaNumerosReales() {
    return this.listaNumerosReales;
  }

  public void setListaNumerosReales(ArrayList<Double> listaNumerosReales) {
    if (this.n >= listaNumerosReales.size()) {
      this.listaNumerosReales = listaNumerosReales;
      this.m = listaNumerosReales.size();
    } else {
      System.out.println("La lista es demasiado grande para este objeto");
      System.out.println("El limite de elementos es de " + this.n);
    }
  }

  public ListaNumerosReales() {
    this.listaNumerosReales = new ArrayList<>();
  }

  public ListaNumerosReales(int n) {
    this();
    this.n = n;
  }

  public void agregarNumero(double num) {
    if (this.n > this.m) {
      this.listaNumerosReales.add(num);
      ++this.m;
    } else {
      System.out.println("No se pueden agregar mas elmentos a esta lista!");
    }
  }

  public void eliminarNumero(double num) {
    this.listaNumerosReales.remove(Double.valueOf(num));
    --this.m;
  }

  public boolean existeElemento(double num) {
    return this.listaNumerosReales.contains(Double.valueOf(num));
  }

  public double sumarElementosLista() {
    double suma = 0;
    for (Double double1 : this.listaNumerosReales) {
      suma += double1;
    }
    return suma;
  }

  public double menorDeLaLista() {
    if (this.listaNumerosReales.size() > 0) {
      return this.listaNumerosReales.stream().min((d1, d2) -> d1.compareTo(d2)).get();
    } else {
      System.out.println("No hay elementos cargados en la lista.");
      return 0.0;
    }
  }

  public double mayorDeLaLista() {
    if (this.listaNumerosReales.size() > 0) {
      return this.listaNumerosReales.stream().max((d1, d2) -> d1.compareTo(d2)).get();
    } else {
      System.out.println("No hay elementos cargados en la lista.");
      return 0.0;
    }
  }

  public double elementoMasFrecuente() {
    if (this.listaNumerosReales.size() > 0) {
      List<Double> list = this.listaNumerosReales.stream().distinct().collect(Collectors.toList());
      double masRepetido = 0;
      int repeticion = 0, mayorRepeticion = 0;
      for (Double double1 : list) {
        repeticion = Collections.frequency(this.listaNumerosReales, double1);
        if (repeticion > mayorRepeticion) {
          masRepetido = double1;
          mayorRepeticion = repeticion;
        }
        repeticion = 0;
      }
      return masRepetido;
    } else {
      System.out.println("No hay elementos cargados en la lista.");
      return 0.0;
    }
  }

  public double promedioDeLaLista() {
    if (this.listaNumerosReales.size() > 0) {
      int suma = 0;
      for (Double double1 : this.listaNumerosReales) {
        suma += double1;
      }
      return suma / this.listaNumerosReales.size();
    } else {
      System.out.println("La lista esta vacia!");
      return 0;
    }
  }

  public ArrayList<Double> sumaDeListas(ArrayList<Double> lista) {
    ArrayList<Double> suma = new ArrayList<>();
    if (lista.size() == this.m) {
      for (int i = 0; i < this.m; i++) {
        suma.add(lista.get(i) + this.listaNumerosReales.get(i));
      }
    } else {
      System.out.println("No se puede realizar la suma entre ambas listas!");
    }
    return suma;
  }

  public ArrayList<Double> multiplicarLista(ArrayList<Double> lista) {
    ArrayList<Double> multiplicacion = new ArrayList<Double>();
    if (this.listaNumerosReales.size() == lista.size()) {
      for (int i = 0; i < this.listaNumerosReales.size(); i++) {
        multiplicacion.add(this.listaNumerosReales.get(i) * lista.get(i));
      }
    } else {
      System.out.println("No se puede realizar la multiplicacion entre las listas!");
    }
    return multiplicacion;
  }

  public ArrayList<Double> multiplicarLista(double valor) {
    ArrayList<Double> multiplicacion = new ArrayList<>();
    if (this.listaNumerosReales.size() > 0) {
      for (Double double1 : this.listaNumerosReales) {
        multiplicacion.add(valor * double1);
      }
    } else {
      System.out.println("La lista esta vacia!");
    }
    return multiplicacion;
  }

  public double sumarDosElementos(int i1, int i2) {
    int mayor = (i1 >= i2) ? i1 : i2;
    double resultado = 0;
    if (this.listaNumerosReales.size() >= mayor) {
      resultado = this.listaNumerosReales.get(i1) + this.listaNumerosReales.get(i2);
    } else {
      System.out.println("No es posible realizar la suma con esos valores");
    }
    return resultado;
  }

  public ArrayList<Double> listaOrdenada() {
    return (ArrayList<Double>) this.listaNumerosReales.stream().sorted().collect(Collectors.toList());
  }
}
```

***

**Ejercicio 2:** Los surtidores de combustible de una estación de YPF son capaces de proveer 4 tipos de combustibles: ULTRADIESEL, EURODIESEL, SUPER e INFINIA. Todos  los surtidores pueden almacenar un máximo de 20.000 litros de cada combustible. Cada surtidor lleva el registro de la cantidad de litros disponibles en depósito de cada tipo de combustible, y al momento de crearse un surtidor se inicializa con la cantidad máxima. En cada surtidor es posible cargar o reponer combustible. Si la cantidad de un tipo de combustible en particular de un surtidor específico no es suficiente para completar una carga, se carga lo que se pueda y cuando el depósito del surtidor queda vacío si no se completo la carga se muestra un mensaje. Cuando se repone un combustible en el surtidor, se llena el depósito completo de ese combustible. cada surtidor puede modelarse con el siguiente diagrama:

![[UML_2_TP3.png]]

a) Implemente la clase Surtidor en Java.

```java
public class Surtidor {
  private int cargaMax;
  private int ultraDiesel;
  private int euroDiesel;
  private int naftaSuper;
  private int naftaInfinia;

  public Surtidor() {
    this.cargaMax = 20000;
    this.ultraDiesel = this.cargaMax;
    this.euroDiesel = this.cargaMax;
    this.naftaSuper = this.cargaMax;
    this.naftaInfinia = this.cargaMax;
  }

  public void llenarDepositoUDiesel() {
    System.out.println("Llenando el deposito de Ultra Diesel");
    this.ultraDiesel = this.cargaMax;
  }

  public void llenarDepositoEDiesel() {
    System.out.println("Llenando el deposito de Euro Diesel");
    this.euroDiesel = this.cargaMax;
  }

  public void llenarDepositoNSuper() {
    System.out.println("Llenando el deposito de Nafta Super");
    this.naftaSuper = this.cargaMax;
  }

  public void llenarDepositoInfinia() {
    System.out.println("Llenando el deposito de Nafta Infinia");
    this.naftaInfinia = this.cargaMax;
  }

  public int getCantUDiesel() {
    return this.ultraDiesel;
  }

  public int getCantEDiesel() {
    return this.euroDiesel;
  }

  public int getCantNSuper() {
    return this.naftaSuper;
  }

  public int getCantInfinia() {
    return this.naftaInfinia;
  }

  public void cargarUDiesel(int litros) {
    if (this.ultraDiesel >= litros) {
      this.ultraDiesel -= litros;
      System.out.println("Se han cargado " + litros + " de Ultra Diesel");
    } else {
      System.out.println("Faltaron llenar " + (litros - this.ultraDiesel) + " litros de combustible");
      this.ultraDiesel = 0;
    }
  }

  public void cargarEDiesel(int litros) {
    if (this.euroDiesel >= litros) {
      System.out.println("Se han cargado " + litros + " de Euro Diesel");
      this.euroDiesel -= litros;
    } else {
      System.out.println("Faltaron llenar " + (litros - this.euroDiesel) + " litros de combustible");
      this.euroDiesel = 0;
    }
  }

  public void cargarNSuper(int litros) {
    if (this.naftaSuper >= litros) {
      this.naftaSuper -= litros;
      System.out.println("Se han cargado " + litros + " de Nafta Super");
    } else {
      System.out.println("Faltaron llenar " + (litros - this.naftaSuper) + " litros de combustible");
      this.naftaSuper = 0;
    }
  }

  public void cargarInfinia(int litros) {
    if (this.naftaInfinia >= litros) {
      System.out.println("Se han cargado " + litros + " de Nafta Infinia");
      this.naftaInfinia -= litros;
    } else {
      System.out.println("Faltaron llenar " + (litros - this.naftaInfinia) + " litros de combustible");
      this.naftaInfinia = 0;
    }
  }
}
```

b) Para verificar los servicios provistos por la clase Surtidor, escriba una clase SimuladorSurtidor con un método main() de acuerdo al siguiente algoritmo:
**Algoritmo simulador**
	n = leer cantidad de iteraciones
	repetir n veces testSurtidor
**Algoritmo testSurtidor**
	mostrar la cantidad actual en el depósito de cada combustible
	opción = número al azar de entre 1 y 24
	según la opción sea:
		entre 1 y 5: leer litros a cargar y cargar UltraDiesel.
		entre 6 y 10: leer litros a cargar y cargar EuroDiesel.
		entre 10 y 15: leer litros a cargar y cargar Super.
		entre 15 y 20: leer litros a cargar y cargar Infinia.
		21: llamar Depósito de UltraDiesel.
		22: llamar Depósito de EuroDiesel.
		23: llamar Depósito de Super.
		24: llamar Depósito de Infinia.

```java
import java.util.Random;
import java.util.Scanner;

public class SimuladorSurtidor {
  public static void main(String[] args) {
    new SimuladorSurtidor().simulador();
  }

  public void simulador() {
    int n = 0;
    System.out.print("Ingrese la cantidad de veces que se repetira el algoritmo de prueba: ");
    Scanner scanner = new Scanner(System.in);
    n = Integer.parseInt(scanner.nextLine());
    for (int i = 0; i < n; i++) {
      testSurtidor(scanner);
    }
  }

  public void testSurtidor(Scanner scanner) {
    Surtidor surtidor1 = new Surtidor();
    System.out.println("=== Cantidad actual en el deposito de cada combustible ===");
    System.out.println("Ultra Diesel: " + surtidor1.getCantUDiesel());
    System.out.println("Euro Diesel: " + surtidor1.getCantEDiesel());
    System.out.println("Nafta Super: " + surtidor1.getCantNSuper());
    System.out.println("Nafta Infinia: " + surtidor1.getCantInfinia());
    Random random = new Random();
    int opcion = random.nextInt(24) + 1;
    switch (opcion) {
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
        System.out.print("Cuantos litros de Ultra Diesel desea cargar?: ");
        surtidor1.cargarUDiesel(Integer.parseInt(scanner.nextLine()));
        break;
      case 6:
      case 7:
      case 8:
      case 9:
      case 10:
        System.out.print("Cuantos litros de Euro Diesel desea cargar?: ");
        surtidor1.cargarEDiesel(Integer.parseInt(scanner.nextLine()));
        break;
      case 11:
      case 12:
      case 13:
      case 14:
      case 15:
        System.out.print("Cuantos litros de Nafta Super desea cargar?: ");
        surtidor1.cargarNSuper(Integer.parseInt(scanner.nextLine()));
        break;
      case 16:
      case 17:
      case 18:
      case 19:
      case 20:
        System.out.print("Cuantos litros de Nafta Infinia desea cargar?: ");
        surtidor1.cargarInfinia(Integer.parseInt(scanner.nextLine()));
      case 21:
        surtidor1.llenarDepositoUDiesel();
        break;
      case 22:
        surtidor1.llenarDepositoEDiesel();
        break;
      case 23:
        surtidor1.llenarDepositoNSuper();
        break;
      case 24:
        surtidor1.llenarDepositoInfinia();
        break;
      default:
        System.out.println("Opcion no reconocida");
        break;
    }
  }
}
```

c) Modificar el Algoritmo generando aleatoriamente (entre 10 y 60) los litros a cargar.

```java
import java.util.Random;
import java.util.Scanner;

public class SimuladorSurtidor {
  public static void main(String[] args) {
    new SimuladorSurtidor().simulador();
  }

  public void simulador() {
    int n = 0;
    System.out.print("Ingrese la cantidad de veces que se repetira el algoritmo de prueba: ");
    Scanner scanner = new Scanner(System.in);
    n = Integer.parseInt(scanner.nextLine());
    for (int i = 0; i < n; i++) {
      testSurtidor();
    }
  }

  public void testSurtidor() {
    Surtidor surtidor1 = new Surtidor();
    System.out.println("=== Cantidad actual en el deposito de cada combustible ===");
    System.out.println("Ultra Diesel: " + surtidor1.getCantUDiesel());
    System.out.println("Euro Diesel: " + surtidor1.getCantEDiesel());
    System.out.println("Nafta Super: " + surtidor1.getCantNSuper());
    System.out.println("Nafta Infinia: " + surtidor1.getCantInfinia());
    Random random = new Random();
    int opcion = random.nextInt(24) + 1;
    int litros = random.nextInt(51) + 10;
    switch (opcion) {
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
        System.out.print("Cuantos litros de Ultra Diesel desea cargar?: ");
        surtidor1.cargarUDiesel(litros);
        break;
      case 6:
      case 7:
      case 8:
      case 9:
      case 10:
        System.out.print("Cuantos litros de Euro Diesel desea cargar?: ");
        surtidor1.cargarEDiesel(litros);
        break;
      case 11:
      case 12:
      case 13:
      case 14:
      case 15:
        System.out.print("Cuantos litros de Nafta Super desea cargar?: ");
        surtidor1.cargarNSuper(litros);
        break;
      case 16:
      case 17:
      case 18:
      case 19:
      case 20:
        System.out.print("Cuantos litros de Nafta Infinia desea cargar?: ");
        surtidor1.cargarInfinia(litros);
      case 21:
        surtidor1.llenarDepositoUDiesel();
        break;
      case 22:
        surtidor1.llenarDepositoEDiesel();
        break;
      case 23:
        surtidor1.llenarDepositoNSuper();
        break;
      case 24:
        surtidor1.llenarDepositoInfinia();
        break;
      default:
        System.out.println("Opcion no reconocida");
        break;
    }
  }
}
```

d) Implemente una clase EstacionDeServicio, que cuente con una línea de $m$ surtidores.

```java
import java.util.ArrayList;

public class EstacionDeServicio {
  private int m;
  private ArrayList<Surtidor> surtidores;

  public EstacionDeServicio() {
    this.surtidores = new ArrayList<>();
  }

  public EstacionDeServicio(int m) {
    this();
    this.m = m;
    for (int i = 0; i < m; i++) {
      this.surtidores.add(new Surtidor());
    }
  }

  public int getM() {
    return this.m;
  }

  public void reponerDepositos(int gasolina) {
    switch (gasolina) {
      case 1:
        for (Surtidor surtidor : this.surtidores) {
          surtidor.llenarDepositoUDiesel();
        }
        break;
      case 2:
        for (Surtidor surtidor : this.surtidores) {
          surtidor.llenarDepositoEDiesel();
        }
        break;
      case 3:
        for (Surtidor surtidor : this.surtidores) {
          surtidor.llenarDepositoNSuper();
        }
        break;
      case 4:
        for (Surtidor surtidor : this.surtidores) {
          surtidor.llenarDepositoInfinia();
        }
        break;
      default:
        System.out.println("No es una opcion valida la ingresada");
        break;
    }
  }

  public void cargarNSuper(int surtidor, int litros) {
    if (surtidor >= 0 && surtidor <= this.m) {
      this.surtidores.get(surtidor).cargarNSuper(litros);
    } else {
      System.out.println("Numero de surtidor invalido!");
    }
  }

  public void cargarUDiesel(int surtidor, int litros) {
    if (surtidor >= 0 && surtidor <= this.m) {
      this.surtidores.get(surtidor).cargarUDiesel(litros);
    } else {
      System.out.println("Numero de surtidor invalido!");
    }
  }

  public void cargarEDiesel(int surtidor, int litros) {
    if (surtidor >= 0 && surtidor <= this.m) {
      this.surtidores.get(surtidor).cargarEDiesel(litros);
    } else {
      System.out.println("Numero de surtidor invalido!");
    }
  }

  public void cargarInfinia(int surtidor, int litros) {
    if (surtidor >= 0 && surtidor <= this.m) {
      this.surtidores.get(surtidor).cargarInfinia(litros);
    } else {
      System.out.println("Numero de surtidor invalido!");
    }
  }

  public void mostrarCapActSurtidores() {
    for (Surtidor surtidor : this.surtidores) {
      System.out.println("=== Cantidad de combustible del surtidor ===");
      System.out.println("Ultra Diesel: " + surtidor.getCantUDiesel());
      System.out.println("Euro Diesel: " + surtidor.getCantEDiesel());
      System.out.println("Nafta Super: " + surtidor.getCantNSuper());
      System.out.println("Nafta Infinia: " + surtidor.getCantInfinia());
    }
  }
}
```

***

**Ejercicio 3**: Implementar las clases necesarias para simular de **manera sencilla** las conexiones entre redes de computadoras. El sistema está formado por redes, routers y hosts. Para conectar los distintos elementos se debe tener en cuenta:

a) Todos los elementos (redes, hosts, routers) tienen una dirección formada por dos números enteros. Las redes y los routers tienen una dirección del tipo X.0, mientras los hosts tienen una dirección X.Y

b) Cada host se conecta solo a una red determinada. Las direcciones de **todos los hosts de una misma red** tienen el primer campo en común, que coincide con el primer campo de la dirección de red a la que están conectados (por ejemplo, los hosts con direcciones 192.1, 192.2, 192.3, ..., deben pertenecer a la red 192.0).

c) Las redes deben mantener una lista de los hosts conectados a ella. Para esto se recomienda que la clase Red tenga un atributo privado que puede ser del tipo ```ArrayList```. Además las redes pueden estar conectadas a un router.

d) Cada router tiene $n$ puertos, a los que se pueden conectar tanto redes como otros routers. Cuando se crea un router se debe indicar el número de puertos que tiene.

![[Ejercicio3.png]]

La implementación a realizar debe respetar el uso que de ella se hace en el siguiente programa principal:

```java
public class Redes {
  public static void main(String[] args) {
    Red red1, red2, red3;
    Router r1, r2;
    Host h11, h12, h21, h22, h31, h32;
    // Creamos las redes
    red1 = new Red(new Direccion(192, 0));
    red2 = new Red(new Direccion(128, 0));
    red3 = new Red(new Direccion(10, 0));
    // Creamos los hosts
    h11 = new Host(new Direccion(192, 1));
    h12 = new Host(new Direccion(192, 2));
    h21 = new Host(new Direccion(128, 1));
    h22 = new Host(new Direccion(128, 2));
    h31 = new Host(new Direccion(10, 1));
    h32 = new Host(new Direccion(10, 2));
    // Conectamos los hosts a las redes
    red1.conectar(h11); h11.conectar(red1);
    red1.conectar(h12); h12.conectar(red1);
    red2.conectar(h21); h21.conectar(red2);
    red2.conectar(h22); h22.conectar(red2);
    red3.conectar(h31); h31.conectar(red3);
    // Creamos los routers
    r1 = new Router(new Direccion(172, 0), 3);
    r2 = new Router(new Direccion(225, 0), 3);
    // Conectamos los Routers y las redes
    r1.conectar(red1); red1.conectar(r1);
    r1.conectar(red2); red2.conectar(r1);
    r1.conectar(r2); r2.conectar(r1);
    r2.conectar(red3); red3.conectar(r2);
  }
}
```

Clase Host:

```java
public class Host {
  private Direccion direccion;
  private Red redAsociada;

  public Direccion getDireccion() {
    return this.direccion;
  }

  public Red getRedAsociada() {
    return this.redAsociada;
  }

  public Host() {
  }

  public Host(Direccion direccion) {
    this.direccion = direccion;
  }

  public void conectar(Red red) {
    if (this.direccion.getX() == red.getDireccion().getX()) {
      this.redAsociada = red;
      System.out.println("Host conectado a la red!");
    } else {
      System.out.println("No se puede realizar la conexion con esta red!");
    }
  }
}
```

Clase Red: 

```java
public class Host {
  private Direccion direccion;
  private Red redAsociada;

  public Direccion getDireccion() {
    return this.direccion;
  }

  public Red getRedAsociada() {
    return this.redAsociada;
  }

  public Host() {
  }

  public Host(Direccion direccion) {
    this.direccion = direccion;
  }

  public void conectar(Red red) {
    if (this.direccion.getX() == red.getDireccion().getX()) {
      this.redAsociada = red;
      System.out.println("Host conectado a la red!");
    } else {
      System.out.println("No se puede realizar la conexion con esta red!");
    }
  }
}
```

Clase Router:

```java
import java.util.ArrayList;

public class Router {
  private Direccion direccion;
  private int cantPuertos;
  private ArrayList<Router> routers;
  private ArrayList<Red> redes;

  public Router(Direccion direccion, int cantPuertos) {
    this(cantPuertos);
    this.direccion = direccion;
  }

  public Router(int cantPuertos) {
    this.cantPuertos = cantPuertos;
    this.routers = new ArrayList<>();
    this.redes = new ArrayList<>();
  }

  public Direccion getDireccion() {
    return this.direccion;
  }

  public void setDireccion(Direccion direccion) {
    this.direccion = direccion;
  }

  public int getCantPuertos() {
    return this.cantPuertos;
  }

  public void conectar(Router router) {
    if (this.routers.size() + this.redes.size() < this.cantPuertos) {
      this.routers.add(router);
      System.out.println("Se ha conectado el router con exito!");
    } else {
      System.out.println("No hay puertos disponibles!");
    }
  }

  public void conectar(Red red) {
    if (this.routers.size() + this.redes.size() < this.cantPuertos) {
      this.redes.add(red);
      System.out.println("Se ha conecto la red con exito!");
    } else {
      System.out.println("No hay puertos disponibles!");
    }
  }
}
```

***

**Ejercicio 4**: Un comercio utiliza para la atención a sus clientes 3 cajas registradoras (1, 2, 3). Por cada movimiento, se ingresa el número de caja e importe de la venta. El proceso finaliza cuando el número de caja se ingresa es cero. Determinar:

- Total de recaudación.
- Cuál fue la caja con menor importe.
- Visualizar el total por cada caja.

*Nota*: Cada caja debe tener una lista de movimientos realizados (ventas).

Clase Movimiento:

```java
public class Movimiento {
  private int idCaja;
  private double importe;

  public int getIdCaja() {
    return this.idCaja;
  }

  public void setIdCaja(int idCaja) {
    this.idCaja = idCaja;
  }

  public double getImporte() {
    return this.importe;
  }

  public void setImporte(double importe) {
    this.importe = importe;
  }

  public Movimiento() {
  }

  public Movimiento(int idCaja, double importe) {
    this.idCaja = idCaja;
    this.importe = importe;
  }

}
```

Clase CajaRegistradora:

```java
import java.util.ArrayList;

public class CajaRegistradora {
  private int numeroId;
  private double recaudacion;
  private ArrayList<Movimiento> movimientos;

  public int getNumeroId() {
    return this.numeroId;
  }

  public double getRecaudacion() {
    return this.recaudacion;
  }

  public ArrayList<Movimiento> getMovimientos() {
    return this.movimientos;
  }

  public CajaRegistradora(int numeroId) {
    this();
    this.numeroId = numeroId;
  }

  public CajaRegistradora() {
    this.movimientos = new ArrayList<>();
  }

  public void agregarMovimiento(Movimiento mov) {
    this.movimientos.add(mov);
    this.recaudacion += mov.getImporte();
  }

}
```

Clase Comercio:

```java
import java.util.Scanner;

public class Comercio {
  private CajaRegistradora[] cajas;

  public Comercio() {
    this.cajas = new CajaRegistradora[3];
    for (int i = 0; i < this.cajas.length; i++) {
      cajas[i] = new CajaRegistradora();
    }
  }

  public static void main(String[] args) {
    new Comercio().go();
  }

  public void go() {
    int idCaja = 0;
    Scanner scanner = new Scanner(System.in);
    Movimiento mov = new Movimiento();
    System.out.print("Ingrese el numero de la caja: ");
    idCaja = Integer.parseInt(scanner.nextLine());
    // Supongo que el usuario sera perfecto
    while (idCaja != 0) {
      mov.setIdCaja(idCaja);
      System.out.print("Ingrese el monto del movimiento: ");
      mov.setImporte(Double.parseDouble(scanner.nextLine()));
      this.cajas[mov.getIdCaja() - 1].agregarMovimiento(mov);
      mov = new Movimiento();
      System.out.print("Ingrese el numero de la caja: ");
      idCaja = Integer.parseInt(scanner.nextLine());
    }
    System.out.println("Ya ha finalizado el día!");
    System.out.println();
  }

  public void totalRecaudacion() {
    double total = 0;
    for (int i = 0; i < this.cajas.length; i++) {
      total += this.cajas[i].getRecaudacion();
    }
    System.out.println("Se recaudo: $" + total);
  }

  public void cajaConMenorImporte() {
    double menorRecaudacion = this.cajas[0].getRecaudacion();
    int cajaConMenorRecaudacion = 1;
    for (int i = 1; i < this.cajas.length; i++) {
      if (this.cajas[i].getRecaudacion() < menorRecaudacion) {
        cajaConMenorRecaudacion = i + 1;
        menorRecaudacion = this.cajas[i].getRecaudacion();
      }
    }
    System.out.println("La caja " + cajaConMenorRecaudacion + " fue la que tuvo menos recaudacion.");
  }

  public void mostrarTotalDeCadaCaja() {
    for (int i = 0; i < this.cajas.length; i++) {
      System.out.println("Total de la caja " + i + ": $" + this.cajas[i].getRecaudacion());
    }
  }
}
```

***

**Ejercicio 5**: Paramount Pictures mantiene los libros originales de todas sus películas, existe un único ejemplar de cada libro (o está en formato físico o está en formato digital, pero solo existe uno). El siguiente diagrama de clases modela una sucursal donde se mantiene la información relacionada con los libros y los autores. El código de cada libro lo identifica unívocamente, y no hay dos artistas con el mismo nombre. Una sucursal puede prestar libros a otra sucursal. Dadas las siguientes clases (en el diagrama de clases solo se muestran los atributos y las relaciones de herencia)

![[UML_5_1.png]]

y dada la clase Préstamo (que representa un libro prestado).
a) Implemente la clase TablaPrestamos que representa una colección de libros que están prestados.

![[UML_5_2.png]]

```java
import java.util.ArrayList;

public class TablaPrestamo {
  private ArrayList<Prestamo> prestamos;
  private int cantidad;

  public Prestamo getPrestamos(int pos) {
    return this.prestamos.get(pos);
  }

  public int getCantidad() {
    return this.cantidad;
  }

  public void nuevoPrestamo(Prestamo p) {
    this.prestamos.add(p);
    ++this.cantidad;
  }

  public boolean estaPrestado(Libro libro) {
    boolean loEsta = false;
    for (Prestamo prestamo : this.prestamos) {
      if (prestamo.getLibro().equals(libro)) {
        loEsta = true;
      }
    }
    return loEsta;
  }

  public boolean hayPrestamos() {
    return !(this.prestamos.isEmpty());
  }

  public TablaPrestamo() {
    this.prestamos = new ArrayList<>();
  }
}
```

b) Implemente las clases TablaLibros y TablaAutores.

![[UML_5_3.png]]

Clase TablaLibros:

```java
import java.util.ArrayList;

public class TablaLibros {
  private ArrayList<Libro> libros;
  private int cantidad;

  public TablaLibros() {
    this.libros = new ArrayList<>();
  }

  public ArrayList<Libro> getLibros() {
    return this.libros;
  }

  public void insertarLibro(Libro libro) {
    this.libros.add(libro);
    ++this.cantidad;
  }

  public void eliminarLibro(Libro libro) {
    if (!(this.libros.isEmpty())) {
      if (this.libros.contains(libro)) {
        this.libros.remove(libro);
        --this.cantidad;
      } else {
        System.out.println("No se encuentra ese libro en la lista.");
      }
    } else {
      System.out.println("La lista de libros esta vacia!");
    }
  }

  public int cantidadLibros() {
    return this.cantidad;
  }

  public boolean existeLibro(Libro libro) {
    return this.libros.contains(libro);
  }

  public boolean estaLlena() {
    return this.libros.size() == this.cantidad;
  }

  public boolean hayLibros() {
    return !(this.libros.isEmpty());
  }

  public Libro recuperarLibro(String codigo) {
    Libro recuperar = null;
    if (!(this.libros.isEmpty())) {
      for (Libro libro : this.libros) {
        if (libro.getCodigo().equals(codigo)) {
          recuperar = libro;
        }
      }
    }
    return recuperar;
  }

  public TablaLibros librosAutor(String nombre) {
    TablaLibros segunAutor = new TablaLibros();
    for (Libro libro : this.libros) {
      if (libro.getAutor().getNombre().equals(nombre)) {
        segunAutor.insertarLibro(libro);
      }
    }
    return segunAutor;
  }
}
```

Clase TablaAutores:

```java
import java.util.ArrayList;

public class TablaAutores {
  private ArrayList<Autor> autores;
  private int cantidad;

  public ArrayList<Autor> getAutores() {
    return this.autores;
  }

  public TablaAutores() {
    this.autores = new ArrayList<>();
  }

  public void insertarAutor(Autor autor) {
    this.autores.add(autor);
    ++this.cantidad;
  }

  public int cantidadAutores() {
    return this.cantidad;
  }

  public boolean estaAutor(Autor autor) {
    return this.autores.contains(autor);
  }

  public boolean hayAutores() {
    return !(this.autores.isEmpty());
  }

  public Autor recuperarAutor(int pos) {
    Autor autor = null;
    if (pos >= 0 && pos < this.autores.size()) {
      autor = this.autores.get(pos);
    }
    return autor;
  }

  public Autor recuperarAutor(String nombre) {
    Autor recuperar = null;
    if (this.autores.size() > 0) {
      for (Autor autor : this.autores) {
        if (autor.getNombre().equals(nombre)) {
          recuperar = autor;
        }
      }
    }
    return recuperar;
  }

  public TablaAutores autoresNac(String nac) {
    TablaAutores autoresNac = new TablaAutores();
    for (Autor autor : this.autores) {
      if (autor.getNacionalidad().equals(nac)) {
        autoresNac.insertarAutor(autor);
      }
    }
    return autoresNac;
  }
}
```

c) Implemente la clase Sucursal.

![[UML_5_4.png]]

El monto asegurado libros digitales se calcula como u$100 por cada año de antigüedad y para libros físicos como u$200 por cada año de antigüedad más u$50 por cada 100 gramos de peso. ¿En qué clase debe declararse el método montoAsegurado():double? ¿En qué clases debe implementarse?

**Resolución**: 
La clase montoAsegurado():double debe ser declarado en la clase Libro e implementado en las clases Fisico y Digital.

Clase Libro:

```java
  public double montoAsegurado() {
    return 0;
  }
```

Clase Fisico:

```java
  @Override
  public double montoAsegurado() {
    return (super.getFchIngreso().calcularAnio(new Fecha()) * 200) + (50 * this.peso);
  }
```

Clase Digital:

```java
  @Override
  public double montoAsegurado() {
    return super.getFchIngreso().calcularAnio(new Fecha()) * 100;
  }

```

Clase Sucursal:

```java
import java.util.ArrayList;

public class Sucursal {
  private String nombre;
  private TablaLibros librosEnSuc;
  private TablaPrestamo librosPrestados;
  private TablaAutores totalidadAutores;

  public void prestarLibro(Libro l, Sucursal s) {
    if (this.librosEnSuc.existeLibro(l)) {
      if (!(this.librosPrestados.estaPrestado(l))) {
        Fecha fecha = new Fecha();
        fecha.sumarUnMes();
        this.librosPrestados.nuevoPrestamo(new Prestamo(l, s, fecha));
      } else {
        System.out.println("Ese libro ya se encuentra prestado!");
      }
    } else {
      System.out.println("No se encuentra ese libro en la sucursal.");
    }
  }

  public TablaLibros librosNacionalidad(String nac) {
    TablaLibros librosNac = null;
    TablaLibros librosAutor = null;
    TablaAutores autoresNac = this.totalidadAutores.autoresNac(nac);
    ArrayList<Libro> libros = null;
    if (autoresNac.cantidadAutores() > 0) {
      librosNac = new TablaLibros();
      for (int i = 0; i < autoresNac.cantidadAutores(); i++) {
        librosAutor = this.librosEnSuc.librosAutor(autoresNac.recuperarAutor(i).getNombre());
        libros = librosAutor.getLibros();
        for (Libro libro : libros) {
          librosNac.insertarLibro(libro);
        }
      }
    }
    return librosNac;
  }

  public double montoAseguradoPorAutor(String nombre) {
    TablaLibros librosAutor = this.librosEnSuc.librosAutor(nombre);
    double montoAsegurado = 0;
    if (librosAutor != null) {
      ArrayList<Libro> libros = new ArrayList<>();
      for (Libro libro : libros) {
        montoAsegurado += libro.montoAsegurado();
      }
    }
    return montoAsegurado;
  }

  public TablaLibros mayorMontoAsegurado(int n) {
    TablaLibros mayorMontoAsegurado = null;
    if (n > 0) {
      ArrayList<Libro> libros = this.librosEnSuc.getLibros();
      double mayor = libros.get(0).montoAsegurado();
      mayorMontoAsegurado = new TablaLibros();
      for (Libro libro : libros) {
        if (libro.montoAsegurado() > mayor) {
          mayor = libro.montoAsegurado();
        }
      }
      for (Libro libro : libros) {
        if (libro.montoAsegurado() == mayor && mayorMontoAsegurado.cantidadLibros() < n) {
          mayorMontoAsegurado.insertarLibro(libro);
        }
      }
    }
    return mayorMontoAsegurado;
  }

  public TablaAutores autoresPopulares(int n) {
    TablaAutores autoresPopulares = null;
    if (this.librosEnSuc.cantidadLibros() > 0) {
      autoresPopulares = new TablaAutores();
      ArrayList<Libro> libros = new ArrayList<>();
      for (int i = 0; i < this.totalidadAutores.cantidadAutores(); i++) {
        libros = this.librosEnSuc.librosAutor(this.totalidadAutores.recuperarAutor(i).getNombre()).getLibros();
        if (libros.size() > n) {
          for (Libro libro : libros) {
            if (this.librosPrestados.estaPrestado(libro) && !(autoresPopulares.estaAutor(libro.getAutor()))) {
              autoresPopulares.insertarAutor(libro.getAutor());
            }
          }
        }
      }
    }
    return autoresPopulares;
  }

  public Autor autorLibroMayorPeso() {
    Autor autorLibroMayorPeso = null;
    if (this.librosEnSuc.cantidadLibros() > 0) {
      ArrayList<Libro> libros = this.librosEnSuc.getLibros();
      Fisico libroFisico = null;
      int mayorPeso = 0;
      for (Libro libro : libros) {
        if (libro instanceof Fisico) {
          libroFisico = (Fisico) libro;
          if (libroFisico.getPeso() > mayorPeso) {
            mayorPeso = libroFisico.getPeso();
          }
        }
      }
      for (Libro libro : libros) {
        if (libro instanceof Fisico) {
          libroFisico = (Fisico) libro;
          if (libroFisico.getPeso() == mayorPeso) {
            autorLibroMayorPeso = libroFisico.getAutor();
          }
        }
      }
    }
    return autorLibroMayorPeso;
  }
}
```

***

**Ejercicio 6**: Un sanatorio mantiene la información referida a las cirugías de acuerdo al siguiente diagrama de clases:

![[UML_6.png]]

a) Implemente todas las clases y métodos necesario.

Clase Fecha: 

```java
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Fecha {
  private LocalDate fecha;

  public Fecha() {
    this.fecha = LocalDate.now();
  }

  public Fecha(LocalDate fecha) {
    this.fecha = fecha;
  }

  public Fecha(int year, int month, int day) {
    this.fecha = LocalDate.of(year, month, day);
  }

  public LocalDate getFecha() {
    return fecha;
  }

  public void setFecha(LocalDate fecha) {
    this.fecha = fecha;
  }

  public int calcularAnios(Fecha actual) {
    return actual.getFecha().minusYears(this.fecha.getYear()).getYear();
  }

  public int compararFechas(Fecha comparar) {
    if (this.fecha.isBefore(comparar.getFecha())) {
      return -1;
    } else if (this.fecha.isAfter(comparar.getFecha())) {
      return 1;
    }
    return 0;
  }

  @Override
  public String toString() {
    return "Fecha: " + this.fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
  }

}
```

Clase ObraSocial:

```java
public class ObraSocial {
  private int cuit;
  private String denominacion;
  private String domicilio;

  public int getCuit() {
    return this.cuit;
  }

  public void setCuit(int cuit) {
    this.cuit = cuit;
  }

  public String getDenominacion() {
    return this.denominacion;
  }

  public void setDenominacion(String denominacion) {
    this.denominacion = denominacion;
  }

  public String getDomicilio() {
    return this.domicilio;
  }

  public void setDomicilio(String domicilio) {
    this.domicilio = domicilio;
  }

  public ObraSocial(int cuit, String denominacion, String domicilio) {
    this.cuit = cuit;
    this.denominacion = denominacion;
    this.domicilio = domicilio;
  }

  public ObraSocial() {
  }

  @Override
  public String toString() {
    return "ObraSocial [Cuit: " + this.cuit + ", Denominacion: " + this.denominacion + ", Domicilio: " + this.domicilio
        + "]";
  }

}
```

Clase Persona:

```java
public class Persona {
  protected int dni;
  protected String nombre;
  protected char sexo;
  protected Fecha fchNac;

  public int getDni() {
    return this.dni;
  }

  public void setDni(int dni) {
    this.dni = dni;
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public char getSexo() {
    return this.sexo;
  }

  public void setSexo(char sexo) {
    this.sexo = sexo;
  }

  public Fecha getFchNac() {
    return this.fchNac;
  }

  public void setFchNac(Fecha fchNac) {
    this.fchNac = fchNac;
  }

  public Persona() {
  }

  public Persona(int dni, String nombre, char sexo, Fecha fchNac) {
    this.dni = dni;
    this.nombre = nombre;
    this.sexo = sexo;
    this.fchNac = fchNac;
  }

  @Override
  public String toString() {
    return "Persona\nDni: " + this.dni + "\nNombre: " + this.nombre + "\nSexo: " + this.sexo + "\nFecha de Nacimiento: "
        + this.fchNac.toString();
  }

}
```

Clase Paciente:

```java
public class Paciente extends Persona {
  private ObraSocial obraSocial;

  public boolean esIgual(Paciente otro) {
    return this.dni == otro.dni;
  }

  public int edad() {
    return fchNac.calcularAnios(new Fecha());
  }

  public Paciente(int dni, String nombre, char sexo, Fecha fchNac, ObraSocial obraSocial) {
    super(dni, nombre, sexo, fchNac);
    this.obraSocial = obraSocial;
  }

  public Paciente() {
  }

  public ObraSocial getObraSocial() {
    return this.obraSocial;
  }

  public void setObraSocial(ObraSocial obraSocial) {
    this.obraSocial = obraSocial;
  }

  @Override
  public String toString() {
    String sexo = (this.sexo == 'M') ? "Masculino" : "Femenino";
    return "Paciente\nDni: " + this.dni + "\nNombre: " + this.nombre + "\nSexo: " + sexo
        + "\nFecha de Nacimiento: " + this.fchNac.toString() + "\nObra Social: " + this.obraSocial.toString() + "\n";
  }

  public boolean equals(Paciente otro) {
    return this.dni == otro.getDni();
  }

}
```

Clase Profesional:

```java
public class Profesional extends Persona {
  private int matricula;

  public int getMatricula() {
    return this.matricula;
  }

  public void setMatricula(int matricula) {
    this.matricula = matricula;
  }

  public Profesional() {
  }

  public Profesional(int dni, String nombre, char sexo, Fecha fchNac, int matricula) {
    super(dni, nombre, sexo, fchNac);
    this.matricula = matricula;
  }

  @Override
  public String toString() {
    String sexo = (this.sexo == 'M') ? "Masculino" : "Femenino";
    return "Profesional\nDni: " + this.dni + "\nNombre: " + this.nombre + "\nSexo: " + sexo
        + "\nFecha de Nacimiento: " + this.fchNac.toString() + "\nMatricula: " + this.matricula + "\n";
  }

}
```

Clase Prestacion:

```java
public class Prestacion {
  protected int idPrestacion;
  protected String nombre;
  protected Paciente paciente;
  protected Profesional prestador;
  protected Fecha fchRealizacion;

  public int getIdPrestacion() {
    return this.idPrestacion;
  }

  public void setIdPrestacion(int idPrestacion) {
    this.idPrestacion = idPrestacion;
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Paciente getPaciente() {
    return this.paciente;
  }

  public void setPaciente(Paciente paciente) {
    this.paciente = paciente;
  }

  public Profesional getPrestador() {
    return this.prestador;
  }

  public void setPrestador(Profesional prestador) {
    this.prestador = prestador;
  }

  public Fecha getFchRealizacion() {
    return this.fchRealizacion;
  }

  public void setFchRealizacion(Fecha fchRealizacion) {
    this.fchRealizacion = fchRealizacion;
  }

  public Prestacion(int idPrestacion, String nombre, Paciente paciente, Profesional prestador, Fecha fchRealizacion) {
    this.idPrestacion = idPrestacion;
    this.nombre = nombre;
    this.paciente = paciente;
    this.prestador = prestador;
    this.fchRealizacion = fchRealizacion;
  }

  public Prestacion() {
  }
}
```

Clase Cirugia:

```java
public class Cirugia extends Prestacion {
  private int minutosDuracion;

  public int getMinutosDuracion() {
    return this.minutosDuracion;
  }

  public void setMinutosDuracion(int minutosDuracion) {
    this.minutosDuracion = minutosDuracion;
  }

  public Cirugia(int idPrestacion, String nombre, Paciente paciente, Profesional prestador, Fecha fchRealizacion,
      int minutosDuracion) {
    super(idPrestacion, nombre, paciente, prestador, fchRealizacion);
    this.minutosDuracion = minutosDuracion;
  }

  public Cirugia() {
  }

  @Override
  public String toString() {
    return "Cirugia\n{\nID de la Prestacion: " + this.idPrestacion + "\nNombre: " + this.nombre + "\nPaciente: "
        + this.paciente + "\nPrestador: " + this.prestador + "\nFecha de Realizacion: " + this.fchRealizacion
        + "\nMinutos de Duracion: " + this.minutosDuracion + "\n}\n";
  }
}
```

Clase Cirugias:

```java
import java.util.ArrayList;

public class Cirugias {
  private ArrayList<Cirugia> cirugias;
  private int cantidad;

  public void insertarCirugia(Cirugia cirugia) {
    if (!(this.cirugias.isEmpty())) {
      int i = this.cantidad;
      while (i > 0
          && this.cirugias.get(i - 1).getFchRealizacion().compararFechas(cirugia.getFchRealizacion()) > 0) {
        --i;
      }
      if (i == this.cantidad) {
        this.cirugias.add(cirugia);
      } else {
        this.cirugias.add(i, cirugia);
      }
    } else {
      this.cirugias.add(cirugia);
    }
    ++this.cantidad;
  }

  public void eliminarCirugia(String oSocial) {
    if (!(this.cirugias.isEmpty())) {
      int i = this.cantidad - 1;
      while (i >= 0) {
        if (this.cirugias.get(i).getPaciente().getObraSocial().getDenominacion().equals(oSocial)) {
          this.cirugias.remove(i);
          --this.cantidad;
        }
        --i;
      }
    } else {
      System.out.println("La lista esta vacia!");
    }
  }

  public double promedioDuracion() {
    double suma = 0;
    if (this.cantidad > 0) {
      for (Cirugia cirugia : this.cirugias) {
        suma += cirugia.getMinutosDuracion();
      }
      return suma / this.cantidad;
    }
    return 0;
  }

  public double promedioDuracion(Fecha desde, Fecha hasta) {
    double promedio = 0;
    if (this.cantidad > 0 && this.cirugias.getLast().getFchRealizacion().compararFechas(desde) > 0) {
      double suma = 0;
      int contador = 0;
      for (Cirugia cirugia : this.cirugias) {
        if (cirugia.getFchRealizacion().compararFechas(desde) >= 0
            && cirugia.getFchRealizacion().compararFechas(hasta) <= 0) {
          suma += cirugia.getMinutosDuracion();
          ++contador;
        }
      }
      promedio = suma / contador;
    }
    return promedio;
  }

  public double promedioDuracion(int edad) {
    double promedio = 0;
    if (this.cantidad > 0) {
      double suma = 0;
      int contador = 0;
      for (Cirugia cirugia : this.cirugias) {
        if (cirugia.getPaciente().edad() == edad) {
          suma += cirugia.getMinutosDuracion();
          ++contador;
        }
      }
      promedio = suma / contador;
    }
    return promedio;
  }

  public Cirugias cirugiasPrestador(String nombre) {
    Cirugias cirugiasPrestador = null;
    if (this.cantidad > 0) {
      cirugiasPrestador = new Cirugias();
      for (Cirugia cirugia : this.cirugias) {
        if (cirugia.getPrestador().getNombre().equals(nombre)) {
          cirugiasPrestador.insertarCirugia(cirugia);
        }
      }
    }
    return cirugiasPrestador;
  }

  public Cirugias cirugiasOS(String os) {
    Cirugias cirugiasOS = null;
    if (this.cantidad > 0) {
      cirugiasOS = new Cirugias();
      for (Cirugia cirugia : this.cirugias) {
        if (cirugia.getPaciente().getObraSocial().getDenominacion().equals(os)) {
          cirugiasOS.insertarCirugia(cirugia);
        }
      }
    }
    return cirugiasOS;
  }

  public Cirugias cirugiasPcte(Paciente p) {
    Cirugias cirugiasPcte = null;
    if (this.cantidad > 0) {
      cirugiasPcte = new Cirugias();
      for (Cirugia cirugia : this.cirugias) {
        if (cirugia.getPaciente().equals(p)) {
          cirugiasPcte.insertarCirugia(cirugia);
        }
      }
    }
    return cirugiasPcte;
  }

  public Cirugias() {
    this.cirugias = new ArrayList<>();
  }

  @Override
  public String toString() {
    String cadena = "";
    for (Cirugia cirugia : this.cirugias) {
      cadena += cirugia.toString();
    }
    return cadena;
  }
}
```

b) Realice un test de la clase ```Cirugias```.

Clase TestCirugias:

```java
public class TestCirugias {
  public static void main(String[] args) {
    Fecha fecha1 = new Fecha(2024, 5, 15);
    Fecha fecha2 = new Fecha(2024, 6, 27);
    Fecha fecha3 = new Fecha(2024, 10, 20);
    Fecha fecha4 = new Fecha(2024, 7, 1);
    Fecha fecha5 = new Fecha(2024, 11, 7);
    ObraSocial obraSocial1 = new ObraSocial(847277384, "OSDE", "Buenos Aires, Capital");
    ObraSocial obraSocial2 = new ObraSocial(848704832, "PIEVE", "Salta, Salta Capital");
    Paciente paciente1 = new Paciente(31488934, "Juana Martinez", 'F', new Fecha(1974, 4, 22), obraSocial1);
    Paciente paciente2 = new Paciente(37483983, "Esteban Pacheco", 'M', new Fecha(1977, 1, 30), obraSocial1);
    Paciente paciente3 = new Paciente(41483745, "Marian Costanera", 'F', new Fecha(1999, 7, 22), obraSocial2);
    Paciente paciente4 = new Paciente(39574833, "Fabio Renato", 'M', new Fecha(1991, 8, 13), obraSocial2);
    Profesional profesional1 = new Profesional(32485399, "Maria de los Angeles Fernandez", 'F', new Fecha(1975, 11, 7),
        3828);
    Profesional profesional2 = new Profesional(38733817, "Juan Pablo Estebanez", 'M', new Fecha(1989, 3, 25), 883293);
    Cirugia cirugia1 = new Cirugia(1, "Cambio de Bypass", paciente1, profesional1, fecha1, 180);
    Cirugia cirugia2 = new Cirugia(20, "Extraccion de Apendice", paciente2, profesional2, fecha3, 200);
    Cirugia cirugia3 = new Cirugia(15, "Trasplante de riñon", paciente4, profesional2, fecha2, 300);
    Cirugia cirugia4 = new Cirugia(23, "Amputacion de piernas", paciente3, profesional1, fecha4, 500);
    Cirugia cirugia5 = new Cirugia(84, "Trasplante de piel", paciente3, profesional2, fecha5, 390);
    Cirugia cirugia6 = new Cirugia(88, "Implante de cadera", paciente1, profesional1, fecha3, 700);
    Cirugias cirugias = new Cirugias();
    cirugias.insertarCirugia(cirugia1);
    cirugias.insertarCirugia(cirugia2);
    cirugias.insertarCirugia(cirugia3);
    cirugias.insertarCirugia(cirugia4);
    cirugias.insertarCirugia(cirugia5);
    cirugias.insertarCirugia(cirugia6);
    System.out.println(cirugias);
    System.out.println("Promedio duracion de todas las cirugias en la lista: " +
        cirugias.promedioDuracion());
    System.out.println("Se mostraran las cirugias del paciente: " +
        paciente3.getNombre());
    System.out.println(cirugias.cirugiasPcte(paciente3));
    System.out.println("Cirugias de la obra social: " +
        obraSocial2.getDenominacion());
    System.out.println(cirugias.cirugiasOS(obraSocial2.getDenominacion()));
    System.out.println("Cirugias que realiza el/la prestador: " +
        profesional1.getNombre());
    System.out.println(cirugias.cirugiasPrestador(profesional1.getNombre()));
    System.out.println("Promedio de la duracion de cirugias de entre " +
        fecha1.toString() + " hasta "
        + fecha3.toString() + ": " + cirugias.promedioDuracion(fecha1, fecha3));
    System.out.println("Promedio de duracion de operaciones de personas de 26 años: " + cirugias.promedioDuracion(26));
  }
}
```
