public class Secretario extends Empleado {
  private String despacho;
  private String numeroFax;

  public String getDespacho() {
    return this.despacho;
  }

  public void setDespacho(String despacho) {
    this.despacho = despacho;
  }

  public String getNumeroFax() {
    return this.numeroFax;
  }

  public void setNumeroFax(String numeroFax) {
    this.numeroFax = numeroFax;
  }

  public Secretario(String nombreCompleto, int dni, String direccion, String telefono, int añosAntiguedad,
      double salario, Empleado supervisor, String despacho, String numeroFax) {
    super(nombreCompleto, dni, direccion, telefono, añosAntiguedad, salario, supervisor);
    this.despacho = despacho;
    this.numeroFax = numeroFax;
  }

  public Secretario(String nombreCompleto, int dni, String direccion, String telefono, int añosAntiguedad,
      double salario, String despacho, String numeroFax) {
    super(nombreCompleto, dni, direccion, telefono, añosAntiguedad, salario);
    this.despacho = despacho;
    this.numeroFax = numeroFax;
  }

  public Secretario() {
  }

  @Override
  public String toString() {
    String cadena = super.toString() + "\nDespacho: " + this.despacho + "\nNumero de fax: " + this.numeroFax;
    return cadena;
  }

}
