public class Matriz {
    protected char[][] matriz;
    protected int cantFilas;
    protected int cantColumnas;

    public Matriz(char[][] matriz){
        this.matriz = matriz;
        this.cantFilas =matriz.length;
        this.cantColumnas = matriz[0].length;
    }

    public Matriz(){
    }

    public char[][] getMatriz() {
        return this.matriz;
    }

    public char subRegion(int f,int c,int cant){
        char mayor = this.matriz[f][c];
        for (int i=f;i<f+cant;i++){
            for (int j=c;j<c+cant;j++){
                if(this.matriz[i][j]>mayor)
                    mayor = this.matriz[i][j];

            }
        }
        return mayor;
    }

    public void inserta(char x){
        for(int i=0;i<this.cantFilas;i++){
            for (int j=0;j<this.cantColumnas;j++){
                if(this.matriz[i][j]=='\0'){
                    this.matriz[i][j]=x;
                    return;
                }
            }
        }
    }

}
