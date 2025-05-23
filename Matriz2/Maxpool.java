public class Maxpool extends Matriz2{
    public Maxpool(char [][] matriz){
        super(matriz);
    }
    public Matriz2 matrizmp(int N){
        Matriz2 m= new Matriz2();
        char[][] mat;
        char may;
        if(this.filas%N==0 && this.columnas%N==0){
            mat= new char [this.filas/N][this.columnas/N];
            m=new Matriz2(mat);
            for(int i=0;i*N<this.filas;i++){
                for(int j=0;j*N<this.columnas;j++){
                    may=this.sub(i*N, j*N, N);
                    m.inserta(may);
                }
            }

        }
        return m;
    }
}