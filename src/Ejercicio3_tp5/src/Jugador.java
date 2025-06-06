import java.time.LocalDate;

public abstract class Jugador extends Persona{
    private String idJugador;
    protected LocalDate fchInicio;

    public Jugador(String nombre,String apellido,int edad,String idJugador,LocalDate fchInicio){
        super(nombre,apellido,edad);
        this.idJugador = idJugador;
        this.fchInicio = fchInicio;
    }

    public void setIdJugador(String idJugador) {
        this.idJugador = idJugador;
    }

    public String getIdJugador() {
        return idJugador;
    }

    public abstract double importaNomina(LocalDate hasta);

    public String toString(){
        return super.toString()+" id jugador: "+idJugador+" fecha de inicio: "+fchInicio;
    }
}
