public class Jeep implements TransporteTerrestre {
  private String nombre;
  private int maxPasajeros;
  private int maxVelocidad;
  private int numRuedas;

  public Jeep() {
  }

  public Jeep(String nombre, int maxPasajeros, int maxVelocidad, int numRuedas) {
    this.nombre = nombre;
    this.maxPasajeros = maxPasajeros;
    this.maxVelocidad = maxVelocidad;
    this.numRuedas = numRuedas;
  }

  @Override
  public String getNombre() {
    return this.nombre;
  }

  @Override
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  @Override
  public int getMaxPasajeros() {
    return this.maxPasajeros;
  }

  @Override
  public void setMaxPasajeros(int maxp) {
    this.maxPasajeros = maxp;
  }

  @Override
  public int getMaxVelocidad() {
    return this.maxVelocidad;
  }

  @Override
  public void setMaxVelocidad(int maxv) {
    this.maxVelocidad = maxv;
  }

  @Override
  public int getNumRuedas() {
    return this.numRuedas;
  }

  @Override
  public void setNumRuedas(int numRuedas) {
    this.numRuedas = numRuedas;
  }

  @Override
  public void manejar() {
    System.out.println("Manjeando...");
  }

  @Override
  public void tocarBocina() {
    System.out.println("Hacer ruido de bocina");
  }

}
