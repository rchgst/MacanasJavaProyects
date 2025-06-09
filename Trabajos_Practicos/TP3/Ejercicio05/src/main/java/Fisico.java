public class Fisico extends Libro {
  private int paginas;
  private int peso;

  public int getPaginas() {
    return this.paginas;
  }

  public void setPaginas(int paginas) {
    this.paginas = paginas;
  }

  public int getPeso() {
    return this.peso;
  }

  public void setPeso(int peso) {
    this.peso = peso;
  }

  public Fisico() {
  }

  public Fisico(String codigo, String titulo, Autor autor, Fecha fchPublicacion, int paginas, int peso) {
    super(codigo, titulo, autor, fchPublicacion);
    this.paginas = paginas;
    this.peso = peso;
  }

  public Fisico(String codigo, String titulo, Autor autor, Fecha fchPublicacion, Fecha fchIngreso, int paginas,
      int peso) {
    super(codigo, titulo, autor, fchPublicacion, fchIngreso);
    this.paginas = paginas;
    this.peso = peso;
  }

  @Override
  public String toString() {
    String cadena = super.toString() + "Paginas: " + this.paginas + "\nPeso: " + this.peso + "\n";
    return cadena;
  }

  @Override
  public double montoAsegurado() {
    return (super.getFchIngreso().calcularAnio(new Fecha()) * 200) + (50 * this.peso);
  }
}
