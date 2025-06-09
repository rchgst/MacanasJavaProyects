public abstract class Jugador extends Persona {
    private String idJugador;
    protected Fecha fchInicio;

    public Jugador(String nombre,String apellido,int edad,String idJugador,Fecha fchInicio){
        super(nombre,apellido,edad);
        this.idJugador=idJugador;
        this.fchInicio=fchInicio;
    }

    public void setIdJugador(String idJugador) {
        this.idJugador = idJugador;
    }

    public String getIdJugador() {
        return this.idJugador;
    }
    public abstract double importeNominal(Fecha hasta);

    @Override
    public String toString() {
        return super.toString()+"\nID JUGADOR: "+getIdJugador()+"\nFECHA DE INICIO DE CONTRATO: "+fchInicio;
    }
}
