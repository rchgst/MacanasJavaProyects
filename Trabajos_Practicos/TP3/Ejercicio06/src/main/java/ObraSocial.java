public class ObraSocial {
  private int cuit;
  private String denominacion;
  private String domicilio;

  public int getCuit() {
    return this.cuit;
  }

  public void setCuit(int cuit) {
    this.cuit = cuit;
  }

  public String getDenominacion() {
    return this.denominacion;
  }

  public void setDenominacion(String denominacion) {
    this.denominacion = denominacion;
  }

  public String getDomicilio() {
    return this.domicilio;
  }

  public void setDomicilio(String domicilio) {
    this.domicilio = domicilio;
  }

  public ObraSocial(int cuit, String denominacion, String domicilio) {
    this.cuit = cuit;
    this.denominacion = denominacion;
    this.domicilio = domicilio;
  }

  public ObraSocial() {
  }

  @Override
  public String toString() {
    return "ObraSocial [Cuit: " + this.cuit + ", Denominacion: " + this.denominacion + ", Domicilio: " + this.domicilio
        + "]";
  }

}
