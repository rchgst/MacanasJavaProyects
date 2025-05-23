public class Docente extends Persona{
    public boolean DocenteRegular;    
    public String Materia;
    public Docente(){
        super();
        this.DocenteRegular=false;
        this.Materia="";
    }
    public Docente(String NombreCompleto, String Documento, boolean DocenteRegular,String Materia){
        super(NombreCompleto,Documento);
        this.DocenteRegular=DocenteRegular;
        this.Materia=Materia;
    }
    public boolean GetDocenteRegular(){
        return this.DocenteRegular;
    }
    public String toString(){
      return  super.toString()+"Docente de la materia: "+this.Materia;
    }
    @Override
    public boolean esAptoParaVotar(){
        if(this.DocenteRegular==true){
            return true;
        }
        else{
            return false;
        }
    }
    @Override
    public String DevolverNegativa(){
        if(this.DocenteRegular==false){
            return super.DevolverNegativa()+"\nNo es apto para votar porque no es docente regular";   
        }
        else{
            return "";
        }
    }
}

