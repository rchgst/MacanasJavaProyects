public class Paciente extends Persona{
    private ObraSocial obraSocial;

    public boolean esIgual(Paciente otro){
        return this.dni==otro.dni;
    }
    public int edad(){
        Fecha actual = new Fecha();
       return this.fchNac.diferenciaAnios(actual);
    }
    public ObraSocial getObraSocial(){
        return this.obraSocial;
    }
}
