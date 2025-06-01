import java.util.Random;
public class Matriz {
    private int[][] matriz;
    private int filas, columnas;

    public Matriz (int n){
        this.matriz=new int[n][n];
        this.filas=n;
        this.columnas=n;
        cargar();
    }
    public int getFilas(){
        return this.filas;
    }
    public int getColumnas(){
        return this.columnas;
    }
    public void cargar(){
        Random random = new Random();
        for (int i=0;i<getFilas();i++){
            for(int j=0;j<getColumnas();j++){
                this.matriz[i][j]=random.nextInt(getFilas()*getColumnas());
            }
        }
    }
    public int getValor(int x,int y){
        int valor=-1;
        if(x>=0&&x<getFilas()&&y>=0&&y<getColumnas()){
            valor=matriz[x][y];
        }
        else
            System.out.println("ERROR, INDICES FUERA DE RANGO");
        return valor;
    }
}
