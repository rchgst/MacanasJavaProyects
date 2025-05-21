public class MaxPooling extends Matriz{
    public MaxPooling(char[][] matriz){
        super(matriz);
    }

   public Matriz matrizMP(int N){
        Matriz m=new Matriz();
        char[][] mat;
        char mayorRegion;
        if((this.cantFilas%N)==0 && (this.cantColumnas%N)==0){
            mat = new char[cantFilas/N][cantColumnas/N];
            m = new Matriz(mat);
            for(int i=0;i*N<this.cantFilas;i++){
                for (int j=0;j*N<this.cantColumnas;j++){
                    mayorRegion = this.subRegion(i*N,j*N,N);
                    m.inserta(mayorRegion);
                }
            }
        }
        return m;
   }

}
