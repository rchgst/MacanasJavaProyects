import java.util.ArrayList;

public class TablaLibros {
    private ArrayList<Libro> libros;
    private int cantidad;

    public TablaLibros(ArrayList<Libro> libros,int cantidad){
        this.libros = libros;
        this.cantidad = cantidad;
    }

    public TablaLibros(){
        this.libros = new ArrayList<>(0);
        this.cantidad = 0;
    }

    public void insertarLibro(Libro libro){
        this.libros.add(libro);
    }

    public void eliminarLibro(Libro libro){
        int i,pos;
        i=pos=0;
        while (i<cantidad) {
            if (this.libros.get(i).igual(libro)){
                pos=libros.indexOf(libro);
                libros.remove(pos);
                cantidad--;
            }
        }
        if(pos==0)
            System.out.println("no se encontro el libro en la lista, no hubo eliminacion");
    }

    public int cantidadLibros(){
        return cantidad;
    }

    public boolean existeLibro(Libro libro){
        int i=0;
        while (i<cantidad && libros.get(i).igual(libro)==false)
            i++;
        if(i<cantidad)
            return true;
        return false;
    }

    public boolean hayLibros(){
        return cantidad>0;
    }

    public Libro recuperarLibro(String codigo){
        for (int i=0;i<cantidad;i++){
            if(libros.get(i).igual(codigo))
                return libros.get(i);
        }
        return null;
    }

    public TablaLibros librosAutor(String nombre){
        TablaLibros autorLibros = new TablaLibros();
        for(int i=0;i<cantidad;i++){
            if(libros.get(i).igualAutor(nombre)){
                autorLibros.insertarLibro(libros.get(i));
                autorLibros.cantidad++;
            }
        }
        return autorLibros;
    }

    public Libro getLibro(int pos){
        return libros.get(pos);
    }

}
