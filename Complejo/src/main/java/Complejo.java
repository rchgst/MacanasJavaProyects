public class Complejo {

  public double real;
  public double imaginario;

  public Complejo sumarComplejos(Complejo com) {
    Complejo suma = new Complejo();
    suma.real = this.real + com.real;
    suma.imaginario = this.imaginario + com.imaginario;
    return suma;
  }

  public void mostrarComplejo() {
    if (this.real < 0) {
      System.out.println(this.imaginario + "i " + this.real);
    }
    System.out.println(this.imaginario + "i + " + this.real);
  }
}
