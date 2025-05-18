import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Lista inicial de prueba
        ArrayList<Double> datosIniciales = new ArrayList<>(Arrays.asList(5.0, 2.0, 3.0, 2.0, 8.0, 1.0, 2.0));
        Lista lista = new Lista(datosIniciales, 10);

        System.out.println("=== PRUEBAS DE FUNCIONALIDADES ===\n");

        // Mostrar lista original
        System.out.println("Lista original: " + lista.lista);

        // 1. Determinar si existe un elemento
        System.out.println("\n¿Contiene el número 3.0?: " + lista.pertenece(3.0));
        System.out.println("¿Contiene el número 9.0?: " + lista.pertenece(9.0));

        // 2. Suma total
        System.out.println("\nSuma total de la lista: " + lista.sumatoria());

        // 3. Menor elemento
        System.out.println("\nMenor elemento: " + lista.menor());

        // 4. Mayor elemento
        System.out.println("Mayor elemento: " + lista.mayor());

        // 5. Elemento más frecuente
        System.out.println("Elemento más frecuente: " + lista.frecuencia());

        // 6. Promedio
        System.out.println("\nPromedio: " + lista.promedio());

        // 7. Sumar componente a componente otra lista
        ArrayList<Double> otraLista = new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0));
        lista.sumaListas(otraLista);
        System.out.println("\nDespués de sumar componente a componente:\n" + lista.lista);

        // 8. Multiplicar componente a componente por otra lista
        lista.multiplicaListas(otraLista);
        System.out.println("\nDespués de multiplicar componente a componente:\n" + lista.lista);

        // 9. Multiplicar todos los elementos por un valor ingresado (sobrecarga)
        lista.multiplicaListas(2);
        System.out.println("\nDespués de multiplicar por un valor (2):\n" + lista.lista);

        // 10. Determinar suma entre dos posiciones
        int ini = 1, fin = 4;
        System.out.println("\nSuma de elementos entre las posiciones " + ini + " y " + fin + ": " + lista.sumatoria(ini, fin));

        // 11. Ordenar de menor a mayor
        lista.ordenar();
        System.out.println("\nLista ordenada de menor a mayor:\n" + lista.lista);

        System.out.println("\n=== FIN DE LAS PRUEBAS ===");
    }
}
