public class Prestamo {
    private Libro libro;
    private Fecha fchDevolucion;
    private Sucursal destino;

    public Prestamo(Libro libro,Fecha fchDevolucion,Sucursal destino){
        this.libro = libro;
        this.fchDevolucion = fchDevolucion;
        this.destino = destino;
    }

    public Libro getLibro(){
        return libro;
    }
}
