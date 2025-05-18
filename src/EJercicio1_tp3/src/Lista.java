import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Lista {
    protected ArrayList<Double>lista;
    int tamMAx;

    public Lista(ArrayList<Double>lista,int max) {
        if (lista.size() <= max)
            this.lista = lista;
        else
            this.lista = new ArrayList<>(lista.subList(0,max));
    }

    public boolean pertenece(double x){
        return this.lista.indexOf(x) != -1;
    }

    public double sumatoria(){
        double acu=0;
        for(int i=0;i<this.lista.size();i++)
            acu+=this.lista.get(i);
        return acu;
    }

    public double menor(){
        double menor = this.lista.get(0);
        for(int i=0;i<this.lista.size();i++){
            if(this.lista.get(i)<menor)
                menor = this.lista.get(i);
        }
        return menor;
    }

    public double mayor(){
        double mayor = this.lista.get(0);
        for(int i=0;i<this.lista.size();i++){
            if(this.lista.get(i)>mayor)
                mayor = this.lista.get(i);
        }
        return mayor;
    }

    public double frecuencia() {
        double masFrecuente = lista.get(0);
        int frecuenciaMayor = 0;

        for (int i = 0; i < lista.size(); i++) {
            double actual = lista.get(i);
            int frecuenciaActual = Collections.frequency(lista, actual);
            if (frecuenciaActual > frecuenciaMayor) {
                frecuenciaMayor = frecuenciaActual;
                masFrecuente = actual;
            }
        }
        return masFrecuente;
    }

    public double promedio(){
        return this.sumatoria()/this.lista.size();
    }

    public void sumaListas(ArrayList<Double>listaB){
        if(this.lista.size() == listaB.size()){
            for(int i=0;i<this.lista.size();i++)
                this.lista.set(i,this.lista.get(i)+listaB.get(i));
        }
        else
            System.out.println("no se pueden sumar listas de distinto tamaño");

    }

    public void multiplicaListas(ArrayList<Double>listaB){
        if(this.lista.size() == listaB.size()){
            for(int i=0;i<this.lista.size();i++)
                this.lista.set(i,this.lista.get(i)*listaB.get(i));
        }
        else
            System.out.println("no se pueden sumar listas de distinto tamaño");

    }

    public void multiplicaListas(int mul){
        for(int i=0;i<this.lista.size();i++)
            this.lista.set(i,this.lista.get(i)*mul);
    }

    public double sumatoria(int ini,int fin){
        double acu=0;
        for(int i=ini;i<=fin;i++)
            acu+=this.lista.get(i);
        return acu;
    }

    public void ordenar(){
        this.lista.sort(null);
    }

}
