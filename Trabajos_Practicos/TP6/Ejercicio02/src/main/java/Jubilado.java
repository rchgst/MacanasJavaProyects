public class Jubilado implements InterfacePersona, InterfaceMortandad {
  private double dineroAhorrado;
  private double jubilacionAnual;
  private String nombre;
  private String apellido;
  private int edad;
  private Tabla tablaMortandad;

  public Jubilado(double dineroAhorrado, double jubilacionAnual, String nombre, String apellido, int edad) {
    this.dineroAhorrado = dineroAhorrado;
    this.jubilacionAnual = jubilacionAnual;
    this.nombre = nombre;
    this.apellido = apellido;
    this.edad = edad;
    this.tablaMortandad = new Tabla();
  }

  @Override
  public double esperanzaDeVida() {
    return tablaMortandad.calcularEsperanzaDeVida(this.edad);
  }

  @Override
  public double estimarCapital() {
    return this.dineroAhorrado + (this.tablaMortandad.calcularEsperanzaDeVida(this.edad) * this.jubilacionAnual);
  }

  @Override
  public String getNombre() {
    return this.nombre + " " + this.apellido;
  }
}
