public class Prestamo {
  private Libro libro;
  private Sucursal destino;
  private Fecha fchDevolucion;

  public Libro getLibro() {
    return this.libro;
  }

  public void setLibro(Libro libro) {
    this.libro = libro;
  }

  public Sucursal getDestino() {
    return this.destino;
  }

  public void setDestino(Sucursal destino) {
    this.destino = destino;
  }

  public Fecha getFchDevolucion() {
    return this.fchDevolucion;
  }

  public void setFchDevolucion(Fecha fchDevolucion) {
    this.fchDevolucion = fchDevolucion;
  }

  public Prestamo(Libro libro, Sucursal destino, Fecha fchDevolucion) {
    this.libro = libro;
    this.destino = destino;
    this.fchDevolucion = fchDevolucion;
  }

  public Prestamo() {
  }

  @Override
  public String toString() {
    String cadena = "=== Prestamo ===\n" + this.libro + "\nDestino: " + this.destino + "\n Fecha de Devolucion: "
        + fchDevolucion + "\n";
    return cadena;
  }
}
