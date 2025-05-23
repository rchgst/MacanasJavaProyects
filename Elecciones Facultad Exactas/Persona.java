public class Persona {
   protected String NombreCompleto;
   protected String Documento;
   protected boolean AptoParaVotar;
    public Persona(){
        this.NombreCompleto="";
        this.Documento="";
        this.AptoParaVotar=false;
    }
    public Persona(String Nombre, String Documento){
        this.NombreCompleto=Nombre;
        this.Documento=Documento;
        
      
    }
    public String GetNombreCompleto(){
        return this.NombreCompleto;
    }
    public String GetDocumento(){
        return this.Documento;
    }
    public boolean esAptoParaVotar(){
        if(this.AptoParaVotar==true){
            return true;
        }
        else{
            return false;
        }
    }
    public String toString(){
        return "\n Nombre Completo:"+this.NombreCompleto+"\n Numero de Documento Nacional:"+this.Documento;
    }
    public String DevolverNegativa(){
        String Texto="No es apto para votar";
        if(this.AptoParaVotar==false){
            return Texto;
        }
        return "";
    }
}