public class Candidatos extends Persona{
    public int CantidadDeVotos;
    public Candidatos(){
        super();
        this.CantidadDeVotos=0;
    }
    public Candidatos(String NombreCompleto, String Documento, int CantidadDeVotos){
        super(NombreCompleto,Documento);
        this.CantidadDeVotos=CantidadDeVotos;
    }
    public void SetCantidadDebVotos(int CantidadDeVotos){
        this.CantidadDeVotos=CantidadDeVotos;
    }
    public int GetCantidadDeVotos(){
        return this.CantidadDeVotos;
    }
    
    @Override
    public String toString(){
        return super.toString()+"\nCantidad de Votos: "+this.CantidadDeVotos;
    }
}
