public class Libro {
  private String codigo;
  private String titulo;
  private Autor autor;
  private Fecha fchPublicacion;
  private Fecha fchIngreso;

  public String getCodigo() {
    return this.codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public String getTitulo() {
    return this.titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public Autor getAutor() {
    return this.autor;
  }

  public void setAutor(Autor autor) {
    this.autor = autor;
  }

  public Fecha getFchPublicacion() {
    return this.fchPublicacion;
  }

  public void setFchPublicacion(Fecha fchPublicacion) {
    this.fchPublicacion = fchPublicacion;
  }

  public Fecha getFchIngreso() {
    return this.fchIngreso;
  }

  public void setFchIngreso(Fecha fchIngreso) {
    this.fchIngreso = fchIngreso;
  }

  public Libro() {
  }

  public Libro(String codigo, String titulo, Autor autor, Fecha fchPublicacion) {
    this.codigo = codigo;
    this.titulo = titulo;
    this.autor = autor;
    this.fchPublicacion = fchPublicacion;
  }

  public Libro(String codigo, String titulo, Autor autor, Fecha fchPublicacion, Fecha fchIngreso) {
    this(codigo, titulo, autor, fchPublicacion);
    this.fchIngreso = fchIngreso;
  }

  @Override
  public String toString() {
    String cadena = "=== Libro ===\nCodigo: " + this.codigo + "\nTitulo: " + this.titulo + "\n" + autor
        + "\nFecha de Publicacion: " + this.fchPublicacion + "\nFecha de Ingreso: " + this.fchIngreso + "\n";
    return cadena;
  }

  public boolean equals(Libro otro) {
    return this.codigo.equals(otro.getCodigo());
  }

  public double montoAsegurado() {
    return 0;
  }
}
