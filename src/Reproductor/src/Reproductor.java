import java.util.ArrayList;
import java.util.Random;

public class Reproductor {
    ArrayList<Musica> musicas;

    public Reproductor(ArrayList<Musica> musicas){
        this.musicas = musicas;
    }

    public void secuencial(){
        for(int i=0;i<musicas.size();i++) {
            System.out.println("reproduciendo cancion de genero: "+ musicas.get(i));
        }
    }

    public void playGenero(String genero){
        for (int i=0;i<musicas.size();i++){
            if(musicas.get(i).igualGenero(genero))
                System.out.println("reproduciondo cancion numero: "+i);
        }
    }

    public ArrayList<Musica> copiaPlaylist(){
        return new ArrayList<>(musicas);
    }

    public void aleatorio(){
        ArrayList<Musica> aux = this.copiaPlaylist();
        Random random = new Random();
        for (int i=0;i<musicas.size();i++){
            int indRand = random.nextInt(0,aux.size());
            System.out.println("esta sonando la cancion numero: "+indRand);
            aux.remove(indRand);
        }
    }
}
