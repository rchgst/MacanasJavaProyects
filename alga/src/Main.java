public class Main {
    public static void main(String[] args) {
        // Crear dos matrices de 3x3
        Matriz m1 = new Matriz(3, 3);
        Matriz m2 = new Matriz(3, 3);

        // Asignar valores a m1
        double val = 1.0;
        for (int f = 0; f < m1.getCantFilas(); f++) {
            for (int c = 0; c < m1.getCantColumnas(); c++) {
                m1.setElem(f, c, val++);
            }
        }

        // Asignar valores a m2 (identidad)
        for (int f = 0; f < m2.getCantFilas(); f++) {
            for (int c = 0; c < m2.getCantColumnas(); c++) {
                if (f == c)
                    m2.setElem(f, c, 1.0);
                else
                    m2.setElem(f, c, 0.0);
            }
        }

        // Mostrar m1 y m2
        System.out.println("Matriz m1:");
        m1.mostrar();

        System.out.println("Matriz m2 (identidad):");
        m2.mostrar();

        // Suma
        System.out.println("Suma de m1 + m2:");
        Matriz suma = m1.suma(m2);
        suma.mostrar();

        // Producto
        System.out.println("Producto de m1 * m2:");
        Matriz producto = m1.producto(m2);
        producto.mostrar();

        // Transpuesta de m1
        System.out.println("Transpuesta de m1:");
        Matriz trans = m1.transpuesta();
        trans.mostrar();

        // Es cuadrada
        System.out.println("¿m1 es cuadrada? " + m1.esCuadrada());

        // Es identidad
        System.out.println("¿m2 es identidad? " + m2.esIdentidad());

        // Vector de mayores por fila
        double[] mayores = m1.vectorMayores();
        System.out.println("Mayores por fila en m1:");
        for (double d : mayores) {
            System.out.print(d + " ");
        }
        System.out.println();

        // Multiplicación por escalar
        System.out.println("m1 * 2:");
        Matriz esc = m1.prodx1Escalar(2);
        esc.mostrar();
    }
}
