public class Matriz {
    protected char[][] matriz;
    protected int numFilas;
    protected  int numColumnas;

    public Matriz(int M,int N){
        this.matriz= new char[M][N];
        this.numFilas=M;
        this.numColumnas=N;
    }

    public int getNumColumnas() {
        return numColumnas;
    }

    public int getNumFilas() {
        return numFilas;
    }
    public void setValor(int x,int y,char valor){
        if(x>=0&&x<this.getNumFilas()&&y>=0&&y<getNumColumnas())
            this.matriz[x][y]=valor;
        else
            System.out.println("Valor "+ x+" , "+y+ "fuera de rango ");
    }

    @Override
    public String toString() {
        String aux = "";
        for(int i=0;i<getNumFilas();i++){
            for (int j=0;j<getNumColumnas();j++){
                aux+=this.matriz[i][j] +"\t";
            }
            aux+="\n";
        }
        return aux;
    }
}