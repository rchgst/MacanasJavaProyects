import java.util.ArrayList;
public abstract class ListaOrdenada {
    private ArrayList<Object> lista;

    public ListaOrdenada(){

    }
    public int getTam(){
        return this.lista.size();
    }
    public boolean estaVacia(){
        return this.lista.isEmpty();
    }
    public abstract boolean menor(Object objA,Object objB);
    public abstract boolean mayor(Object objA,Object objB);
    public abstract boolean igual(Object objA,Object objB);
    public int posicionDe(Object obj){
        return busquedaBinaria(obj);
    }
    public void insertar(Object obj){
      int j;
      j=this.lista.size()-1;
       while (j>=0&&!(this.mayor(obj,this.lista.get(j))))
           j--;
       this.lista.add(j+1,obj);
    }
    public void eliminar(Object obj){
        int pos=busquedaBinaria(obj);
        if(pos!=-1)
            this.lista.remove(pos);
        else
            System.out.println("\nELEMENTO NO ENCONTRADO PARA ELIMINAR");
    }
    private int busquedaBinaria(Object obj){
    int ini=0, fin=this.lista.size()-1, mid= (ini+fin)/2;
    while (ini<fin&&!(this.igual(mid,obj))){
        if(this.menor(obj,this.lista.get(mid)))
            fin=mid-1;
        else
            ini=mid+1;
        mid=(ini+fin)/2;
    }
    if(ini<fin)
        return mid;
    else
        return -1;
    }
    public boolean esta(Object obj){
        int pos=busquedaBinaria(obj);
        if(pos!=-1)
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        String aux="[ ";
        for(int i=0;i<this.lista.size();i++)
            aux+= this.lista.get(i) +",\t";
        aux+="]";
        return aux;
    }
}
