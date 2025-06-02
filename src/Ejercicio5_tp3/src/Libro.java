public class Libro {
    private String codigo;
    private String titulo;
    private Autor autor;
    private Fecha fchPublicacion;
    private Fecha fchIngreso;

    public Libro(String codigo,String titulo, Autor autor,Fecha fchPublicacion,Fecha fchIngreso){
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.fchPublicacion = fchPublicacion;
        this.fchIngreso = fchIngreso;
    }

    public boolean igual(Libro otro){
        return this.codigo.equals(otro.codigo);
    }

    public boolean igual(String codigo){
        return this.codigo.equals(codigo);
    }

    public boolean igualAutor(String nombre){
        return nombre.equals(nombre);
    }

    public Autor getAutor(){
        return autor;
    }

    public Fecha getFchPublicacion(){
        return fchPublicacion;
    }

    public double montoAsegurado(){
        return 0;
    }

    public double getPeso(){
        return 0;
    }

}
