public class TablaVentas {
  private double[][] ventas;

  public TablaVentas() {
    this.ventas = new double[6][5];
  }

  public static void main(String[] args) {
    TablaVentas tabla = new TablaVentas();
    // v1 realizo una venta
    tabla.agregarVenta(0, 2, 150);
    tabla.ventasDeUnVendedor(4);
    tabla.ventasTotalesMes(1);
    tabla.ventaTotal();
  }

  public void agregarVenta(int vendedor, int mes, double dinero) {
    if ((vendedor >= 0 && mes >= 0) && (vendedor <= this.ventas[0].length && mes <= this.ventas.length)) {
      this.ventas[mes][vendedor] = dinero;
      System.out.println("Venta ingresada en venta[" + mes + "][" + vendedor + "] = " + this.ventas[mes][vendedor]);
    } else {
      System.out.println("Los valores de los indices son incorrectos!");
    }
  }

  public void ventasDeUnVendedor(int vendedor) {
    for (int i = 0; i < this.ventas.length; i++) {
      System.out.println(this.ventas[i][vendedor]);
    }
  }

  public void ventasTotalesMes(int mes) {
    for (int i = 0; i < this.ventas[0].length; i++) {
      System.out.println(this.ventas[mes][i]);
    }
  }

  public void ventaTotal() {
    double total = 0;
    for (int i = 0; i < ventas.length; i++) {
      for (int j = 0; j < this.ventas[i].length; j++) {
        total += this.ventas[i][j];
      }
    }
    System.out.println("El total de ventas es: " + total);
  }
}
