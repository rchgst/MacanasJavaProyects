public class Vendedor extends Empleado{
    private long telMovil;
    private Coche coche;

    public Vendedor(String nom, int dni, String dom, int ant, int tel, double salario, int telMovil, String matri, String model, String marca, int anio, int mes, int dia, int hora, int min) {
        super(nom, dni, dom, ant, tel, salario, anio, mes, dia, hora, min);
        coche = new Coche(matri, model, marca);
        this.telMovil = telMovil;
    }

    public void aumentarSalario() {
        if (verificaPasante() == true) {
            double salarioAnual = this.salario * 12;
            double antiguedad = this.antiguedad * 12000;
            this.salario += ((this.salario * 0.2) + antiguedad);
        }else
            this.salario += this.salario * 0.05;
    }

    public String toString(){
        String cadena = "";
        cadena += super.toString() + " " + this.coche.toString() + ", Tel movil: " + this.telMovil;
        return cadena;
    }
}