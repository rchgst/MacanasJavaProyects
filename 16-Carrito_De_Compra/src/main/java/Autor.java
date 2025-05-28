public class Autor {
  private String nombre;
  private String goodreads;

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getGoodreads() {
    return this.goodreads;
  }

  public void setGoodreads(String goodreads) {
    this.goodreads = goodreads;
  }

  public Autor() {
  }

  public Autor(String nombre) {
    this.nombre = nombre;
  }

}
