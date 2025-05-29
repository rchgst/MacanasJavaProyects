public abstract class Empleado {
    protected final static double SMVM = 16875; // Salario Mínimo
    protected String nombre;
    protected String apellido;
    protected int edad;
    protected double salario;

    public Empleado(String nombre, String apellido, int edad, double salario){
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.salario = salario;
    }

    public Empleado(){
        this("", "", 0, SMVM);
    }

    public String getNombre() {
        return nombre + " " + apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String toString(){
        return "nombre y apellido: " + getNombre() + "\nEdad: " + getEdad() + " Salario: " + getSalario();
    }

    public abstract boolean plus(double sueldoPlus);
    public abstract String imprimir();
}
