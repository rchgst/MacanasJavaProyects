public class Main {
  public static void main(String[] args) {
    VentaSemanal venta1 = new VentaSemanal();
    venta1.cargarVentas();
    System.out.println("El total de ventas de esta semana es: " + venta1.totalVentaSemanal());
    System.out.println("El promedio de ventas de esta semana es: " + venta1.promedioVentaSemanal());
    System.out.println("Y el dia con mas ventas es: " + venta1.diaConMasVentas());
    VentaSemanal venta2 = new VentaSemanal(3);
    venta2.cargarVentas();
    System.out.println("El total de ventas de esta semana es: " + venta2.totalVentaSemanal());
    System.out.println("El promedio de ventas de esta semana es: " + venta2.promedioVentaSemanal());
    System.out.println("Y el dia con mas ventas es: " + venta2.diaConMasVentas());
    double[] semana3 = { 500, 300, 200, 1000, 800, 400, 900 };
    VentaSemanal venta3 = new VentaSemanal(semana3);
    System.out.println("El total de ventas de esta semana es: " + venta3.totalVentaSemanal());
    System.out.println("El promedio de ventas de esta semana es: " + venta3.promedioVentaSemanal());
    System.out.println("Y el dia con mas ventas es: " + venta3.diaConMasVentas());
  }
}
