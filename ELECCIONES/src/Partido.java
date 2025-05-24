public class Partido {
    private int numId;
    private int cantVotos;
    public Partido(int numId){
        this.numId=numId;
        this.cantVotos=0;
    }

    public void setCantVotos(int votos) {
        this.cantVotos +=votos;
    }
    public int getNumId(){
        return this.numId;
    }
    public int getCantVotos(){
        return this.cantVotos;
    }

}
