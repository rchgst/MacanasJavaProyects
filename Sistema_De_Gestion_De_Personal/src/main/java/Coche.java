public class Coche {
  private String matricula;
  private String marca;
  private String modelo;

  public String getMatricula() {
    return this.matricula;
  }

  public void setMatricula(String matricula) {
    this.matricula = matricula;
  }

  public String getMarca() {
    return this.marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public String getModelo() {
    return this.modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public Coche() {
  }

  public Coche(String matricula, String marca, String modelo) {
    this.matricula = matricula;
    this.marca = marca;
    this.modelo = modelo;
  }

  @Override
  public String toString() {
    return "Matricula: " + this.matricula + ", Marca: " + this.marca + ", Modelo: " + this.modelo;
  }
}
