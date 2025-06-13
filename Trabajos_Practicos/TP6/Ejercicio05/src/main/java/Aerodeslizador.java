public class Aerodeslizador implements TransporteMaritimo, TransporteTerrestre {
  private String nombre;
  private int maxPasajeros;
  private int maxVelocidad;
  private int desplazamiento;
  private int numRuedas;

  public Aerodeslizador() {
  }

  public Aerodeslizador(String nombre, int maxPasajeros, int maxVelocidad, int desplazamiento, int numRuedas) {
    this.nombre = nombre;
    this.maxPasajeros = maxPasajeros;
    this.maxVelocidad = maxVelocidad;
    this.desplazamiento = desplazamiento;
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
    System.out.println("Manejando...");
  }

  @Override
  public void tocarBocina() {
    System.out.println("Ruido de bocina");
  }

  @Override
  public int getDesplazamiento() {
    return this.desplazamiento;
  }

  @Override
  public void setDesplazamiento(int desplazamiento) {
    this.desplazamiento = desplazamiento;
  }

  @Override
  public void zarpar() {
    System.out.println("Zarpando...");
  }

  public void viajarPorTierra() {
    manejar();
  }

  public void viajarPorAgua() {
    zarpar();
  }
}
