public class EmpleadoAdministrativo extends Empleado {
    private double comision;

    public boolean plus(double sueldoPlus) {
        boolean retorno = false;
        if (this.comision < 2000) {
            setSalario(sueldoPlus); //sueldoPlus o getSalario+SueldoPlus(?
            retorno = true;
        }
        return retorno;
    }
}
