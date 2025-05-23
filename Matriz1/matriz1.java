public class matriz1{
    private char[][] matriz;
    private int filas, columnas;
    public matriz1(){
        this.matriz=new char[0][0];
        this.filas=matriz.length;
        this.columnas=matriz[0].length;
    }
    public matriz1(int filas, int columnas){
        this.matriz=new char[filas][columnas];
        this.filas=filas;
        this.columnas=columnas;
    }

            public int getfila(){
                return filas;
            }
            public int getcolumna(){
                return columnas;    
            }
            public void setvalor(int x, int y, char valor){
                if((x>=0)&&(x<getfila())&&(y>=0)&&(y<getcolumna())){
                    this.matriz[x][y]=valor;
                }
            }
            public char getvalor(int x, int y){
                char valor=' ';
                 if((x>=0)&&(x<getfila())&&(y>=0)&&(y<getcolumna())){
                     valor=this.matriz[x][y];
                }
                else{
                    System.out.println("Out");
                }
                return valor;
    }
            public String toString(){
                String aux= " \n";
                for(int i=0;i<getfila();i++){
                        
                    for(int j=0;j<getcolumna();j++){
                        aux+=getvalor(i, j)+"\t";
                    }
                    aux+="\n";
                }
                return aux;
            }
            public void Espejo(){
            
            for(int i=0;i<getcolumna();i++){
                for(int j=0;j<getfila()/2;j++){
                    char aux2=getvalor(i,j);
                    setvalor(i,j,getvalor(i,getfila()-(j+1)));
                    setvalor(i,getfila()-(j+1),aux2);
                    }
                }  
            }

}