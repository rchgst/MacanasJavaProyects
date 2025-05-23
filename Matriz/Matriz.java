import java.util.Random;
public class Matriz{
   public int [][] matriz;
   public int mayorventa;
   public int posicionFila;
    public Matriz(){
    this.matriz = new int[0][0];
    this.mayorventa=0;
    this.posicionFila=0;
    
}
public Matriz(int Fila,int Columna){
 this.matriz= new int[Fila][Columna];   
}
public int getelemento(int fila, int columna){
    return this.matriz[fila][columna];
}
public void setelemento(int fila,int columna,int valor){
    this.matriz[fila][columna]=valor;
}
//es al pedo ?¿
public void CargaMatriz(){
    for(int i=0;i<this.matriz.length;i++){
        for(int j=0;j<this.matriz[0].length;j++){
            this.matriz[i][j]=new Random().nextInt(10000);
        }
    }
} 
public void setposmayorventa(int posicionFila){
    this.posicionFila=posicionFila;

} 
public int [] getColumna(int Columna){
    return matriz[Columna];
} 
public void determineMayor(){
    int mayor=0;
    for(int i=0;i<this.matriz.length;i++){
       int suma=0;
        int [] Columna= getColumna(i);
        for(int j=0;j<Columna.length;j++){  
            suma+=Columna[j];
            }
            if(suma>mayor){
                mayor=suma;
                setposmayorventa(i);
            }
        }
    }
}

