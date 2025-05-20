import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Paciente extends Persona{
    private ObraSocial obraSocial;

    public Paciente(int dni,String nombre,char sexo,Fecha fchNac,ObraSocial obraSocial){
        super(dni,nombre,sexo,fchNac);
        this.obraSocial = obraSocial;
    }

    public boolean esIgual(Paciente otro){
        return this.obraSocial == otro.obraSocial;
    }

    public int edad(){
        Fecha act = new Fecha();
        return (int) ChronoUnit.YEARS.between(this.fchNac.fecha,act.fecha);
    }

    public ObraSocial getObraSocial() {
        return this.obraSocial;
    }
}
