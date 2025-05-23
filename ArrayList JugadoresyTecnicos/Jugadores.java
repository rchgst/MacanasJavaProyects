public class Jugadores {
    protected String nombreAp;
    protected int Documento;
    protected String Fechanac;
    
    public Jugadores(){
        this.nombreAp="";
        this.Documento=0;
        this.Fechanac="";
    }
    public Jugadores(String nombreAp, int Documento, String Fechanac){
        this.nombreAp=nombreAp;
        this.Documento=Documento;
        this.Fechanac=Fechanac;
    }
    public Jugadores(String nombreAp, int Documento){
        this.nombreAp=nombreAp;
        this.Documento=Documento;
    }
    public String toString(){
        String Jugador="";
        if(this.Fechanac==null){
            Jugador+="\nNombre y Apellido: "+this.nombreAp+"\nDocumento:"+this.Documento;
        }
        else{
        Jugador+="\nNombre y Apellido: "+this.nombreAp+"\nDocumento:"+this.Documento+"\nFecha de nacimiento: "+this.Fechanac;}
        return Jugador;
    }
}
