import java.util.Arrays;
public class histograma extends Imagenmtz {
    public double [] histograma;
    public int tamaño;
public histograma(){
    super();
    this.histograma=new double[this.tamaño];
    this.tamaño=256;
}
public histograma(int x, int y,int tam){
    super(x,y);
    this.tamaño=tam;
    this.histograma=new double [tam];
}
public double[] agregagrises(){
    for(int i=0;i<super.filas;i++){
        for(int j=0;j<super.columnas;j++){
            histograma[super.getvalor(i, j)]++;
        }
    }
    return histograma;
}

public double[] renderizapixel(){
    double may=0;
    for(double valor:histograma){
        if(valor>may){
            may=valor;
        }
    }
    for(int i=0;i<tamaño;i++){
        histograma[i]=histograma[i]/may;
    }
    return histograma;
    }

public boolean mismorenderizado(double [] C){
    if(Arrays.equals(histograma, C)){ 
        return true; 
    }
    else{
        return false;}
}
}

