
public class Imagenmtz{
    protected int [][] matriz;
    protected int filas;
    protected int columnas;
    public Imagenmtz(){
        this.matriz= new int [0][0];
        this.columnas=matriz[0].length;
        this.filas=matriz.length;
    }
    public Imagenmtz(int filas, int columnas){
        this.matriz= new int [filas][columnas];
        this.filas=filas;
        this.columnas=columnas;
    }
    public int getfila(){
        return this.filas;
    }
    public int getcolumna(){
    return this.columnas;
    }
    public void setvalor(int x, int y, int n){
        if(x>=0 && x<getfila() && y>=0 && x<getcolumna()){
            this.matriz[x][y]=n;
        }
    }
    public int getvalor(int x, int y){
        int valor=0;
        if(x>=0 && x<getfila() && y>=0 &&y<getcolumna()){
             valor=this.matriz[x][y];
        }
        return valor;
    }
    public String toString (){
    String aux="\n";
    for(int i = 0;i<this.filas;i++){
        for(int j = 0;j<this.columnas;j++){
            aux+=this.matriz[i][j]+"\t";
        }
        aux+="\n";
    }
    return aux;
    }
}