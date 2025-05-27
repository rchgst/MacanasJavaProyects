public class Main {
    public static void main(String[] args) {
        int[][] matriz1 = {
                {0, 0, 255, 255},
                {128, 128, 128, 255},
                {0, 0, 128, 128},
                {255, 255, 0, 0}
        };

        int[][] matriz2 = {
                {0, 0, 255, 255},
                {128, 128, 128, 255},
                {0, 0, 128, 128},
                {255, 255, 0, 0}
        };

        // Crear las imágenes
        Imagen img1 = new Imagen(matriz1);
        Imagen img2 = new Imagen(matriz2);

        // Calcular histogramas
        img1.calcularHistograma();
        img2.calcularHistograma();

        // Imprimir histograma de img1
        System.out.println("Histograma de la imagen 1:");
        for (int i = 0; i < 256; i++) {
            int frecuencia = img1.frecPixel(i);
            if (frecuencia > 0) {
                System.out.println("Valor " + i + ": " + frecuencia);
            }
        }

        // Normalizar histograma
        double[] histNorm = new double[256];
        histNorm = img1.histogramaNormalizado(histNorm);
        System.out.println("\nHistograma normalizado de imagen 1:");
        for (int i = 0; i < 256; i++) {
            if (histNorm[i] > 0) {
                System.out.printf("Valor %d: %.2f%n", i, histNorm[i]);
            }
        }

        // Comparar imágenes
        boolean iguales = img1.comparaImagenes(img2);
        System.out.println("\n¿Las imágenes tienen el mismo histograma? " + (iguales ? "Sí" : "No"));
    }
}