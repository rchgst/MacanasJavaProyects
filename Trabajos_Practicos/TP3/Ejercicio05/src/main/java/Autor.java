public class Autor {
  private String nombre;
  private String nacionalidad;
  private Fecha fchNac;
  private Fecha fchFall;

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getNacionalidad() {
    return this.nacionalidad;
  }

  public void setNacionalidad(String nacionalidad) {
    this.nacionalidad = nacionalidad;
  }

  public Fecha getFchNac() {
    return this.fchNac;
  }

  public void setFchNac(Fecha fchNac) {
    this.fchNac = fchNac;
  }

  public Fecha getFchFall() {
    return this.fchFall;
  }

  public void setFchFall(Fecha fchFall) {
    this.fchFall = fchFall;
  }

  public Autor() {
  }

  public Autor(String nombre, String nacionalidad) {
    this.nombre = nombre;
    this.nacionalidad = nacionalidad;
  }

  public Autor(String nombre, String nacionalidad, Fecha fchNac) {
    this(nombre, nacionalidad);
    this.fchNac = fchNac;
  }

  public Autor(String nombre, String nacionalidad, Fecha fchNac, Fecha fchFall) {
    this(nombre, nacionalidad, fchNac);
    this.fchFall = fchFall;
  }

  @Override
  public String toString() {
    String cadena = "Autor [Nombre: " + this.nombre + ", Nacionalidad: " + this.nacionalidad;
    if (this.fchNac != null) {
      cadena += ", Fecha de Nacimiento: " + this.fchNac;
    }
    if (this.fchFall != null) {
      cadena += ", Fecha de Fallecimiento: " + this.fchFall;
    }
    return cadena + "]";
  }

}
