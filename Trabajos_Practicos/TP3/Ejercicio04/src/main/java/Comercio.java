import java.util.Scanner;

public class Comercio {
  private CajaRegistradora[] cajas;

  public Comercio() {
    this.cajas = new CajaRegistradora[3];
    for (int i = 0; i < this.cajas.length; i++) {
      cajas[i] = new CajaRegistradora();
    }
  }

  public static void main(String[] args) {
    new Comercio().go();
  }

  public void go() {
    int idCaja = 0;
    Scanner scanner = new Scanner(System.in);
    Movimiento mov = new Movimiento();
    System.out.print("Ingrese el numero de la caja: ");
    idCaja = Integer.parseInt(scanner.nextLine());
    // Supongo que el usuario sera perfecto
    while (idCaja != 0) {
      mov.setIdCaja(idCaja);
      System.out.print("Ingrese el monto del movimiento: ");
      mov.setImporte(Double.parseDouble(scanner.nextLine()));
      this.cajas[mov.getIdCaja() - 1].agregarMovimiento(mov);
      mov = new Movimiento();
      System.out.print("Ingrese el numero de la caja: ");
      idCaja = Integer.parseInt(scanner.nextLine());
    }
    System.out.println("Ya ha finalizado el día!");
    System.out.println();
  }

  public void totalRecaudacion() {
    double total = 0;
    for (int i = 0; i < this.cajas.length; i++) {
      total += this.cajas[i].getRecaudacion();
    }
    System.out.println("Se recaudo: $" + total);
  }

  public void cajaConMenorImporte() {
    double menorRecaudacion = this.cajas[0].getRecaudacion();
    int cajaConMenorRecaudacion = 1;
    for (int i = 1; i < this.cajas.length; i++) {
      if (this.cajas[i].getRecaudacion() < menorRecaudacion) {
        cajaConMenorRecaudacion = i + 1;
        menorRecaudacion = this.cajas[i].getRecaudacion();
      }
    }
    System.out.println("La caja " + cajaConMenorRecaudacion + " fue la que tuvo menos recaudacion.");
  }

  public void mostrarTotalDeCadaCaja() {
    for (int i = 0; i < this.cajas.length; i++) {
      System.out.println("Total de la caja " + i + ": $" + this.cajas[i].getRecaudacion());
    }
  }
}
