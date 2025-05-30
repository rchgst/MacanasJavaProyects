public class Main {
    public static void main(String[] args) {
        // Crear objeto Fotografia con 10 filas y 10 columnas
        Fotografia foto = new Fotografia(5, 4);

        // Generar la matriz de valores aleatorios
        foto.generaFoto();
        System.out.println("Matriz de valores (fotografia):");
        System.out.println(foto.toString());

        // Generar la tabla de estrellas
        foto.generaTablaEst();
        System.out.println("Tabla de estrellas detectadas:");
        System.out.println(foto.toStringEstrellas());
    }
}
