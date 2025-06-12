# Colectivos

En este proyecto se intenta resolver e implementar en Java el siguiente ejercicio:

Dada la clase abstracta Colectivo:

Escriba la interface IDiesel:

- Escriba dos métodos:
- double getDistancia()
- double getNivelContaminacion()

Escriba la interface IElectrico

- Escriba el método double getVoltaje()
- Defina las constantes ALTO_VOLTAJE = 600, BAJO_VOLTAJE = 480.
- Ambas double

Escriba la clase Hibrido
exteds... implements... , ...
Atributos: voltaje, distancia, nivelContaminacion.
Escriba un constructor
Escriba getDistancia(), getNivelContaminacion(), getVoltaje(), getAcel().
getAcel() siempre devuelve 4.0

Escriba la clase ColectivoDiesel
Extienda e implemente apropiadamente.
Atributos: distancia, nivel de contaminacion.
Escriba un constructor
Implemente los métodos abstractos heredados; getAcel() devuelve 3.0

Escriba la clase TestColectivos:
importe java.util.ArrayList
Crear un colectivo Hibrido y otro Diesel
El Diesel con distancia de 200km, nivel de contaminacion 2, capacidad 50, costo
$1 millón.
El hibrido con distancia de 150km, nivel de contaminacion 2, alto voltaje, capacidad
45, costo $1.2 millones.
Cree un ArrayList.

```java
ArrayList<tipo?> arr = new ArrayList<>();
```

Agregue al ArrayList el Hibrido y el Diesel.
Recorra el ArrayList e invoque los métodos getNivelContaminacion() y getID() en cada
elemento y muestre el resultado. (casting)

Escriba la clase ColectivoElectrico
Extienda e implemente apropiadamente.
Atributo: voltaje.
Escriba un constructor.
Implemente los métodos necesarios; getAcel() devuelve 5.0

Por último, cree un objeto de tipo ColectivoElectrico
Bajo voltaje, capacidad 55, costo $0.9 millones.
Agregar el objeto ColectivoElectrico al ArrayList de la clase TestColectivos.
Se debe modificar el ArrayList de ser necesario, para que pueda almacenar el objeto
colectivo eléctrico, como al híbrido y al diesel.
Muestre el voltaje y/o el nivel de contaminación dentro del ciclo que utiliza para
recorrer el ArrayList en TestColectivos
