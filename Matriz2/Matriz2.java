public class Matriz2{
    protected char [][] matriz;
    protected int filas;
    protected int columnas;
    public Matriz2(char [][] matriz){
        this.matriz=matriz;
        this.filas=matriz.length;
        this.columnas= matriz[0].length;
    }
    public Matriz2(){

    }
    public Matriz2(int filas, int columnas){
        this.filas= filas;
        this.columnas=columnas;
        matriz= new char[filas][columnas];

    }
    public char[][] getMTZ(){
        return matriz;
    }
    public char sub(int l, int k, int N){
        char may=this.matriz[l][k];
        for(int i=l;i<l+N;i++){
            for(int j=k;i<j+N;j++){
                if(this.matriz[i][j]>may){
                    may=this.matriz[i][j];
                }
            }
        }
        return may;
    }
    public void inserta(char x){
        for(int i=0;i<this.filas;i++){
            for(int j=0;j<this.columnas;j++){
                if(this.matriz[i][j]=='\0'){
                    this.matriz[i][j]=x;
                }
            }
        }

    }
}