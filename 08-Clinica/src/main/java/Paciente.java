public class Paciente {

  private String nombre;
  private int dni;
  private String domicilio;
  private String telefono;
  private Fecha fechaIngreso;

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getDni() {
    return this.dni;
  }

  public void setDni(int dni) {
    this.dni = dni;
  }

  public String getDomicilio() {
    return this.domicilio;
  }

  public void setDomicilio(String domicilio) {
    this.domicilio = domicilio;
  }

  public String getTelefono() {
    return this.telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public Fecha getFechaIngreso() {
    return this.fechaIngreso;
  }

  public void setFechaIngreso(int year, int month, int day) {
    this.fechaIngreso.setFecha(year, month, day);
  }

  public Paciente(String nombre, int dni, String domicilio, String telefono) {
    this();
    this.nombre = nombre;
    this.dni = dni;
    this.domicilio = domicilio;
    this.telefono = telefono;
    this.fechaIngreso.fechaActual();
  }

  public Paciente() {
    this.fechaIngreso = new Fecha();
  }

  @Override
  public String toString() {
    return "Paciente\nNombre: " + nombre + "\nDNI: " + dni + "\nDomicilio: " + domicilio + "\nTelefono: " + telefono
        + "\nFecha de ingreso: " + fechaIngreso.toString();
  }

}
