public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    public Persona(){
        this.nombre="";
        this.apellido="";
        this.edad=0;
    }
    public Persona(String n,String a,int e){
        this.nombre=n;
        this.apellido=a;
        this.edad=e;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public int getEdad() {
        return this.edad;
    }

    @Override
    public String toString() {
        return "JUGADOR: " +getNombre()+" "+getApellido()+" - EDAD: "+getEdad();
    }
}
