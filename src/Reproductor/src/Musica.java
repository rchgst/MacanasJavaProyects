public class Musica {
    private String genero;

    public Musica(String genero){
        this.genero = genero;
    }

    public String toString(){
        return genero;
    }

    public boolean igualGenero(String genero){
        return this.genero.equals(genero);
    }

}
