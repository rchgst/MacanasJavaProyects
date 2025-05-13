import java.util.Scanner;

public class VentaSemanal {

  private double[] ventas;

  public VentaSemanal() {
    this.ventas = new double[7];
  }

  public VentaSemanal(int tam) {
    this.ventas = new double[tam];
  }

  public VentaSemanal(double[] ventas) {
    this.ventas = ventas;
  }

  public void cargarVentas() {
    Scanner scanner = new Scanner(System.in);
    for (int i = 0; i < this.ventas.length; i++) {
      System.out.print("Ingrese la venta del dia " + i + ": ");
      this.ventas[i] = Double.parseDouble(scanner.nextLine());
    }
  }

  public double totalVentaSemanal() {
    double total = 0;
    for (int i = 0; i < this.ventas.length; i++) {
      total += this.ventas[i];
    }
    return total;
  }

  public double promedioVentaSemanal() {
    return totalVentaSemanal() / this.ventas.length;
  }

  public String diaConMasVentas() {
    double mayorVenta = this.ventas[0];
    int dia = 1;
    for (int i = 1; i < this.ventas.length; i++) {
      if (this.ventas[i] > mayorVenta) {
        dia = i;
        mayorVenta = this.ventas[i];
      }
    }
    switch (dia) {
      case 0:
        return "Lunes";
      case 1:
        return "Martes";
      case 2:
        return "Miercoles";
      case 3:
        return "Jueves";
      case 4:
        return "Viernes";
      case 5:
        return "Sabado";
      case 6:
        return "Domingo";
      default:
        return "";
    }
  }
}
