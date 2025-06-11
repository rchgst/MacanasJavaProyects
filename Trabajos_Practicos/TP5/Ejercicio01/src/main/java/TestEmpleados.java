public class TestEmpleados {
  public static void main(String[] args) {
    EmpleadoComercial eComercial = new EmpleadoComercial("Juan", "De la Sierra", 28, 1000);
    EmpleadoAdministrativo eAdministrativo = new EmpleadoAdministrativo("Maira", "Duran", 42, 1800);
    eComercial.setComision(588.99);
    eAdministrativo.setComision(2200);
    System.out.println(eComercial.imprimir());
    System.out.println(eAdministrativo.imprimir());
    if (eComercial.plus(500)) {
      System.out.println("El empleado de comercio ha recibido un plus!");
      System.out.println(eComercial.imprimir());
    }
    if (eAdministrativo.plus(500)) {
      System.out.println("El empleado administrativo ha recibido un plus!");
      System.out.println(eAdministrativo.imprimir());
    }
  }
}
