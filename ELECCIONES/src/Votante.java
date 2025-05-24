public class Votante {
    protected String nombre;
    protected long dni;

    public Votante(String nombre,long dni){
        this.nombre=nombre;
        this.dni=dni;
    }
    public boolean puedeVotar(){
        return false;
    }
    public String getNombre(){
        return this.nombre;
    }
    public long getDni(){
        return this.dni;
    }
    public void votar(Partido electo){
        electo.setCantVotos(3);
    }
    public void consultarVotante(Votante A) {
        if (A.puedeVotar())
            System.out.println("\nLa persona puede votar");
        else {
            if (A instanceof Alumno)
                System.out.println("\nEl alumno "+A.getNombre()+ " no puede votar, no cuenta con el minimo de materias aprobadas en el ultimo año");
            else
                System.out.println("El docente "+A.getNombre()+" no puede votar, no posee cargo regular en ninguna asignatura.");
        }
    }
    @Override
    public String toString() {
        return "Votante: "+this.nombre+". DNI: "+ this.dni;
    }
}
