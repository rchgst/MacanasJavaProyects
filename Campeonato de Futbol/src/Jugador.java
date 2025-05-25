import java.time.LocalDate;

public class Jugador {
    private int dni;
    private String nombre;
    private Fecha fechaNac;

    public Jugador(int dni,String nombre,Fecha fecha){
        this.dni=dni;
        this.fechaNac=fecha;
        this.nombre=nombre;
    }
    public Jugador(int dni,String nombre){
        this.dni=dni;
        this.fechaNac = new Fecha();
        this.nombre=nombre;
    }

    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public Fecha getFechaNac() {
        return fechaNac;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaNac(Fecha fechaNac) {
        this.fechaNac = fechaNac;
    }

    @Override
    public String toString() {
        String cadena="";
        cadena += "Nombre: " + this.nombre + "\n"+ "DNI: " + this.dni+ "\n"+ "Fecha de Nacimiento: "+ this.fechaNac.toString()+"\n";
        return cadena;
    }
    @Override
    public boolean equals(Object obj) {
        if(this==obj )return true;
        if(!(obj instanceof Jugador))return false;
        Jugador otro = (Jugador) obj;
        return this.dni==otro.dni;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(dni);
    }
}
