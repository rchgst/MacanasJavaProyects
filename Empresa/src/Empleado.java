public class Empleado {
    protected String nombre;
    protected int dni;
    protected String domicilio;
    protected int antiguedad;
    protected int telefono;
    protected double salario;
    protected Empleado supervisor;
    protected Fecha fechaIng; //fecha de ingreso del empleado

    public Empleado(String nom, int dni, String dom, int ant, int tel, double salario, int anio, int mes, int dia, int hora, int min){
        this.nombre = nom;
        this.dni = dni;
        this.domicilio = dom;
        this.antiguedad = ant;
        this.telefono = tel;
        this.salario = salario;
        this.fechaIng = new Fecha(anio, mes, dia, hora, min);
    }

    public String toString(){
        String cadena = "";
        cadena += "Nombre: " + this.nombre + ", DNI: " + this.dni + ", Domicilio: " + this.domicilio + ", Antiguedad: " + this.antiguedad + ", telefono: " + this.telefono + ", Salario: " + this.salario + this.fechaIng.toString();
        return cadena;
    }

    public void setSupervisor(Empleado emp){
        this.supervisor = emp;
    }

    public boolean verificaPasante(){ //Retorna True si el empleado no es pasante
        return (this.fechaIng.diferencia2Fechas() > 90);
    }

    public void aumentarSalario(){

    }
}
