public class Libro {
    private String codigo;
    private String titulo;
    private Autor autor;
    private Fecha fchPublicacion;
    private Fecha fchIngreso;

    public boolean equals(Libro otro) {
       String cod1=this.codigo;
       String cod2= otro.codigo;
       return cod1.equals(cod2);
    }
    public boolean equals(String cod){
        return this.codigo.equals(cod);
    }

    public Autor getAutor() {
        return autor;
    }
    public double montoAsegurado(){
        return 0.0;
    }
    public Fecha getFchPublicacion(){
        return this.fchPublicacion;
    }
    public double getPeso(){
        return 0;
    }
}
