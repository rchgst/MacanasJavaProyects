import java.util.ArrayList;

public class TablaAutores {
    private ArrayList<Autor> autores;
    private int cantidad;


    public TablaAutores(ArrayList<Autor> autores,int cantidad){
        this.autores = autores;
        this.cantidad = cantidad;
    }

    public TablaAutores(){
        this.autores = new ArrayList<>(0);
        this.cantidad = 0;
    }

    public void insertarAutor(Autor autor){
        autores.add(autor);
    }

    public int cantidadAutores(){
        return cantidad;
    }

    public boolean estaAutor(Autor autor){
        int i=0;
        while (i<cantidad && autores.get(i).igual(autor)==false)
            i++;
        if(i<cantidad)
            return true;
        return false;
    }

    public boolean hayAutores(){
        return cantidad>0;
    }

    public Autor recuperarAutor(int pos){
        return autores.get(pos);
    }

    public Autor recuperarAutor(String nombre){
        for (int i=0;i<cantidad;i++){
            if(autores.get(i).igual(nombre))
                return autores.get(i);
        }
        return null;
    }

    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }

    public Autor getAutor(int pos){
        return autores.get(pos);
    }

    public TablaAutores autoresNac(String nac){
        TablaAutores nacAutores = new TablaAutores();
        for (int i=0;i<cantidad;i++){
            if(autores.get(i).igualNac(nac)){
                nacAutores.insertarAutor(autores.get(i));
                nacAutores.setCantidad(nacAutores.cantidadAutores()+1);
            }
        }
        return nacAutores;
    }

}
