
**Ejercicio 1**: Teniendo en cuenta la clase abstracta ```Empleado```, implemente los métodos abstractos en las subclases ```EmpleadoComercial``` y ```EmpleadoAdministrativo```, las que deberán tener un atributo ```comision```, de tal forma que se aplique el plus al salario cuando la comisión del empleado comercial sea menor a $1000, y en el caso del  empleado administrativo cuando la comisión sea menor a $2000.

```java
public abstract class Empleado {
  protected final static double SMVM = 16875; // Salario Minimo
  protected String nombre;
  protected String apellido;
  protected int edad;
  protected double salario;

  public Empleado(String nombre, String apellido, int edad, double salario) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.edad = edad;
    this.salario = salario;
  }

  public Empleado() {
    this("", "", 0, Empleado.SMVM);
  }

  public String getNombre() {
    return this.nombre + " " + this.apellido;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getEdad() {
    return this.edad;
  }

  public void setEdad(int edad) {
    this.edad = edad;
  }

  public double getSalario() {
    return this.salario;
  }

  public void setSalario(double salario) {
    this.salario = salario;
  }

  @Override
  public String toString() {
    return "nombre y apellido: " + getNombre() + "\nEdad: " + this.edad + "\nSalario: " + this.salario;
  }

  public abstract boolean plus(double sueldoPlus);

  public abstract String imprimir();
}
```

En una clase ```TestEmpleados``` instancie objetos de la clase ```EmpleadoAdministrativo``` y ```EmpleadoComercial``` y pruebe los métodos implementados.

Clase EmpleadoAdministrativo:

```java
public class EmpleadoAdministrativo extends Empleado {
  private double comision;

  public double getComision() {
    return this.comision;
  }

  public void setComision(double comision) {
    this.comision = comision;
  }

  public EmpleadoAdministrativo(String nombre, String apellido, int edad, double salario) {
    super(nombre, apellido, edad, salario);
  }

  @Override
  public boolean plus(double sueldoPlus) {
    if (this.comision < 2000) {
      this.salario += sueldoPlus;
      return true;
    }
    return false;
  }

  @Override
  public String imprimir() {
    String cadena = "Nombre: " + this.nombre + "\tApellido: " + this.apellido + "\nEdad: " + this.edad + "\nSalario: "
        + this.salario + "\nComision: " + this.comision;
    return cadena;
  }
}
```

Clase EmpleadoComercial:

```java
public class EmpleadoComercial extends Empleado {
  private double comision;

  public EmpleadoComercial(String nombre, String apellido, int edad, double salario) {
    super(nombre, apellido, edad, salario);
  }

  public double getComision() {
    return this.comision;
  }

  public void setComision(double comision) {
    this.comision = comision;
  }

  @Override
  public boolean plus(double sueldoPlus) {
    if (this.comision < 1000) {
      this.salario += sueldoPlus;
      return true;
    }
    return false;
  }

  @Override
  public String imprimir() {
    String cadena = "Nombre: " + this.nombre + "\tApellido: " + this.apellido + "\nEdad: " + this.edad + "\nSalario: "
        + this.salario + "\nComision: " + this.comision;
    return cadena;
  }
}
```

Clase TestEmpleados:

```java
public class TestEmpleados {
  public static void main(String[] args) {
    EmpleadoComercial eComercial = new EmpleadoComercial("Juan", "De la Sierra", 28, 1000);
    EmpleadoAdministrativo eAdministrativo = new EmpleadoAdministrativo("Maira", "Duran", 42, 1800);
    eComercial.setComision(588.99);
    eAdministrativo.setComision(2200);
    System.out.println(eComercial.imprimir());
    System.out.println(eAdministrativo.imprimir());
    if (eComercial.plus(500)) {
      System.out.println("El empleado de comercio ha recibido un plus!");
      System.out.println(eComercial.imprimir());
    }
    if (eAdministrativo.plus(500)) {
      System.out.println("El empleado administrativo ha recibido un plus!");
      System.out.println(eAdministrativo.imprimir());
    }
  }
}
```

***

**Ejercicio 2**: Implemente la clase ```Figura```, y las subclases ```Circulo```, ```Rectangulo``` y ```Cuadrado```, como se muestra en el siguiente diagrama de clases:

![[2-TP5.png]]

Tenga en cuenta que ```Figura``` es una clase abstracta que tiene:
- Dos variables de instancia protegidas ```color(string)``` y ```relleno(boolean)```. Las variables protegidas pueden ser accedidas por las subclases en el mismo paquete. Se denotan con # en el diagrama de clases.
- Getters y setters para todas las variables de instancia, además del método ```toString()```.
- Dos métodos abstractos ```getArea()``` y ```getPerimetro()``` (en cursiva en el diagrama de clases).
Las subclases Circulo y Rectángulo deberán sobrescribir los métodos abstractos ```getArea()``` y ```getPerimetro()``` proporcionando la implementación correspondiente. Además deberán sobrescribir ```toString()```.

Clase Figura:

```java
public abstract class Figura {
  protected String color;
  protected boolean relleno;

  public Figura() {
    this.color = "";
  }

  public Figura(String color, boolean relleno) {
    this.color = color;
    this.relleno = relleno;
  }

  public String getColor() {
    return this.color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public boolean estaRelleno() {
    return this.relleno;
  }

  public void setRelleno(boolean relleno) {
    this.relleno = relleno;
  }

  public abstract double getArea();

  public abstract double getPerimetro();

  @Override
  public String toString() {
    return "Figura [color=" + this.color + ", relleno=" + this.relleno + "]";
  }

}
```

Clase Circulo:

```java
public class Circulo extends Figura {
  protected double radio;

  public Circulo() {
  }

  public Circulo(String color, boolean relleno, double radio) {
    super(color, relleno);
    this.radio = radio;
  }

  public double getRadio() {
    return this.radio;
  }

  public void setRadio(double radio) {
    this.radio = radio;
  }

  @Override
  public double getArea() {
    double area = 0;
    if (this.radio > 0) {
      area = Math.PI * Math.pow(radio, 2);
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

  @Override
  public String toString() {
    return "Circulo [color=" + this.color + ", radio=" + this.radio + ", relleno=" + this.relleno + "]";
  }
}
```

Clase Rectangulo:

```java
public class Rectangulo extends Figura {
  protected double base;
  protected double altura;

  public Rectangulo() {
  }

  public Rectangulo(double base, double altura) {
    this.base = base;
    this.altura = altura;
  }

  public Rectangulo(String color, boolean relleno, double base, double altura) {
    super(color, relleno);
    this.base = base;
    this.altura = altura;
  }

  public double getBase() {
    return this.base;
  }

  public void setBase(double base) {
    this.base = base;
  }

  public double getAltura() {
    return this.altura;
  }

  public void setAltura(double altura) {
    this.altura = altura;
  }

  @Override
  public double getArea() {
    double area = 0;
    if (this.base > 0 && this.altura > 0) {
      area = this.base * this.altura;
    }
    return area;
  }

  @Override
  public double getPerimetro() {
    double perimetro = 0;
    if (this.base > 0 && this.altura > 0) {
      perimetro = 2 * (this.base + this.altura);
    }
    return perimetro;
  }

  @Override
  public String toString() {
    return "Rectangulo [color=" + this.color + ", base=" + this.base + ", relleno=" + this.relleno + ", altura="
        + this.altura + "]";
  }

}
```

Clase Cuadrado:

```java
public class Cuadrado extends Rectangulo {
  public Cuadrado() {
  }

  public Cuadrado(double lado) {
    super(lado, lado);
  }

  public Cuadrado(double lado, String color, boolean relleno) {
    super(color, relleno, lado, lado);
  }

  public double getLado() {
    return this.base;
  }

  public void setLado(double lado) {
    this.base = lado;
    this.altura = lado;
  }

  @Override
  public double getArea() {
    double area = 0;
    if (this.base > 0) {
      area = this.base * this.altura;
    }
    return area;
  }

  @Override
  public double getPerimetro() {
    double perimetro = 0;
    if (this.base > 0) {
      perimetro = this.base * 4;
    }
    return perimetro;
  }

  @Override
  public String toString() {
    return "Cuadrado [color=" + this.color + ", lado=" + this.base + ", relleno=" + this.relleno + "]";
  }

}
```

***

**Ejercicio 3**: Dado el siguiente diagrama de clases se pide:

![[3-TP5.png]]

Implementar todas las clases, teniendo en cuenta que ```Jugador``` es una clase abstracta, con un método abstracto ```importeNomina()```. Este método devuelve el valor (cantidad de meses desde que fue contratado hasta el día de la fecha enviada como parámetro) * 15000 cuando el Jugador es de Reserva y (cantidad de meses desde que fue contratado hasta el día de la fecha enviada como parámetro) * 25000 cuando es de Primera. Sobrescriba el método ```toString()``` en la clase ```JugadorPrimera``` de modo que muestre la información de la fecha de inicio y de fin del contrato.

La clase ```ListadoJugadores``` debe permitir agregar Jugadores (ya sean de Primera o de Reserva) al listado. El método ```imprimirListado()```, deberá imprimir la información de los jugadores, indicando si es de Primera o de Reserva y si es de Primera se deberá mostrar además la fecha de vencimiento de su contrato. El método ```importeTotalNominaJugadores()``` devuelve la suma de total de las nominas de todos los Jugadores del listado hasta el día de la fecha.

Finalmente, en una clase ```TestListadoJugadores``` pruebe la clase ```ListadoJugadores``` instanciando y agregando al listado Jugadores de distinta categoría.

Clase Persona:

```java
public class Persona {
  private String nombre;
  private String apellido;
  private int edad;

  public String getNombre() {
    return this.nombre;
  }

  public String getApellido() {
    return this.apellido;
  }

  public int getEdad() {
    return this.edad;
  }

  public Persona() {
  }

  public Persona(String nombre, String apellido, int edad) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.edad = edad;
  }

  @Override
  public String toString() {
    return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + "]";
  }
}
```

Clase Jugador:

```java
import java.util.Calendar;

public abstract class Jugador extends Persona {
  private String idJugador;
  protected Calendar fchInicio;

  public String getIdJugador() {
    return this.idJugador;
  }

  public void setIdJugador(String idJugador) {
    this.idJugador = idJugador;
  }

  public Jugador(String nombre, String apellido, int edad, String idJugador, Calendar fchInicio) {
    super(nombre, apellido, edad);
    this.idJugador = idJugador;
    this.fchInicio = fchInicio;
  }

  public abstract double importeNomina(Calendar hasta);

  @Override
  public String toString() {
    return "Jugador [idJugador=" + this.idJugador + ", fchInicio=" + this.fchInicio + ", nombre=" + getNombre()
        + ", apellido=" + getApellido() + ", edad=" + getEdad() + "]";
  }

}
```

Clase JugadorPrimera:

```java
import java.util.Calendar;

public class JugadorPrimera extends Jugador {
  private Calendar fchFin;

  public Calendar getFchFin() {
    return this.fchFin;
  }

  public JugadorPrimera(String nombre, String apellido, int edad, String idJugador, Calendar fchInicio,
      Calendar fchFin) {
    super(nombre, apellido, edad, idJugador, fchInicio);
    this.fchFin = fchFin;
  }

  @Override
  public double importeNomina(Calendar hasta) {
    double nomina = 0;
    if (this.fchInicio.before(hasta)) {
      int anios = hasta.get(Calendar.YEAR) - this.fchInicio.get(Calendar.YEAR);
      int meses = hasta.get(Calendar.MONTH) - this.fchInicio.get(Calendar.MONTH);
      if (hasta.get(Calendar.DAY_OF_MONTH) < this.fchInicio.get(Calendar.DAY_OF_MONTH)) {
        --meses;
      }
      nomina = ((anios * 12) + meses) * 25000;
    }
    return nomina;
  }

  @Override
  public String toString() {
    return "JugadorPrimera [Id del Jugador=" + getIdJugador() + ", Nombre=" + getNombre() + getIdJugador()
        + ", Apellido=" + getApellido() + ", Edad=" + getEdad() + ", fchInicio="
        + this.fchInicio.get(Calendar.DAY_OF_MONTH)
        + "/" + (this.fchInicio.get(Calendar.MONTH) + 1) + "/" + this.fchInicio.get(Calendar.YEAR) + ", fchFin="
        + this.fchFin.get(Calendar.DAY_OF_MONTH) + "/" + (this.fchFin.get(Calendar.MONTH) + 1) + "/"
        + this.fchFin.get(Calendar.YEAR) + "]";
  }

}
```

Clase JugadorReserva:

```java
import java.util.Calendar;

public class JugadorReserva extends Jugador {
  public JugadorReserva(String nombre, int edad, String apellido, String id, Calendar fchInicio) {
    super(nombre, apellido, edad, id, fchInicio);
  }

  @Override
  public double importeNomina(Calendar hasta) {
    double nomina = 0;
    if (this.fchInicio.before(hasta)) {
      int anios = hasta.get(Calendar.YEAR) - this.fchInicio.get(Calendar.YEAR);
      int meses = hasta.get(Calendar.MONTH) - this.fchInicio.get(Calendar.MONTH);
      if (hasta.get(Calendar.DAY_OF_MONTH) < this.fchInicio.get(Calendar.DAY_OF_MONTH)) {
        --meses;
      }
      nomina = ((anios * 12) + meses) * 15000;
    }
    return nomina;
  }

  @Override
  public String toString() {
    return "JugadorPrimera [Id del Jugador=" + getIdJugador() + ", Nombre=" + getNombre() + getIdJugador()
        + ", Apellido=" + getApellido() + ", Edad=" + getEdad() + ", fchInicio="
        + this.fchInicio.get(Calendar.DAY_OF_MONTH) + "/" + (this.fchInicio.get(Calendar.MONTH) + 1) + "/"
        + this.fchInicio.get(Calendar.YEAR) + "]";
  }
}
```

Clase ListaJugadores:

```java
import java.util.ArrayList;
import java.util.Calendar;

public class ListaJugadores {
  private ArrayList<Jugador> jugadores;

  public ListaJugadores() {
    this.jugadores = new ArrayList<>();
  }

  public void agregarJugador(Jugador jugador) {
    this.jugadores.add(jugador);
  }

  public void imprimirListado() {
    for (Jugador jugador : this.jugadores) {
      if (jugador instanceof JugadorPrimera) {
        System.out.println("Jugador de Primera");
      } else {
        System.out.println("Jugador de Reserva");
      }
      System.out.println(jugador);
    }
  }

  public double importeTotalNominaJugadores(Calendar hasta) {
    double nominaTotal = 0;
    if (!(this.jugadores.isEmpty())) {
      for (Jugador jugador : this.jugadores) {
        nominaTotal += jugador.importeNomina(hasta);
      }
    }
    return nominaTotal;
  }
}
```

Clase TestListaJugadores:

```java
import java.util.Calendar;

public class TestListaJugadores {
  public static void main(String[] args) {
    Calendar fecha1 = Calendar.getInstance();
    Calendar fecha2 = Calendar.getInstance();
    Calendar fecha3 = Calendar.getInstance();
    Calendar fecha4 = Calendar.getInstance();
    Calendar fecha5 = Calendar.getInstance();
    fecha1.set(2024, Calendar.JUNE, 11);
    fecha2.set(2024, Calendar.MARCH, 20);
    fecha3.set(2028, Calendar.NOVEMBER, 28);
    fecha4.set(2027, Calendar.APRIL, 17);
    fecha5.set(2025, Calendar.DECEMBER, 25);
    JugadorPrimera jp1 = new JugadorPrimera("Juan", "Romero", 22, "34", fecha1, fecha3);
    JugadorPrimera jp2 = new JugadorPrimera("Esteban", "Valdiviezo", 23, "842", fecha2, fecha4);
    JugadorPrimera jp3 = new JugadorPrimera("Carlos", "Tevez", 21, "39", fecha2, fecha3);
    JugadorPrimera jp4 = new JugadorPrimera("Miguel", "Crespo", 24, "892", fecha1, fecha4);
    JugadorReserva jr1 = new JugadorReserva("Martin", 19, "Cruz", "93", fecha1);
    JugadorReserva jr2 = new JugadorReserva("Sebastian", 18, "Serrano", "362", fecha2);
    ListaJugadores lista = new ListaJugadores();
    lista.agregarJugador(jp1);
    lista.agregarJugador(jp2);
    lista.agregarJugador(jp3);
    lista.agregarJugador(jp4);
    lista.agregarJugador(jr1);
    lista.agregarJugador(jr2);
    lista.imprimirListado();
    System.out.println("En navidad de 2025 habria que pagar en total: $" + lista.importeTotalNominaJugadores(fecha5));
  }
}
```

***

**Ejercicio 4**: En un ArrayList se almacenan las calificaciones de P1, RP1, P2, RP2 y TPF (Trabajo Práctico Final) de alumnos de una asignatura del Departamento de Informática. Desarrolle un programa que realice lo siguiente:
a) Devolver la cantidad de alumnos regulares.
b) Devolver la cantidad de alumnos libres.
c) Devolver la cantidad de alumnos que abandonaron el cursado.
Nota: use las siguientes clases e implemente las faltantes.

```java
public class Person {
  private String nombre;
  private char sexo;
  private long dni;

  public Person(String nombre, char sexo, long dni) {
    this.nombre = nombre;
    this.sexo = sexo;
    this.dni = dni;
  }

  public String getNombre() {
    return this.nombre;
  }

  public char getSexo() {
    return this.sexo;
  }

  public long getDni() {
    return this.dni;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

}

public class Student extends Person {
  long LU;
  String facultad;
  String carrera;
  int anioIngreso;

  Student(String nombre, char sexo, long dni, long lu, String facultad, String carrera, int anioIngreso) {
    super(nombre, sexo, dni);
    this.LU = lu;
    this.facultad = facultad;
    this.carrera = carrera;
    this.anioIngreso = anioIngreso;
  }

  long getLu() {
    return this.LU;
  }
}

abstract class AbsStudent extends Student {
  int P1, RP1, P2, RP2, TPFinaal;

  public AbsStudent(String nombre, char sexo, long dni, long lu, String facultad, String carrera, int anioIngreso,
      int p1, int rP1, int p2, int rP2, int tPFinaal) {
    super(nombre, sexo, dni, lu, facultad, carrera, anioIngreso);
    this.P1 = p1;
    this.RP1 = rP1;
    this.P2 = p2;
    this.RP2 = rP2;
    this.TPFinaal = tPFinaal;
  }

  boolean estaRegular() {
    return (this.P1 >= 60 || this.RP1 >= 60) && (this.P2 >= 60 || this.RP2 >= 60) && this.TPFinaal >= 6;
  }

  abstract boolean estaLibre();

  abstract boolean estaAusente();

  abstract void showStudent();
}
```

Clases faltantes:

```java
public class Alumno extends AbsStudent {

  public Alumno(String nombre, char sexo, long dni, long lu, String facultad, String carrera, int anioIngreso, int p1,
      int rP1, int p2, int rP2, int tPFinal) {
    super(nombre, sexo, dni, lu, facultad, carrera, anioIngreso, p1, rP1, p2, rP2, tPFinal);
  }

  @Override
  boolean estaAusente() {
    return this.P1 == 0 && this.RP1 == 0 && this.P2 == 0 && this.RP2 == 0 && this.TPFinal == 0;
  }

  @Override
  boolean estaLibre() {
    return (this.P1 < 60 && this.RP1 < 60) || (this.P2 < 60 && this.RP2 < 60) || this.TPFinal < 60;
  }

  @Override
  void showStudent() {
    System.out.println("Nombre: " + getNombre());
    String sexo = (getSexo() == 'M' || getSexo() == 'm') ? "Masculino" : "Femenino";
    System.out.println("Sexo: " + sexo);
    System.out.println("DNI: " + getDni());
    System.out.println("LU: " + this.LU);
    System.out.println("Facultad: " + this.facultad);
    System.out.println("Carrera: " + this.carrera);
    System.out.println("Anio de Ingreso: " + this.anioIngreso);
    System.out.println("=== Notas durante la cursada ===");
    System.out.print("Primer Parcial: " + this.P1);
    System.out.print("\tRecuperatorio del Primer Parcial: " + this.RP1);
    System.out.print("\tSegundo Parcial: " + this.P2);
    System.out.print("\tRecuperatorio del Segundo Parcial: " + this.RP2);
    System.out.println("\tTrabajo Practico Final: " + this.TPFinal);
  }

}
```

```java
import java.util.ArrayList;

public class ListaAlumnos {
  private ArrayList<Alumno> alumnos;

  public ListaAlumnos() {
    this.alumnos = new ArrayList<>();
  }

  public ListaAlumnos(ArrayList<Alumno> alumnos) {
    this.alumnos = alumnos;
  }

  public void agregarAlumno(Alumno alumno) {
    this.alumnos.add(alumno);
  }

  public void mostrarAlumnos() {
    if (!(this.alumnos.isEmpty())) {
      for (Alumno alumno : this.alumnos) {
        alumno.showStudent();
      }
    }
  }

  public int cantRegulares() {
    int cantidad = 0;
    if (!(this.alumnos.isEmpty())) {
      for (Alumno alumno : this.alumnos) {
        if (alumno.estaRegular()) {
          ++cantidad;
        }
      }
    }
    return cantidad;
  }

  public int cantLibres() {
    int cantidad = 0;
    if (!(this.alumnos.isEmpty())) {
      for (Alumno alumno : this.alumnos) {
        if (alumno.estaLibre()) {
          ++cantidad;
        }
      }
    }
    return cantidad;
  }

  public int cantAbandonos() {
    int cantidad = 0;
    if (!(this.alumnos.isEmpty())) {
      for (Alumno alumno : this.alumnos) {
        if (alumno.estaAusente()) {
          ++cantidad;
        }
      }
    }
    return cantidad;
  }
}
```

***

**Ejercicio 5**: Dada la clase ListaAbs, se pide:
Implementar en una subclase ```ListaEnteros``` los métodos abstractos, para obtener una lista de números enteros. Escriba un programa para testear dicha lista.
Implementar en una subclase ```ListadeCuenta``` los métodos abstractos, para obtener una lista de Cuentas Bancarias, que se ordenará de menor a mayor según el saldo. Utilice la siguiente clase ```CuentaBancaria``` para testear la lista, instanciando y cargando al azar los saldos correspondientes.

```java
public class CuentaBancaria {
  private int numero;
  private String titular;
  private double saldo;
  private int maxExtr;
  private int cantExtr;

  public CuentaBancaria(int numero, String titular, int maxExtr) {
    this.numero = numero;
    this.titular = titular;
    this.maxExtr = maxExtr;
  }

  public double getSaldo() {
    return this.saldo;
  }

  public void depositar(double monto) {
    this.saldo += monto;
  }

  public boolean extraer(double monto) {
    if (monto > this.saldo) {
      return false;
    } else if (this.cantExtr != this.maxExtr) {
      this.saldo -= monto;
      ++this.cantExtr;
      return true;
    } else {
      System.out.println("Llego al limite maximo de extracciones");
      return false;
    }
  }

  public void mostrarDatos() {
    System.out.print("Numero de cuenta: " + this.numero);
    System.out.println("\t Titular: " + this.titular);
    System.out.println("Saldo: " + this.saldo);
  }
}
```

Clase ListaAbs:

```java
import java.util.ArrayList;

public abstract class ListaAbs {
  private int cantelementos;
  private ArrayList elementos;
  private boolean ordenada;

  public ListaAbs() {
    elementos = new ArrayList();
    setCantElem(0);
    setOrdenada(true);
  }

  public int getCantElem() {
    return this.cantelementos;
  }

  public boolean estaOrdenada() {
    return this.ordenada;
  }

  public boolean estaVacia() {
    return getCantElem() == 0;
  }

  private void setOrdenada(boolean valor) {
    this.ordenada = valor;
  }

  private void setCantElem(int valor) {
    this.cantelementos = valor;
  }

  public abstract boolean mayor(Object elemento, Object otroelemento);// métodos abstractos que se definirán en
                                                                      // subclases

  public abstract boolean menor(Object elemento, Object otroelemento);

  public abstract boolean iguales(Object elemento, Object otroelemento);

  public abstract void imprimir(Object elemento);

  public Object getElemento(int pos) {
    Object elemento = null;
    if (pos < getCantElem()) {
      elemento = elementos.get(pos);
    }
    return elemento;
  }

  public Object getUltimo() {
    Object ultimo = null;
    if (!estaVacia()) {
      ultimo = getElemento(getCantElem() - 1);
    }
    return ultimo;
  }

  public void meter(Object elemento) {
    if (!estaVacia()) {
      if (mayor(getUltimo(), elemento)) {
        setOrdenada(false);
      }
    }
    elementos.add(elemento);
    setCantElem(getCantElem() + 1);
  }

  public void setElemento(Object elemento, int pos) {// pone un elemento en una posición determinada
    if (pos < getCantElem() && pos >= 0) {
      elementos.set(pos, elemento);
      setOrdenada(false);// ¿cómo podría mejorar esto?
    }
  }

  public void ordenar() {
    if (!estaOrdenada()) {
      Object aux;
      int pos_menor;
      for (int i = 0; i < getCantElem(); i++) {
        aux = getElemento(i);
        pos_menor = posDelMenor(i);
        setElemento(getElemento(pos_menor), i);
        setElemento(aux, pos_menor);
      }
      setOrdenada(true);
    }
  }

  public int posDelMenor(int desde) {
    if (desde == getCantElem() - 1) {
      return desde;
    } else {
      int men = posDelMenor(desde + 1);
      if (menor(getElemento(desde), getElemento(men))) {
        return desde;
      } else {
        return men;
      }
    }
  }

  public boolean buscar(Object elemento) {
    if (estaOrdenada()) {
      return busquedaBinaria(elemento, 0, getCantElem() - 1);
    } else {
      boolean encontrado = false;
      int k = 0;
      while (k < getCantElem() && !encontrado) {
        if (iguales(elemento, getElemento(k))) {
          encontrado = true;
        } else {
          k++;
        }
      }
      return encontrado;
    }
  }

  public boolean busquedaBinaria(Object x, int primero, int ultimo) {
    int medio;
    if (primero > ultimo) {
      return false;
    } else {
      medio = (primero + ultimo) / 2;
      if (iguales(x, getElemento(medio))) {
        return true;
      } else {
        if (menor(x, getElemento(medio))) {
          return busquedaBinaria(x, primero, medio - 1);
        } else {
          return busquedaBinaria(x, medio + 1, ultimo);
        }
      }
    }
  }

  public void mostrar() {
    for (int k = 0; k < getCantElem(); k++) {
      imprimir(getElemento(k));
    }
  }
}
```

Clase ListaEnteros:

```java
public class ListaEnteros extends ListaAbs {

  @Override
  public boolean iguales(Object elemento, Object otroelemento) {
    int e = (Integer) elemento;
    int otroE = (Integer) otroelemento;
    return Integer.compare(e, otroE) == 0;
  }

  @Override
  public void imprimir(Object elemento) {
    int e = (Integer) elemento;
    System.out.println(e);
  }

  @Override
  public boolean mayor(Object elemento, Object otroelemento) {
    int e = (Integer) elemento;
    int otroE = (Integer) otroelemento;
    return Integer.compare(e, otroE) > 0;
  }

  @Override
  public boolean menor(Object elemento, Object otroelemento) {
    int e = (Integer) elemento;
    int otroE = (Integer) otroelemento;
    return Integer.compare(e, otroE) < 0;
  }
}
```

Clase TestListaEnteros:

```java
import java.util.Random;

public class TestListaEnteros {
  public static void main(String[] args) {
    ListaEnteros lista = new ListaEnteros();
    Random random = new Random();
    int numero = random.nextInt(100);
    for (int i = 0; i < 10; i++) {
      lista.meter(numero);
      numero = random.nextInt(100);
    }
    lista.mostrar();
    lista.ordenar();
    lista.mostrar();
  }
}
```

Clase ListadeCuenta:

```java
public class ListadeCuenta extends ListaAbs {

  @Override
  public boolean iguales(Object elemento, Object otroelemento) {
    CuentaBancaria elem = (CuentaBancaria) elemento;
    CuentaBancaria otro = (CuentaBancaria) otroelemento;
    return elem.getSaldo() == otro.getSaldo();
  }

  @Override
  public void imprimir(Object elemento) {
    CuentaBancaria elem = (CuentaBancaria) elemento;
    elem.mostrarDatos();
  }

  @Override
  public boolean mayor(Object elemento, Object otroelemento) {
    CuentaBancaria elem = (CuentaBancaria) elemento;
    CuentaBancaria otro = (CuentaBancaria) otroelemento;
    return elem.getSaldo() > otro.getSaldo();
  }

  @Override
  public boolean menor(Object elemento, Object otroelemento) {
    CuentaBancaria elem = (CuentaBancaria) elemento;
    CuentaBancaria otro = (CuentaBancaria) otroelemento;
    return elem.getSaldo() < otro.getSaldo();
  }
}
```

Clase TestListaCuentas:

```java
import java.util.Random;

public class Main {
  public static void main(String[] args) {
    Random random = new Random();
    ListadeCuenta lista = new ListadeCuenta();
    for (int i = 0; i < 6; i++) {
      CuentaBancaria cuentaBancaria = new CuentaBancaria(i, "Titular " + i, 10);
      cuentaBancaria.depositar(random.nextInt(5000) + 1);
      lista.meter(cuentaBancaria);
    }
    lista.mostrar();
  }
}
```