public class Autor {
    private String nombre;
    private String nacionalidad;
    private Fecha fchNac;
    private Fecha fchFall;

    public Autor(String nombre,String nacionalidad,Fecha fchNac, Fecha fchFall){
        this.nombre=nombre;
        this.nacionalidad=nacionalidad;
        this.fchNac=fchNac;
        this.fchFall=fchFall;
    }
    public String getNombre() {
        return this.nombre;
    }
    public String getNacionalidad(){
        return this.nacionalidad;
    }
}
