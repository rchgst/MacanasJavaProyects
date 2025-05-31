public class Espejo extends Matriz {
    public Espejo(int m,int n){
        super(m,n);
    }
    public void invertir(){
        char aux;
        int i,j,k;
        for (i=0;i<getFilas();i++){
            k=getColumnas();
            for (j=0;(j<(int)getColumnas()/2);j++){
                aux=getValor(i,j);
                setValor(i,j,getValor(i,k-1));
                setValor(i,k-1,aux);
                k--;

            }
        }
    }
}
