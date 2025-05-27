import java.sql.Array;
import java.util.Arrays;

public class Imagen {
    private int[][] imagen;
    private int N;
    private int M;
    private int[] histograma = new int[256];

    public Imagen(int[][] imagen){
        this.imagen = imagen;
        this.N = this.imagen.length;
        this.M = this.imagen[0].length;
    }

    public int frecPixel(int pixel){
        int frec = 0;
        for(int i=0;i<this.N;i++){
            for (int j=0;j<this.M;j++){
                if(this.imagen[i][j] == pixel)
                    frec++;
            }
        }
        return frec;
    }

    public void calcularHistograma(){
        for (int i=0;i<256;i++){
            this.histograma[i] = this.frecPixel(i);
        }
    }

    public double mayorValor(){
        double mayor = 0;
        for(int i=0;i<256;i++){
            if(this.histograma[i] > mayor)
                mayor = this.histograma[i];
        }
        return mayor;
    }

    public double[] histogramaNormalizado(double[] histograma){
        double mayFrec = this.mayorValor();
        for (int i=0;i<256;i++){
            histograma[i] = this.histograma[i]/mayFrec;
        }
        return histograma;
    }

    public boolean comparaImagenes(Imagen otro){
        int i=0;
        while (i<256 && (this.histograma[i] == otro.histograma[i]))
            i++;
        if(i==256)
            return true;
        return false;
    }

    public void mostrarHistograma(){
        String mensaje = "[";
        for (int i=0;i<256;i++){
            mensaje += this.histograma[i] + ",";
        }
        mensaje += "]";
        System.out.println(mensaje);
    }

    public void mostrarHistograma(double[] histograma){
        String mensaje = "[";
        for (int i=0;i<256;i++){
            mensaje += histograma[i] + ",";
        }
        mensaje += "]";
        System.out.println(mensaje);
    }
}
