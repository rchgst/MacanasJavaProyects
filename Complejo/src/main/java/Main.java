public class Main {
  public static void main(String[] args) {
    Complejo complejo1 = new Complejo();
    Complejo complejo2 = new Complejo();
    complejo1.real = 10;
    complejo1.imaginario = 3;
    complejo2.real = 5;
    complejo2.imaginario = 2;
    System.out.println("Primer numero complejo");
    complejo1.mostrarComplejo();
    System.out.println("Segundo numero complejo");
    complejo2.mostrarComplejo();
    Complejo suma = complejo1.sumarComplejos(complejo2);
    System.out.println("Suma de ambos complejos");
    suma.mostrarComplejo();
    Complejo resta = complejo1.resta(complejo2);
    System.out.println("Resta del primer complejo con el segundo");
    resta.mostrarComplejo();
    resta = complejo2.resta(complejo1);
    System.out.println("Resta del segundo complejo con el primero");
    resta.mostrarComplejo();
  }
}
