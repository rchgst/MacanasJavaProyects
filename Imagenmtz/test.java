import java.util.Random;
public class test {
    public static void main (String [] args){
        histograma  px= new histograma(2,2,256);
        for(int i=0;i<px.getfila();i++){
            for(int j=0;j<px.getcolumna();j++){
                int num=new Random().nextInt(256);
                px.setvalor(j, i, num);
            }
        }
        System.out.println(px.toString());
        
        double [] aux;
        aux=px.agregagrises();
        for(double valor: px.histograma){
            System.out.println(valor+" ");
        }
        aux=px.renderizapixel();
        for (double valor : aux) {
            System.out.println(valor+" ");
            
        }
    }

    
}
