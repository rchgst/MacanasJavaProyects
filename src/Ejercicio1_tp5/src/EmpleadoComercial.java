public class EmpleadoComercial extends Empleado{
    private double comision;

    public EmpleadoComercial(String nombre, String apellido, int edad, double salario,double comision){
        super(nombre,apellido,edad,salario);
        this.comision = comision;
    }

    public boolean plus(double saldoPlus){
        if(comision<1000)
            return true;
        return false;
    }

    public String imprimir(){
        String mensaje="";
        mensaje += "nombre: "+nombre+","+apellido+" edad: "+edad+" salario: "+salario+" comision? "+comision;
        return mensaje;
    }

}
