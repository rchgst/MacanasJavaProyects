public class Personal extends Persona{
    public String PuestoTrabajo;
    public boolean  AptoParaVotar;

    public Personal(){
        super();
        this.PuestoTrabajo="";
        this.AptoParaVotar=false;

    }
    public Personal(String Nombre, String Documento, String PuestoTrabajo){
        super(Nombre,Documento);
        this.PuestoTrabajo=PuestoTrabajo;
       
    
    }
    public String toString(){
        String Ficha="Datos de Personal de Trabajo:\n";
        Ficha+="Puesto de trabajo de la persona: "+this.PuestoTrabajo;
        return Ficha;
    }
}