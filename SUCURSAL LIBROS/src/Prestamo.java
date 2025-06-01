public class Prestamo {
    private Libro libro;
    private Sucursal destino;
    private Fecha fchDevolucion;
    public Prestamo(Libro l,Sucursal destino,Fecha dev){
        this.libro=libro;
        this.destino=destino;
        this.fchDevolucion=dev;
    }
    public Libro getLibro() {
        return libro;
    }
}
