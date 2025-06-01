public class Main {
    public static void main(String[] args) {
        MatrizMagica m = new MatrizMagica(3);  // Matriz 3x3

        System.out.println("Matriz generada:");
        m.mostrar();

        if (m.esCuadradoMagico()) {
            System.out.println("Es un cuadrado mágico.");
        } else {
            System.out.println("NO es un cuadrado mágico.");
        }
    }
}
