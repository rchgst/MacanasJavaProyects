public class Vendedor extends Empleado {
  private Coche cocheEmpresa;
  private String telefonoMovil;

  public Coche getCocheEmpresa() {
    return this.cocheEmpresa;
  }

  public void setCocheEmpresa(Coche cocheEmpresa) {
    this.cocheEmpresa = cocheEmpresa;
  }

  public String getTelefonoMovil() {
    return this.telefonoMovil;
  }

  public void setTelefonoMovil(String telefonoMovil) {
    this.telefonoMovil = telefonoMovil;
  }

  public Vendedor() {
    this.cocheEmpresa = new Coche();
  }

  public Vendedor(String nombreCompleto, int dni, String direccion, String telefono, int añosAntiguedad, double salario,
      Empleado supervisor, Coche cocheEmpresa, String telefonoMovil) {
    super(nombreCompleto, dni, direccion, telefono, añosAntiguedad, salario, supervisor);
    this.cocheEmpresa = cocheEmpresa;
    this.telefonoMovil = telefonoMovil;
  }

  public Vendedor(String nombreCompleto, int dni, String direccion, String telefono, int añosAntiguedad, double salario,
      Coche cocheEmpresa, String telefonoMovil) {
    super(nombreCompleto, dni, direccion, telefono, añosAntiguedad, salario);
    this.cocheEmpresa = cocheEmpresa;
    this.telefonoMovil = telefonoMovil;
  }

  @Override
  public String toString() {
    String cadena = super.toString() + "\nTelefono Movil: " + this.telefonoMovil;
    if (this.cocheEmpresa != null) {
      cadena += "\n" + cocheEmpresa.toString();
    }
    return cadena;
  }

}
