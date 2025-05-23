public class Alumno extends Persona{
    public int LU;
    public int MateriasFinalizadas;
   
    public boolean AptoParaVotar;

    public Alumno(){
        super();
        this.LU=0;
        this.MateriasFinalizadas=0;
        this.AptoParaVotar=false;
    }
    public Alumno(String NombreCompleto, String Documento,int LU, int MateriasFinalizadas, boolean AptoParaVotar){
        super(NombreCompleto,Documento);
        this.LU=LU;
        this.MateriasFinalizadas=MateriasFinalizadas;
        this.AptoParaVotar=AptoParaVotar;
   
        
    }
    public int GetCantidadMaterias(){
        return this.MateriasFinalizadas;
    }
    @Override
    public boolean esAptoParaVotar(){
        if(this.MateriasFinalizadas>=3){
            return true;
        }
        else{
            return false;
        }
    }
    @Override
    public String toString(){ 
        return  super.toString()+"\nLibreta Universitaria:"+this.LU+"\nCantidad de Materias Finalizadas recientemente: "+this.MateriasFinalizadas;
        }
    @Override
    public String DevolverNegativa(){ 
        if(this.AptoParaVotar==false){
            return super.DevolverNegativa()+"\nNo es apto para votar porque no tiene materias aprobadas";   
        }
            return "";
    }
}

