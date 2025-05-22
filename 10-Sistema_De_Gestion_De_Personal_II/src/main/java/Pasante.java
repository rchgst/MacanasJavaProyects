public class Pasante extends Empleado {
  private int diasTrabajados;

  public int getDiasTrabajados() {
    return this.diasTrabajados;
  }

  public void setDiasTrabajados(int diasTrabajados) {
    this.diasTrabajados = diasTrabajados;
  }

  public Pasante() {
  }

  public Pasante(String nombreCompleto, int dni, String direccion, String telefono, double salario, Empleado supervisor,
      int diasTrabajados) {
    super(nombreCompleto, dni, direccion, telefono, salario, supervisor);
    this.diasTrabajados = diasTrabajados;
  }

  public Pasante(String nombreCompleto, int dni, String direccion, String telefono, double salario,
      Empleado supervisor) {
    super(nombreCompleto, dni, direccion, telefono, salario, supervisor);
  }

  @Override
  public String toString() {
    String cadena = super.toString() + "\nDias trabajados: " + this.diasTrabajados;
    return cadena;
  }

  @Override
  public void incrementarSalario() {
    double aumento = ((getSalarioMensual() * 12) * 0.0005);
    setSalarioMensual(getSalarioMensual() + aumento);
  }
}
