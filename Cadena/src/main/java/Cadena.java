public class Cadena {

  public String linea;

  public int cantidadCaracteres() {
    return this.linea.length();
  }

  public int cantidadPalabras() {
    if (this.linea.trim().isEmpty()) {
      return 0;
    }
    return this.linea.trim().split("[\\s0-9]+").length;
  }
}
