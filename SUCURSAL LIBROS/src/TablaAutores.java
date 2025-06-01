import java.util.ArrayList;
public class TablaAutores {
    private ArrayList<Autor> autores;
    private int cantidad;

    public TablaAutores(int cantidad){
        this.autores= new ArrayList<Autor>();
        this.cantidad=cantidad;
    }
    public void insertarAutor(Autor autor){
        if(this.autores.size()<this.cantidad){
            int j=this.autores.size()-1;
            while (j>=0&&!this.autores.get(j).getNombre().equals(autor.getNombre()))
                j--;
            if(j>=0)
                System.out.println("ERROR, AUTOR YA CARGADO EN LA LISTA");
            else
                this.autores.add(autor);
        }
        else
            System.out.println("ERROR, TAMAÑO MAXIMO SUPERADO");
    }
    public int cantidadAutores(){
        return this.autores.size();
    }
    public boolean estaAutor(Autor autor){
        int j=this.autores.size()-1;
        while (j>=0&&!this.autores.get(j).getNombre().equals(autor.getNombre()))
            j--;
        return j>=0;
    }
    public boolean hayAutores(){
        return !this.autores.isEmpty();
    }
    public Autor recuperarAutor(int pos){
        if(pos<0||pos>=this.autores.size()){
            System.out.println("ERROR, POSICION INVALIDA");
            return null;
        }
        else{
            return this.autores.get(pos);
        }
    }
    public Autor recuperarAutor(String nombre){
        int j=this.autores.size()-1;
        while (j>=0&&!this.autores.get(j).getNombre().equals(nombre))
            j--;
        if(j>=0)
            return this.autores.get(j);
        else{
            System.out.println("AUTOR NO ENCONTRADO");
            return null;
        }
    }
    public TablaAutores autoresNac(String nac){
        TablaAutores nueva = new TablaAutores(this.cantidad);
        for (int i=0;i<this.autores.size();i++){
            if(this.autores.get(i).getNacionalidad().equals(nac)){
                nueva.autores.add(this.autores.get(i));
            }
        }
        if(!nueva.autores.isEmpty())
            return nueva;
        else {
            System.out.println("ERROR, NO EXISTEN AUTORES CON ESA NACIONALIDAD");
            return null;
        }
    }
}
