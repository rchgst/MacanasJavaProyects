public class Matriz {
    private double[][] matriz;

    public Matriz(int filas,int columnas){
        this.matriz= new double[filas][columnas];
    }
    public void setElem(int f,int c,double elem) {
        if (f >= 0 && f < this.matriz.length && c >= 0 && c < this.matriz[0].length)
            this.matriz[f][c] = elem;
        else
            System.out.println("posicion invalida");
    }
    public void copy(Matriz m){
        if(this.matriz.length==m.matriz.length&&this.matriz[0].length==m.matriz[0].length){
            for(int f=0;f<this.matriz.length;f++){
                for (int c=0;c<this.matriz[0].length;c++)
                    this.matriz[f][c]=m.matriz[f][c];
            }
        }
        else
            System.out.println("Los tamaños no coinciden ");
    }
    public boolean existePos(int f,int c){
        return (f>=0&&f<this.matriz.length&&c>=0&&c<this.matriz[0].length);
    }
    public int getCantFilas(){
        return this.matriz.length;
    }
    public int getCantColumnas(){
        return this.matriz[0].length;
    }
    public double getElem(int f,int c){
        double retorno = 0.0;
        if(f>=0&&f<this.matriz.length&&c>=0&c<this.matriz[0].length){
            retorno= this.matriz[f][c];
        }
        else
            System.out.println("INDICES INVALIDOS ");
        return retorno;
    }
    public Matriz clone(){
        return this;//bueno aca deberia crear una instancia de matriz y copiarle los elementos zzzz
    }
    public boolean equals(Matriz m){
        if(this.matriz.length==m.matriz.length&&this.matriz[0].length==m.matriz[0].length){
            int c,f=0,b=0;
            while (b==0&&f<this.matriz.length){
                c=0;
                while (b==0&&c<this.matriz[0].length){
                    if(this.matriz[f][c]==m.matriz[f][c]){
                        c++;
                    }
                    else
                        b=1;
                }
                f++;
            }
            return b==0;
        }
        else
            return false;
    }
    public boolean esCuadrada(){
        return this.matriz.length==this.matriz[0].length;
    }
    public boolean esIdentidad(){
        if(!this.esCuadrada())
            return false;
        int b=0,f=0,c;
        while (b==0&&f<this.matriz.length){
            c=0;
            while (b==0&&c<this.matriz[0].length){
                if(f!=c){
                    if(!(this.matriz[f][c]==0))
                        b=1;
                }
                else{
                    if(!(this.matriz[f][c]==1))
                        b=1;
                }
                c++;
            }
            f++;
        }
        return b==0;
    }
    public boolean esTriangSup(){
        if(!(this.esCuadrada()))
            return false;
        int f=0,b=0;
        while (b==0&&f<this.matriz.length){
           int c=f+1;
            while (b==0&&c<this.matriz[0].length){
                if(!(this.matriz[f][c]==0))
                    b=1;
                c++;
            }
            f++;
        }
        return b==0;
    }
    public boolean esTriangInf(){
        if (!(this.esCuadrada()))
            return false;
        int f=1,b=0;
        while (b==0&&f<this.matriz.length){
            int c=0;
            while (b==0&&c<f){
                if(!(this.matriz[f][c]==0))
                    b=1;
                c++;
            }
            f++;
        }
        return b==0;
    }
    public boolean esSimetrica(){
        if(!(this.esCuadrada()))
            return false;
        int f=0,b=0;
        while (b==0&&f<this.matriz.length){
            int c= f+1; //evita recorrer la diagonal y elementos de abajo
            while (b==0&&c<this.matriz[0].length){
                if(!(this.matriz[f][c]==this.matriz[c][f]))
                    b=1;
                c++;
            }
            f++;
        }
        return b==0;
    }
    public boolean esRala(){
        int cElem=this.getCantColumnas()*this.getCantFilas();
        int cont=0;
        for (int f=0;f<this.matriz.length;f++){
            for(int c=0;c<this.matriz[0].length;c++)
               if(this.matriz[f][c]==0)
                   cont++;
        }
        return cont>=(cElem/2);
    }//podria optimizarse cambiando los ciclos for por while y saliendo automaticamente cuando cont supere a la mitad de elementos
    public int cantElem(double elem){
        int cont=0;
        for (int f=0;f<this.matriz.length;f++){
            for (int c=0;c<this.matriz[0].length;c++){
                if(this.matriz[f][c]==elem)
                    cont++;
            }
        }
        return cont;
    }
    public boolean estaElem(double elem){
        int f=0,c;
        boolean encontrado = false;
        while (!encontrado&&f<this.matriz.length){
            c=0;
            while (!encontrado&&c<this.matriz[0].length){
                if(this.matriz[f][c]==elem)
                    encontrado=true;
                c++;
            }
            f++;
        }
        return encontrado;
    }
    public double[] vectorMayores() {
        double[] retorno = new double[this.matriz.length];
        double may;
        for (int f = 0; f < this.matriz.length; f++) {
            may = this.matriz[f][0];
            for (int c = 1; c < this.matriz[0].length; c++) {
                if (this.matriz[f][c] > may)
                    may = this.matriz[f][c];
            }
            retorno[f] = may;
        }
        return retorno;
    }
    public Matriz suma(Matriz m){
        Matriz mSumada=new Matriz(this.matriz.length,this.matriz[0].length);
        for (int f=0;f<this.matriz.length;f++){
            for(int c=0;c<this.matriz[0].length;c++)
                mSumada.matriz[f][c]=this.matriz[f][c]+m.matriz[f][c];
        }
        return mSumada;
    }
    public Matriz producto(Matriz m){
        Matriz mProd= new Matriz(this.matriz.length,m.matriz[0].length);
        for(int f=0;f<this.matriz.length;f++){
            for(int c=0;c<m.matriz[0].length;c++){
                double ac=0;
                for(int k=0;k<this.matriz[0].length;k++)
                   ac+=this.matriz[f][k]*m.matriz[k][c];
                mProd.matriz[f][c]=ac;
            }
        }
        return mProd;
    }
    public Matriz prodx1Escalar(double k){
        Matriz matrizxEsc=new Matriz(this.matriz.length,this.matriz[0].length);
        for (int f=0;f<this.matriz.length;f++){
            for (int c=0;c<this.matriz[0].length;c++)
                matrizxEsc.matriz[f][c]=this.matriz[f][c]*k;
        }
        return matrizxEsc;
    }
    public Matriz transpuesta(){
        Matriz transpuesta = new Matriz(this.matriz[0].length,this.matriz.length);
        for (int f=0;f<this.matriz.length;f++){
            for (int c=0;c<this.matriz[0].length;c++)
                transpuesta.matriz[c][f]=this.matriz[f][c];
        }
        return transpuesta;
    }
    public void mostrar(){
        String aux="";
        for(int i=0;i<this.matriz.length;i++) {
            for (int j = 0; j < this.matriz[0].length; j++) {
                aux += "\t " + this.matriz[i][j];
            }
            aux += "\n";
        }
        System.out.println(aux);
    }
}

