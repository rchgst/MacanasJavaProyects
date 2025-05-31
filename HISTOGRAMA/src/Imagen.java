import java.util.Scanner;

public class Imagen {
    private int[][] imagen;
    private int N; //filas
    private int M; //columnas

    public Imagen(int filas,int columnas){
        this.imagen=new int[filas][columnas];
        this.N=filas;
        this.M=columnas;
    }
    public void setImagen(){
        Scanner consola = new Scanner(System.in);
        int valor;
        for (int f=0;f<this.N;f++){
            for (int c=0;c<this.M;c++){
                do{
                    System.out.println("Ingrese un valor para el pixel ["+f+","+c+"]");
                    valor=Integer.parseInt(consola.nextLine());
                    if(valor<0||valor>=256)
                        System.out.println("VALOR FUERA DE RANGO, INGRESE UN VALOR QUE SI SEA VALIDO. ");
                }while (valor<0||valor>=256);
                this.imagen[f][c]=valor;
            }
        }
    }
    public int[] calcularHistograma(){
        int[] histograma= new int[256];
        /*for(int i=0;i<256;i++){
            histograma[i]=0; Por defecto los arrays de int en java inicializan
            todos sus valores en cero}*/
        for(int f=0;f<this.N;f++){
            for(int c=0;c<this.M;c++){
                histograma[this.imagen[f][c]]++;
            }
        }
        return histograma;
    }
    public double[] calcularHistogramaNormalizado(){
        int [] histograma= this.calcularHistograma();
        int may=histograma[0];
        for(int i=1;i<256;i++){
            if(histograma[i]>may)
                may=histograma[i];
        }
        double[] normalizado = new double[256];
        for (int i=0;i<256;i++)
            normalizado[i]=(double)histograma[i]/may;
        return normalizado;
    }
    public boolean mismaDistribucion(Imagen otra){
        int[] A=this.calcularHistograma();
        int[] B=otra.calcularHistograma();
        int i=0;
        boolean esIgual=true;
        while (esIgual&&i<A.length){
            if(A[i]!=B[i])
                esIgual=false;
            i++;
        }
        return esIgual;
    }
}
