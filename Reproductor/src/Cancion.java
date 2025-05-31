public class Cancion {
  //  private BasicPlayer audio;
    private String nombre;
    private String genero;
    private boolean reproducida;

    public Cancion(String nombre,String genero){
        this.nombre=nombre;
        this.genero=genero;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getGenero(){
        return this.genero;
    }
    public BasicPlayer getAudio(){
        return this.audio;
    }
}
