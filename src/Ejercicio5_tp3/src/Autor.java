public class Autor {
    private String nombre,nacionalidad;
    private Fecha fchNac,fchFall;

    public Autor(String nombre,String nacionalidad,Fecha fchNac,Fecha fchFall){
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.fchNac = fchNac;
        this.fchFall = fchFall;
    }

    public boolean igual(Autor autor){
        return this.nombre.equals(autor.nombre);
    }

    public boolean igual(String nombre){
        return this.nombre.equals(nombre);
    }

    public boolean igualNac(String nacionalidad){
        return this.nacionalidad.equals(nacionalidad);
    }

    public String getNombre(){
        return nombre;
    }

}
