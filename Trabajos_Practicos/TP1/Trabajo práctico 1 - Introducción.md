1) Defina los siguientes términos (Cite las bibliografías utilizadas):

**Objeto**

Un objeto es cualquier entidad observable que tenga una existencia física o imaginaria, que cuenta con un conjunto de atributos o características relevantes, y tiene un  determinado dentro de una realidad acotada.

**Clase**

Una clase es la especificación genérica de un número arbitrario de objetos similares.

**Polimorfismo**

El polimorfismo es la capacidad que tienen dos o más objetos de diferentes clases, de responder de forma adecuada al mismo mensaje.

**Atributo**

Un atributo es una cualidad de un objeto, que resulta relevante para el problema que deseamos resolver.

**Instanciación**

Crear una instancia, o instanciar, es el proceso mediante el cual le enviamos un mensaje a una clase para que cree un nuevo objeto, a partir de sus especificaciones.

**Interfaz**

Es una clase de la que no puede crearse objetos.

**Método**

Un método es una acción que realiza un objeto. Es la parte algorítmica del objeto.

**Herencia**

La herencia es el mecanismo mediante el cual se crea una clase como un super-conjunto de otra.

**Propiedad**

Una propiedad es una característica o atributo de un objeto que define su estado o comportamiento.

Para las respuestas de esta consigna se utilizó el libro de Pages de la materia.

****

2) Para las siguientes clases determine al menos 3 atributos y 3 métodos

Auto
**Atributos**: peso, color, patente
**Métodos**: encender(), apagar(), avanzar()

Gato
**Atributos**: peso, nombre, altura
**Métodos**: correr(), dormir(), bañarse()

Estudiante
**Atributos**: nombre, numeroDocumento, contacto
**Métodos**: estudiar(), aprobarParcial(), entregarPrácticos().

Diario
**Atributos**: editorial, fecha, cantidadPáginas 
**Métodos**: abrir(), cerrar(), pasarPágina()

****

3) Identifique los objetos, clases, atributos y proponga una jerarquía de clases para los siguientes casos:

- Existen diferentes medios de transporte (Por ejemplo: Autos, Motos, Aviones, Trenes, Barcos). Cada uno de ellos comparte características y acciones en común, pero también características propias.

![[3i-TP1.png]]

- Existen animales mamíferos y ovíparos. Ellos realizan ciertas actividades comunes, por ejemplo: comer, procrear, dormir, etc. Y otras diferentes como por ejemplo volar. ¿Cómo ubicarían al delfín? ¿Y al ornitorrinco?

![[3ii-TP1.png]]

En este caso no se puede colocar al Ornitorrinco en ningún lado. Esto se debe a que es mamífero y ovíparo a la vez, pero heredar de dos clases es incorrecto. Es como si fuera hijo de hermanos en este caso, por lo que no está permitido.

Si se hace este tipo de herencia  ocurre el problema del Mortal Diamante de la Muerte (DDD, Deadly Diamond of Death). Esto hace que cuando se ejecute el programa ocurra un error, ya que al crear el objeto que hereda de dos clases a la vez (en este caso, cuando se crea el objeto Ornitorrinco), por lo que puede pasar que en ambas clases de las que hereda haya un método en común (imaginemos que cuidarCría(cria: Mamifero) esté en Ovíparo y Mamífero), el objeto que creamos no sabrá cuál de los dos debe ejecutar.

Es por esto que en Java tal cosa no ocurre (el lenguaje no lo permite), pero es un error común en C++ cuando uno no presta atención sobre este detalle.

***

4) Mensajeros de películas:

Una empresa de mensajería quiere poder entregar paquetes a ciertos destinos (el destino se indica para el paquete a entregar). Para ello cuenta con un extraordinario equipo de mensajeros:

- Chuck Norris: Pesa 900 kg y puede llamar a cualquier persona del universo con solo llevarse el pulgar al oído. Nunca le pasa nada cuando entrega un paquete.
- Neo: Vuela, así que no pesa, y anda con celular. El tema es que a veces no tiene suficiente crédito para hacer llamadas. Puede ser que se vea afectado para entregar un paquete, depende de a dónde lo tenga que llevar. Cuando hace una llamada su crédito baja $5.
- Harry: Viaja en su bicicleta mágica o en su Buckbeak (Ave voladora). Su peso es el suyo propio más el peso del vehículo. La bicicleta pesa un kilo, el hipogrifo pesa media tonelada. Cuando Harry entrega un paquete (a donde sea) viajando en bicicleta baja de peso 2 kilos, no se ve afectado si viaja en su Buckbeak.

Los destinos posibles a los cuáles se envía actualmente un paquete son los siguientes:

- Puentes de Brooklyn: Deja pasar a todo lo que pese hasta una tonelada. No produce efectos extras entregar un paquete en este destino.
- La Matrix: Deja entrar a quién pueda hacer una llamada. Para entregar un paquete a este destino hay que llamar por teléfono.

Dada la narrativa identifique todas las clases, métodos y atributos necesarios para poder realizar una implementación real al problema de los mensajeros de películas.

![[4-TP1.png]]

***

5) (Implementación en Java) Una caja de ahorro tiene un saldo que nunca puede ser menor que 0. Las operaciones que un cliente puede realizar son: Depósito, Extracción y Consulta de saldo. Además, existe una cantidad máxima fija de extracciones por mes que puede realizar.
Defina una clase Caja con los atributos y métodos necesarios. Instancie varios objetos agregando (de ser necesario) información inicial.

Código con getters, setters, modificadores de acceso y constructores:

```java
public class CajaDeAhorro {

  private float saldo;
  private int cantExtraciones;
  private final static int MAX_EXTRACCIONES = 15;

  public float getSaldo() {
    return this.saldo;
  }

  public void setSaldo(float saldo) {
    this.saldo = saldo;
  }

  public int getCantExtraciones() {
    return this.cantExtraciones;
  }

  public void setCantExtraciones(int cantExtraciones) {
    this.cantExtraciones = cantExtraciones;
  }

  public static int getMaxExtracciones() {
    return CajaDeAhorro.MAX_EXTRACCIONES;
  }

  public CajaDeAhorro(float saldo) {
    this.saldo = saldo;
  }

  public CajaDeAhorro() {
  }

  public void deposito(float monto) {
    setSaldo(getSaldo() + monto);
    System.out.println("Se ha depositado $" + monto + " en su cuenta");
  }

  public void extraccion(float monto) {
    if (getCantExtraciones() <= getMaxExtracciones() && monto <= getSaldo()) {
      setSaldo(getSaldo() - monto);
      ++this.cantExtraciones;
      System.out.println("Se extrajo " + monto + " de su cuenta");
    } else {
      System.out.println("Ha superado la cantidad de extracciones de este mes o no tiene ese monto disponible!");
    }
  }

  public void consultaSaldo() {
    System.out.println("Su saldo es: $" + getSaldo());
  }

  public static void main(String[] args) {
    CajaDeAhorro caja1 = new CajaDeAhorro(100);
    CajaDeAhorro caja2 = new CajaDeAhorro();
    caja1.consultaSaldo();
    caja2.setSaldo(200);
    caja2.deposito(100);
    caja1.extraccion(200);
    caja1.deposito(300);
    caja2.extraccion(100);
    caja1.consultaSaldo();
    caja2.consultaSaldo();
  }
}
```

***

6) (Implementación en Java) Defina una clase Lista (piense en una lista de números) con los atributos y métodos necesarios para realizar las siguientes funcionalidades:
- Agregar un elemento.
- Eliminar un elemento.
- Ordenar la lista.
- Buscar un elemento.

Con ArrayList:

```java
import java.util.ArrayList;
import java.util.Collections;

public class ListaNumeros {
  private ArrayList<Integer> lista = new ArrayList<>();

  public void agregarElemento(int numero) {
    this.lista.add(numero);
  }

  public void eliminarElemento(int numero) {
    if (this.lista.contains(numero)) {
      this.lista.remove(Integer.valueOf(numero));
    } else {
      System.out.println("Ese numero no se encuentra en la lista");
    }
  }

  public void ordenarLista() {
    Collections.sort(this.lista);
  }

  public void buscarElemento(int numero) {
    int posicion;
    if (this.lista.contains(numero)) {
      posicion = this.lista.indexOf(Integer.valueOf(numero));
      System.out.println("El elemento se encuentra en la posicion " + posicion + " de la lista");
    } else {
      System.out.println("El numero no se encuentra en la lista.");
    }
  }

  public static void main(String[] args) {
    ListaNumeros listaNumeros = new ListaNumeros();
    listaNumeros.agregarElemento(10);
    listaNumeros.agregarElemento(5);
    listaNumeros.agregarElemento(40);
    listaNumeros.agregarElemento(8);
    listaNumeros.agregarElemento(28);
    listaNumeros.buscarElemento(10);
    listaNumeros.buscarElemento(100);
    listaNumeros.eliminarElemento(5);
    listaNumeros.eliminarElemento(32);
    listaNumeros.ordenarLista();
    listaNumeros.buscarElemento(28);
    listaNumeros.buscarElemento(35);
  }
}
```