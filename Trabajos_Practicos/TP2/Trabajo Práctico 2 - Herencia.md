**Ejercicio 1:** Escriba las siguientes clases en Java:

```java
public class TCredito {
  private String numero;
  private String nombre;
  private String banco;
  private double balance;
  private double limite;

  public TCredito(String vnumero, String vnombre, String vbanco, double vbalance, double vlimite) {
    this.limite = vlimite;
    this.numero = vnumero;
    this.nombre = vnombre;
    this.banco = vbanco;
    this.balance = vbalance;
  }

  public String getNumero() {
    return this.numero;
  }

  public String getNombre() {
    return this.nombre;
  }

  public String getBanco() {
    return this.banco;
  }

  public double getBalance() {
    return this.balance;
  }

  public double getLimite() {
    return this.limite;
  }

  public boolean puedoComprar(double vprecio) {
    if (vprecio + this.balance > this.limite) {
      return false;
    } else {
      this.balance += vprecio;
      return true;
    }
  }

  public void pagarTarjeta(double vmonto) {
    this.balance -= vmonto;
  }

  public void muestraDatos() {
    System.out.println("numero = " + getNumero());
    System.out.println("nombre = " + getNombre());
  }
}

class Tarjeta {
  public static void main(String[] args) {
    TCredito JPTarjeta = new TCredito("666", "JPerez", "BcoPatagonia", 2000, 10000);
    TCredito DMTarjeta = new TCredito("777", "DMaradona", "BcoGalicia", 5000, 100000);
    JPTarjeta.muestraDatos();
  }
}
```

**Ejercicio 2:** Según se puede observar en el ejercicio anterior, existe una clase **TCredito** con 5 atributos y 8 métodos. Ademas, existe una clase **Tarjeta** la cual tiene un main.
Responder:

a) ```JPTarjeta``` y ```JMTarjeta``` son dos nuevas clases?, si no es así, qué son?

Rta: Ninguna es una nueva clase. Ambas son instancias de la clase ```TCredito```, osea, son objetos distintos en el programa.

b) ```JPTarjeta.muestraDatos()``` qué hace?

Rta: Este método muestra los datos (número y nombre) del objeto tarjeta que guarda la variable de referencia ```JPTarjeta```.

c) Mejore el método ```muestraDatos()``` para mostrar toda la información disponible.

```java
  public void muestraDatos() {
    System.out.println("numero = " + getNumero());
    System.out.println("nombre = " + getNombre());
    System.out.println("banco = " + getBanco());
    System.out.println("balance = $" + getBalance());
    System.out.println("limite = $" + getLimite());
  }
```

d) Modifique el main de ```Tarjeta``` para probar si ```JPTarjeta``` puede comprarse una Ultrabook de $16000. Si no es posible, mostrar un mensaje en pantalla.

```java
class Tarjeta {
  public static void main(String[] args) {
    TCredito JPTarjeta = new TCredito("666", "JPerez", "BcoPatagonia", 2000, 10000);
    TCredito DMTarjeta = new TCredito("777", "DMaradona", "BcoGalicia", 5000, 100000);
    JPTarjeta.muestraDatos();
    if (JPTarjeta.puedoComprar(16000)) {
      JPTarjeta.pagarTarjeta(16000);
      System.out.println("La compra se pudo realizar con exito!");
    } else {
      System.out.println("No se puede realizar esta compra");
    }
  }
}
```

e) No estaría de más tener un método que permita ```aumentarBalance```, no?

```java
  public void aumentarBalance(double monto) {
    this.balance += monto;
  }
```

f) A ```DMTarjeta``` le informaron que debe pagar su tarjeta. Pero solo pagará $1500. Realice el pago y muestre la información actualizada de ```DMTarjeta```.

```java
public class TCredito {
  private String numero;
  private String nombre;
  private String banco;
  private double balance;
  private double limite;

  public TCredito(String vnumero, String vnombre, String vbanco, double vbalance, double vlimite) {
    this.limite = vlimite;
    this.numero = vnumero;
    this.nombre = vnombre;
    this.banco = vbanco;
    this.balance = vbalance;
  }

  public String getNumero() {
    return this.numero;
  }

  public String getNombre() {
    return this.nombre;
  }

  public String getBanco() {
    return this.banco;
  }

  public double getBalance() {
    return this.balance;
  }

  public double getLimite() {
    return this.limite;
  }

  public boolean puedoComprar(double vprecio) {
    if (vprecio + this.balance > this.limite) {
      return false;
    } else {
      this.balance += vprecio;
      return true;
    }
  }

  public void pagarTarjeta(double vmonto) {
    this.balance -= vmonto;
  }

  public void muestraDatos() {
    System.out.println("numero = " + getNumero());
    System.out.println("nombre = " + getNombre());
    System.out.println("banco = " + getBanco());
    System.out.println("balance = $" + getBalance());
    System.out.println("limite = $" + getLimite());
  }

  public void aumentarBalance(double monto) {
    this.balance += monto;
  }

}

class Tarjeta {
  public static void main(String[] args) {
    TCredito JPTarjeta = new TCredito("666", "JPerez", "BcoPatagonia", 2000, 10000);
    TCredito DMTarjeta = new TCredito("777", "DMaradona", "BcoGalicia", 5000, 100000);
    JPTarjeta.muestraDatos();
    if (JPTarjeta.puedoComprar(16000)) {
      JPTarjeta.pagarTarjeta(16000);
      System.out.println("La compra se pudo realizar con exito!");
    } else {
      System.out.println("No se puede realizar esta compra");
    }
    System.out.println("DMTarjeta, debe pagar su deuda!");
    DMTarjeta.aumentarBalance(1500);
    DMTarjeta.muestraDatos();
  }
}
```

***

**Ejercicio 3:** Escriba las  siguientes clases en Java:

```java
public class Progresion {

  protected long primero;
  protected long actual;

  public Progresion() {
    this.primero = this.actual = 0;
  }

  protected long primerValor() {
    this.actual = this.primero;
    return this.actual;
  }

  protected long sgteValor() {
    return ++this.actual;
  }

  public void imprProgresion(int n) {
    System.out.println(primerValor());
    for (int i = 2; i <= n; i++) {
      System.out.println(" " + sgteValor());
    }
    System.out.println("..._n...");
  }
}

public class ProgresionArit extends Progresion {
  protected long incr;

  public ProgresionArit() {
    this.incr = 1;
  }

  public ProgresionArit(long vincr) {
    this.incr = vincr;
  }

  protected long sgteValor() {
    this.actual += this.incr;
    return this.actual;
  }
}

public class TestEj3 {
  public static void main(String[] args) {
    System.out.println("serie aritmetica con incr por defecto ");
    ProgresionArit progUno = new ProgresionArit();
    progUno.imprProgresion(10);
    System.out.println("serie aritmetica con incre de 7 ");
    ProgresionArit progDos = new ProgresionArit(7);
    progDos.imprProgresion(10);
  }
}
```

**Ejercicio 4:** En el ejercicio anterior, se observan las clases ```Progresion```, ```ProgresionArit``` y ```TestEj3```:
1. Qué relación tienen ```Progresion``` y ```ProgresionArit```?

Rta: su relación es de herencia. ```Progresion``` es la clase padre y ```ProgresionArit``` es la clase hija. Esto quiere decir que todos los atributos y métodos de ```Progresion``` también lo poseen la clase ```ProgresionArit```.

2. Qué son ```progUno``` y ```progDos```?

Rta: Ambas son instancias (objetos) de la clase ```ProgresionArit```.

3. Qué es y qué hace ```progUno.imprProgresion(10)```?

 Rta: Es una llamada al método ```imprProgresion(10)``` del objeto al que hace referencia la variable ```progUno```. Lo que hace es imprimir una progresión numérica de diez números con un incremento de uno, es decir, los números del 0 al 9.

4. Idem pero con ```progDos.imprProgresion(10)```?

 Rta: Es una llamada al método ```imprProgresion(10)``` del objeto al que hace referencia la variable ```progDos```. Lo que hace es imprimir una progresión numérica de diez números con un incremento de siete, es decir, 0, 7, 14, ..., hasta el 63.

5. ```ProgresionArit``` tiene dos métodos con igual nombre. Eso se llama...? Para qué se hizo esto?

Rta: Estos dos métodos se llaman **constructores**, y lo que se hizo se conoce como **sobrecarga de constructores**. Esto se hizo así para poder definir cómo será la progresión, si de uno en uno (que es el objeto que se construye con el constructor vacío) o si se quiere usar un valor distinto (que es un valor entero que toma como argumento el otro constructor).

***

**Ejercicio 5:** La Facultad de Ciencias Exactas se encuentra en periodo de elecciones para las nuevas autoridades. Los estudiantes que votan suman 1 voto a la fórmula elegida, mientras que los docentes y personal de apoyo suman 3 votos al partido elegido. Tener en cuenta que:

- Los alumnos en condiciones de votar son regulares que cumplen haber rendido al menos 2 materias en los últimos 12 meses.
- Los docentes en condiciones de votar son aquellos que tienen cargo regular en cualquier asignatura dentro de la Facultad.
- Todo el personal de apoyo universitario está en condiciones de votar.

Implemente en Java las clases que considere necesarias para poder resolver los siguientes items:

1. Retornar la lista de todos los alumnos autorizados a votar.
2. Dado una identificación de una persona (Alumno, Docente, Personal) devolver el estado de esa persona, esto es: Si está o no autorizado a votar. Especificando en caso de negativo el motivo exacto.
3. Porcentaje de alumnos que votan con respecto al total de alumnos.
4. Porcentaje de docentes que votan con respecto al total de docentes.

```java
public class Votante {
  private String nombre;
  private int dni;

  public int votar(int partido) {
    return partido += 3;
  }

  public boolean puedeVotar() {
    return true;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getDni() {
    return dni;
  }

  public void setDni(int dni) {
    this.dni = dni;
  }

  public Votante(String nombre, int dni) {
    this.nombre = nombre;
    this.dni = dni;
  }

  public Votante() {
  }

  @Override
  public String toString() {
    return "Votante [nombre=" + nombre + ", dni=" + dni + "]";
  }
}

public class Alumno extends Votante {
  private int materiasRendidas;

  @Override
  public boolean puedeVotar() {
    return this.materiasRendidas >= 2;
  }

  public int getMateriasRendidas() {
    return materiasRendidas;
  }

  public void setMateriasRendidas(int materiasRendidas) {
    this.materiasRendidas = materiasRendidas;
  }

  public Alumno() {
  }

  public Alumno(int materiasRendidas, String nombre, int dni) {
    super(nombre, dni);
    this.materiasRendidas = materiasRendidas;
  }

  @Override
  public int votar(int partido) {
    return partido += 1;
  }
}

public class Docente extends Votante {
  private boolean cargoRegularEnAsignatura;

  @Override
  public boolean puedeVotar() {
    return this.cargoRegularEnAsignatura;
  }

  public boolean isCargoRegularEnAsignatura() {
    return cargoRegularEnAsignatura;
  }

  public void setCargoRegularEnAsignatura(boolean cargoRegularEnAsignatura) {
    this.cargoRegularEnAsignatura = cargoRegularEnAsignatura;
  }

  public Docente() {
  }

  public Docente(boolean cargoRegularEnAsignatura, String nombre, int dni) {
    super(nombre, dni);
    this.cargoRegularEnAsignatura = cargoRegularEnAsignatura;
  }

}

public class Personal extends Votante {
  public Personal(String nombre, int dni) {
    super(nombre, dni);
  }

  public Personal() {
  }
}

import java.util.ArrayList;

public class SistemaDeVotacion {
  private ArrayList<Votante> votantes = new ArrayList<>();

  public static void main(String[] args) {
    SistemaDeVotacion sis = new SistemaDeVotacion();
    sis.cargaListaVotantes();
    ArrayList<Alumno> alumnosVotantes = new ArrayList<>();
    alumnosVotantes = sis.alumnosAutorizadosAVotar();
    for (Alumno alumno : alumnosVotantes) {
      System.out.println(alumno);
    }
    int dniBuscar = 31889604;
    String nombreBuscar = "Esteban Henriquez";
    if (sis.estaAutorizadoAVotar(nombreBuscar, dniBuscar)) {
      System.out.println("Esta autorizado a votar");
    } else {
      System.out.println("No esta autorizado a votar");
    }
    System.out.println(
        "Porcentaje de Alumnos que pueden votar (respecto al total de alumnos): " + sis.porcentajeDeAlumnosVotantes());
    System.out.println(
        "Porcentaje de Docentes que pueden votar (respecto al total de docentes): "
            + sis.porcentajeDeDocentesVotantes());
  }

  public void cargaListaVotantes() {
    Alumno a1 = new Alumno(3, "Maira Rodriguez", 44134044);
    Alumno a2 = new Alumno(1, "Martin Guzman", 45338001);
    Alumno a3 = new Alumno(2, "Anahi Ceballos", 41088121);
    Docente d1 = new Docente(true, "Sergio Cabero", 32058733);
    Docente d2 = new Docente(false, "Esteban Henriquez", 31889604);
    Docente d3 = new Docente(true, "Marcela Lopez", 33771143);
    Personal p1 = new Personal("Ricardo Bolañez", 38702194);
    Personal p2 = new Personal("Guillermo Romero", 35890022);
    this.votantes.add(a1);
    this.votantes.add(a2);
    this.votantes.add(a3);
    this.votantes.add(d1);
    this.votantes.add(d2);
    this.votantes.add(d3);
    this.votantes.add(p1);
    this.votantes.add(p2);
  }

  public ArrayList<Alumno> alumnosAutorizadosAVotar() {
    ArrayList<Alumno> alumnos = new ArrayList<>();
    for (Votante votante : this.votantes) {
      if (votante instanceof Alumno && votante.puedeVotar()) {
        System.out.println("Se agrego un alumno");
        alumnos.add((Alumno) votante);
      }
    }
    return alumnos;
  }

  public boolean estaAutorizadoAVotar(String nombre, int dni) {
    for (Votante votante : this.votantes) {
      if (votante.getNombre().equals(nombre) && votante.getDni() == dni) {
        if (votante.puedeVotar()) {
          return true;
        } else {
          if (votante instanceof Alumno) {
            System.out.println("No tiene las materias finalizadas requeridas");
          } else {
            System.out.println("No tiene un cargo regular en alguna materia");
          }
          return false;
        }
      }
    }
    System.out.println("No hay un votante con esos datos");
    return false;
  }

  public double porcentajeDeAlumnosVotantes() {
    double contAlumnosTotal = 0, contAlumnosVotantes = 0;
    for (Votante votante : this.votantes) {
      if (votante instanceof Alumno) {
        ++contAlumnosTotal;
        if (votante.puedeVotar()) {
          ++contAlumnosVotantes;
        }
      }
    }
    if (contAlumnosTotal == 0) {
      return 0;
    } else {
      return 100 * contAlumnosVotantes / contAlumnosTotal;
    }
  }

  public double porcentajeDeDocentesVotantes() {
    double contDocentesTotal = 0, contDocentesVotantes = 0;
    for (Votante votante : this.votantes) {
      if (votante instanceof Docente) {
        ++contDocentesTotal;
        if (votante.puedeVotar()) {
          ++contDocentesVotantes;
        }
      }
    }
    if (contDocentesTotal == 0) {
      return 0;
    } else {
      return 100 * contDocentesVotantes / contDocentesTotal;
    }
  }
}
```