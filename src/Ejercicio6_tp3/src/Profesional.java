public class Profesional extends  Persona{
    private int matricula;

    public Profesional(int dni,String nombre,char sexo,Fecha fchNac,int matricula){
        super(dni,nombre,sexo,fchNac);
        this.matricula = matricula;
    }
}
