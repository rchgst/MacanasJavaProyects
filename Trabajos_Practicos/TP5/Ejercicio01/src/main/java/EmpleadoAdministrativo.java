public class EmpleadoAdministrativo extends Empleado {
  private double comision;

  public double getComision() {
    return this.comision;
  }

  public void setComision(double comision) {
    this.comision = comision;
  }

  public EmpleadoAdministrativo(String nombre, String apellido, int edad, double salario) {
    super(nombre, apellido, edad, salario);
  }

  @Override
  public boolean plus(double sueldoPlus) {
    if (this.comision < 2000) {
      this.salario += sueldoPlus;
      return true;
    }
    return false;
  }

  @Override
  public String imprimir() {
    String cadena = "Nombre: " + this.nombre + "\tApellido: " + this.apellido + "\nEdad: " + this.edad + "\nSalario: "
        + this.salario + "\nComision: " + this.comision;
    return cadena;
  }
}
