public class Person {
  private String nombre;
  private char sexo;
  private long dni;

  public Person(String nombre, char sexo, long dni) {
    this.nombre = nombre;
    this.sexo = sexo;
    this.dni = dni;
  }

  public String getNombre() {
    return this.nombre;
  }

  public char getSexo() {
    return this.sexo;
  }

  public long getDni() {
    return this.dni;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

}
