import java.util.Scanner;

public class OMSTesting {

  public static void main(String[] args) {
    Virus virus1 = new Virus("Gripe A");
    System.out.println(virus1);
    System.out.println("Es nocivo? " + virus1.esNocivo());
    Scanner scanner = new Scanner(System.in);
    do {
      System.out.print("Ingrese un numero del 1 al 10 para neutralizar el virus: ");
      virus1.neutralizar(Integer.parseInt(scanner.nextLine()));
      if (virus1.esNocivo()) {
        System.out.println("Mala suerte! Intenta de nuevo");
      } else {
        System.out.println("Virus neutralizado!");
      }
    } while (virus1.esNocivo());
  }
}
