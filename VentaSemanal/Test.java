public class Test {
    public static void main(String[] args) {
    VentaSemanal ventas=new VentaSemanal(7);
        ventas.CargaVentas();
        System.out.println("el total de ventas semanales es: "+ventas.TotalVentas());
        System.out.println("el promedio de ventas semanales es: "+ventas.PromedioVentas());
        System.out.println("el dia con mas ventas fue: "+ventas.diaconMasVentas());
    }
}
