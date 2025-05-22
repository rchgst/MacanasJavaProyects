import java.util.ArrayList;

public class SistemaDeGestion {
  private ArrayList<Empleado> empleados;

  // Este metodo es para poder realizar las pruebas
  public void cargarLista() {
    Coche coche1 = new Coche("AEB207AE", "Volkswagen", "Gol");
    Vendedor e1 = new Vendedor("Mario Revolt", 31448932, "Barrio Olivos Mza. 24", "459483999", 2, 5000, coche1,
        "3874103938");
    Coche coche2 = new Coche("AEB207AE", "Volkswagen", "Amarok");
    Vendedor e2 = new Vendedor("Alejandra Dorian", 42704883, "Villa Esperanza, Mar Arabigo 14", "55993284", 1, 2500, e1,
        coche2, "3876554990");
    Secretario e3 = new Secretario("Sofia Martinez", 35799103, "Barrio Rosales, Av. Castañeda 703", "543702333", 5,
        3500, "Despacho 3", "48377");
    Pasante e4 = new Pasante("Benjamin Reyes", 44703998, "Barrio Los Sauces, Mza. 5", "55702889", 500, e2);
    this.empleados.add(e1);
    this.empleados.add(e2);
    this.empleados.add(e3);
    this.empleados.add(e4);
  }

  public SistemaDeGestion() {
    this.empleados = new ArrayList<>();
  }

  public void mostrarLista() {
    for (Empleado empleado : this.empleados) {
      System.out.println(empleado);
    }
  }

  public void aumentarSalarios() {
    for (Empleado empleado : this.empleados) {
      empleado.incrementarSalario();
    }
    System.out.println("Se aplicaron los aumentos correspondientes!");
  }

  public static void main(String[] args) {
    SistemaDeGestion sis = new SistemaDeGestion();
    sis.cargarLista();
    sis.mostrarLista();
    sis.aumentarSalarios();
    sis.mostrarLista();
  }
}
