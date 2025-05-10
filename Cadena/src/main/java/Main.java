public class Main {
  public static void main(String[] args) {
    Cadena prueba = new Cadena();
    prueba.linea = "hola chicos de POO 2025";
    System.out.println("Cantidad de caracteres: " + prueba.cantidadCaracteres());
    System.out.println("Cantidad de palabras: " + prueba.cantidadPalabras());
    System.out.println("Cantidad de vocales: " + prueba.cantidadVocales());
    System.out.println("Cantidad de consonantes: " + prueba.cantidadConsonantes());
    prueba.linea = "en casa, pero trabajando";
    System.out.println("Cantidad de caracteres: " + prueba.cantidadCaracteres());
    System.out.println("Cantidad de palabras: " + prueba.cantidadPalabras());
    System.out.println("Cantidad de vocales: " + prueba.cantidadVocales());
    System.out.println("Cantidad de consonantes: " + prueba.cantidadConsonantes());
  }
}
