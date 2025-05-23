public class Secretario extends Empleado{
    private String despacho;
    private long numFax;

    public Secretario(String nom, int dni, String dom, int ant, int tel, double salario, String desp, long numFax, int anio, int mes, int dia, int hora, int min){
        super(nom, dni, dom, ant, tel, salario, anio, mes, dia, hora, min);
        this.despacho = desp;
        this.numFax = numFax;
    }

    public void aumentarSalario() {
        if (verificaPasante() == true) {
            double salarioAnual = this.salario * 12;
            double antiguedad = this.antiguedad * 10000;
            this.salario += ((this.salario * 0.1) + antiguedad);
        }else
            this.salario += this.salario * 0.05;
    }

    public String toString(){
        String cadena = "";
        cadena += super.toString() + ", Despacho: " + this.despacho + ", Fax: " + this.numFax;
        return cadena;
    }
}
