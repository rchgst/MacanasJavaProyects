import java.util.ArrayList;
import java.util.Random;

public class Reproductor {
    private ArrayList<Cancion> lista;

    public Reproductor(){
        this.lista=new ArrayList<Cancion>();
    }
    public Reproductor(ArrayList<Cancion> lista){
        this.lista=lista;
    }
    public void repSec(){
        if(this.lista.isEmpty()){
            System.out.println("ERROR, LISTA VACIA");
            return;
        }
        for(int i=0;i<this.lista.size();i++) {
            System.out.println("REPRODUCIENDO CANCION "+this.lista.get(i).getNombre());
            this.lista.get(i).getAudio().play();
        }
    }
    public void repAleat(){
        if(this.lista.isEmpty()){
            System.out.println("ERROR, LISTA VACIA");
            return;
        }
        Random rnd = new Random();
        ArrayList<Integer> cancionesSinRep= new ArrayList<Integer>(this.lista.size());
        for(int i=0;i<this.lista.size();i++)
            cancionesSinRep.add(i);
        while (!cancionesSinRep.isEmpty()){
            int indice= rnd.nextInt(cancionesSinRep.size());
            int pos =cancionesSinRep.get(indice);
            System.out.println("REPRODUCIENDO CANCION "+this.lista.get(pos).getNombre());
            this.lista.get(pos).getAudio().play();
            cancionesSinRep.remove(indice);
            }
        System.out.println("SIN MAS CANCIONES PARA REPRODUCIR");
        }
    public void repXGen(String genero){
        if(this.lista.isEmpty()){
            System.out.println("ERROR, LISTA VACIA");
            return;
        }
        boolean existe = false;
        for (int i=0;i<this.lista.size();i++){
            if(this.lista.get(i).getGenero().equals(genero)){
                existe=true;
                System.out.println("REPRODUCIENDO CANCION "+this.lista.get(i).getNombre());
                this.lista.get(i).getAudio().play();
            }
        }
        if(!existe)
            System.out.println("NO HAY CANCIONES CON ESE GENERO EN LA LISTA");
    }
}


