public class Main {
    public static void main(String[] args) {
        // Crear dos matrices 3x3
        Matriz m1 = new Matriz(3, 3);
        Matriz m2 = new Matriz(3, 3);

        // Cargar valores en m1
        m1.setElem(0, 0, 1);
        m1.setElem(0, 1, 2);
        m1.setElem(0, 2, 3);
        m1.setElem(1, 0, 4);
        m1.setElem(1, 1, 5);
        m1.setElem(1, 2, 6);
        m1.setElem(2, 0, 7);
        m1.setElem(2, 1, 8);
        m1.setElem(2, 2, 9);

        // Copiar m1 en m2 para probar equals
        m2.copy(m1);

        // Mostrar matrices
        System.out.println("Matriz m1:");
        m1.mostrar();
        System.out.println("Matriz m2:");
        m2.mostrar();

        // Probar igualdad
        System.out.println("¿m1 es igual a m2?: " + m1.equals(m2));

        // Cambiar m2
        m2.setElem(0, 0, 10);
        System.out.println("¿m1 es igual a m2 luego del cambio?: " + m1.equals(m2));

        // Probar suma
        Matriz suma = m1.suma(m1);
        System.out.println("Suma de m1 + m1:");
        suma.mostrar();

        // Probar transpuesta
        Matriz transpuesta = m1.transpuesta();
        System.out.println("Transpuesta de m1:");
        transpuesta.mostrar();

        // Probar producto por escalar
        m1.producto1Escalar(2);
        System.out.println("Producto de m1 por escalar 2:");
        m1.mostrar();

        // Probar si es cuadrada, identidad, triangular superior/inferior, etc.
        System.out.println("¿m1 es cuadrada?: " + m1.esCuadrada());
        System.out.println("¿m1 es identidad?: " + m1.esIdentidad());
        System.out.println("¿m1 es triangular superior?: " + m1.esTriangSup());
        System.out.println("¿m1 es triangular inferior?: " + m1.esTriangInf());
        System.out.println("¿m1 es rala?: " + m1.esRala());
    }
}