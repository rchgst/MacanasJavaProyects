import java.util.ArrayList;
public class TablaLibros {
    private ArrayList<Libro> libros;
    private int cantidad;

    public TablaLibros(int cantidad){
        this.libros=new ArrayList<Libro>();
        this.cantidad=cantidad;
    }
    public void insertarLibro(Libro libro){
        if(this.libros.size()<this.cantidad){
            int j=this.libros.size()-1;
            while (j>=0&&!this.libros.get(j).equals(libro))
                j--;
            if(j>=0)
                System.out.println("ERROR, LIBRO YA CARGADO.");
            else
                this.libros.add(libro);
        }
        else
            System.out.println("ERROR, TAMAÑO MAXIMO ALCANZADO");
    }
    public void eliminarLibro(Libro libro){
        int j=this.libros.size()-1;
        while (j>=0&&!this.libros.get(j).equals(libro))
            j--;
        if (j>=0)
            this.libros.remove(j);
        else
            System.out.println("EL LIBRO NO SE ENCUENTRA CARGADO EN LA LISTA, NO SE PUEDE CARGAR");
    }
    public int cantidadLibros(){
        return this.libros.size();
    }
    public boolean existeLibro(Libro libro){
        int j=this.libros.size()-1;
        while (j>=0&&!this.libros.get(j).equals(libro))
            j--;
        return j>=0;
    }
    public boolean estaLlena(){
        return this.libros.size()==this.cantidad;
    }
    public boolean hayLibros(){
        return !this.libros.isEmpty();
    }
    public Libro recuperarLibro(String codigo){
        int j=this.libros.size()-1;
        while (j>=0&&!this.libros.get(j).equals(codigo))
            j--;
        if(j>=0)
            return libros.get(j);
        else{
            System.out.println("LIBRO NO ENCONTRADO");
            return null;
        }
    }
    public Libro recuperarLibro(int i){
        if(i>=0&&i<this.libros.size())
            return this.libros.get(i);
        else
            return null;
    }
    public TablaLibros librosAutor(String nombre){
        TablaLibros librosXautor= new TablaLibros(this.cantidad);
        for(int i=0;i<this.libros.size();i++){
            if(this.libros.get(i).getAutor().getNombre().equals(nombre)){
                librosXautor.libros.add(this.libros.get(i));
            }
        }
        if(librosXautor.libros.isEmpty()){
            System.out.println("NO HAY LIBROS REGISTRADOS DE ESE AUTOR ");
            return null; //podria retornarse la lista vacia tambien??
        }
        else
            return librosXautor;
    }
}
