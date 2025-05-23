import java.util.Date;
public class Paciente{
    protected String nombre;
    protected int Documento;
    protected String Domicilio;
    protected String Telefono;
    protected Date FechaNacimiento;

    public Paciente(){
        this.nombre="";
        this.Documento=0;
        this.Domicilio="";
        this.Telefono="";
        this.FechaNacimiento=new Date();
    }

    public Paciente(String nombre, int documento, String Domicilio, String Telefono, Date FechaNaciemiento){
        this();
        this.nombre=nombre;
        this.Documento=documento;
        this.Domicilio=Domicilio;
        this.Telefono=Telefono;
        this.FechaNacimiento=FechaNaciemiento;
    }
    public String toString (){
        return "Nombre: \n "+this.nombre+"Documento: \n "+this.Documento+"Domicilio: \n" +this.Domicilio+"Telefono: \n"+this.Telefono+"Fecha de nacimiento: \n"+this.FechaNacimiento;
    }

public class Ambulatorio extends Paciente{
    private String Observaciones;
    
    public Ambulatorio(){
        super();
        this.Observaciones="";
    }
    public Ambulatorio(String Nombre, int Documento, String Domicilio, String Telefono, Date FechaNaciemiento,String Observaciones){
        super(Nombre,Documento,Domicilio,Telefono,FechaNaciemiento);
        this.Observaciones=Observaciones;
    }
    public String toString(){
        return super.toString()+"Observaciones: \n"+this.Observaciones;
    }

}
public class Internado extends Paciente{
    public Date FechadAlta;
    
    public Internado(){
        super();
        this.FechadAlta=new Date();
    }
    public Internado(String Nombre, int Documento, String Domicilio, String Telefono, Date FechaNaciemiento, Date FechadAlta){
        super(Nombre,Documento,Domicilio,Telefono,FechaNaciemiento);
        this.FechadAlta=FechadAlta;
    }
    public String toString(){
        return super.toString()+"\n Fecha de alta"+this.FechadAlta;
    }

}
}


