public class EmpleadoComercial extends Empleado{
    private double comision;

    public boolean plus(double sueldoPlus) {
        boolean retorno = false;
        if (this.comision < 1000) {
            setSalario(sueldoPlus); //sueldoPlus o getSalario+SueldoPlus(?
            retorno = true;
        }
        return retorno;
    }
    public String imprimir(){
        String aux =super.toString();
        aux+=" Comision: "+this.comision;
        return aux;
    }
}
