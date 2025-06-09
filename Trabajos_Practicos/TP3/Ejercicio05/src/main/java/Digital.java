public class Digital extends Libro {
  private String formato;
  private double peso;

  public String getFormato() {
    return this.formato;
  }

  public void setFormato(String formato) {
    this.formato = formato;
  }

  public double getPeso() {
    return this.peso;
  }

  public void setPeso(double peso) {
    this.peso = peso;
  }

  public Digital() {
  }

  public Digital(String codigo, String titulo, Autor autor, Fecha fchPublicacion, String formato, double peso) {
    super(codigo, titulo, autor, fchPublicacion);
    this.formato = formato;
    this.peso = peso;
  }

  public Digital(String codigo, String titulo, Autor autor, Fecha fchPublicacion, Fecha fchIngreso, String formato,
      double peso) {
    super(codigo, titulo, autor, fchPublicacion, fchIngreso);
    this.formato = formato;
    this.peso = peso;
  }

  @Override
  public String toString() {
    String cadena = super.toString() + "Formato: " + this.formato + "\nPeso: " + this.peso + "\n";
    return cadena;
  }

  @Override
  public double montoAsegurado() {
    return super.getFchIngreso().calcularAnio(new Fecha()) * 100;
  }
}
