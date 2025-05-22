public class Empleado {
  private String nombreCompleto;
  private int dni;
  private String direccion;
  private String telefono;
  private int añosAntiguedad;
  private double salario;
  private Empleado supervisor;

  public String getNombreCompleto() {
    return this.nombreCompleto;
  }

  public void setNombreCompleto(String nombreCompleto) {
    this.nombreCompleto = nombreCompleto;
  }

  public int getDni() {
    return this.dni;
  }

  public void setDni(int dni) {
    this.dni = dni;
  }

  public String getDireccion() {
    return this.direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public String getTelefono() {
    return this.telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public int getAñosAntiguedad() {
    return this.añosAntiguedad;
  }

  public void setAñosAntiguedad(int añosAntiguedad) {
    this.añosAntiguedad = añosAntiguedad;
  }

  public double getSalario() {
    return this.salario;
  }

  public void setSalario(double salario) {
    this.salario = salario;
  }

  public Empleado getSupervisor() {
    return this.supervisor;
  }

  public void setSupervisor(Empleado supervisor) {
    this.supervisor = supervisor;
  }

  public Empleado() {
  }

  public Empleado(String nombreCompleto) {
    this.nombreCompleto = nombreCompleto;
  }

  public Empleado(String nombreCompleto, int dni, String direccion, String telefono, int añosAntiguedad,
      double salario) {
    this.nombreCompleto = nombreCompleto;
    this.dni = dni;
    this.direccion = direccion;
    this.telefono = telefono;
    this.añosAntiguedad = añosAntiguedad;
    this.salario = salario;
  }

  public Empleado(String nombreCompleto, int dni, String direccion, String telefono, int añosAntiguedad, double salario,
      Empleado supervisor) {
    this.nombreCompleto = nombreCompleto;
    this.dni = dni;
    this.direccion = direccion;
    this.telefono = telefono;
    this.añosAntiguedad = añosAntiguedad;
    this.salario = salario;
    this.supervisor = supervisor;
  }

  public Empleado(String nombreCompleto, int dni, String direccion, String telefono, double salario,
      Empleado supervisor) {
    this.nombreCompleto = nombreCompleto;
    this.dni = dni;
    this.direccion = direccion;
    this.telefono = telefono;
    this.salario = salario;
    this.supervisor = supervisor;
  }

  @Override
  public String toString() {
    String cadena = "Empleado \nNombre Completo: " + this.nombreCompleto + "\nDni: " + this.dni + "\nDireccion: "
        + this.direccion + "\nTelefono: " + this.telefono + "\nAños de antiguedad: " + this.añosAntiguedad
        + "\nSalario: " + this.salario;
    if (this.supervisor != null) {
      cadena += "\nSupervisor: " + this.supervisor.getNombreCompleto();
    }
    return cadena;
  }

}
