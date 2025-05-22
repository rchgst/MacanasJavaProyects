import java.util.Random;

public class Virus {

  public String nombre;
  private int adn;
  private boolean nocivo;

  public Virus() {
    Random random = new Random();
    this.adn = random.nextInt(10) + 1;
    this.nocivo = true;
  }

  public Virus(String nombre) {
    this();
    this.nombre = nombre;
  }

  public boolean esNocivo() {
    return this.nocivo;
  }

  public void neutralizar(int adnNeutralizante) {
    if (adnNeutralizante != this.adn) {
      System.out.println("Lo siento, el virus continua siendo nocivo");
    } else {
      System.out.println("ADN encontrado! El virus ha sido neutralizado!");
      this.nocivo = false;
    }
  }

  @Override
  public String toString() {
    String cadena = "=== Virus ===\nNombre: " + this.nombre + "\n¿Es nocivo?: ";
    if (nocivo) {
      cadena += "Si";
    } else {
      cadena += "No";
    }
    return cadena;
  }

}
