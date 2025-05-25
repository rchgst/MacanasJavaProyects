public class TablaDeSueldos {
    private double[][] sueldos;
    private int grados;
    private int etapas;

    public TablaDeSueldos(double[][] sueldos){
        this.sueldos = sueldos;
        this.grados = sueldos.length;
        this.etapas = sueldos[0].length;
    }

    public double promedioGrado(int grado){
        double acu=0;
        for(int c=0;c<etapas;c++){
            acu+=this.sueldos[grado][c];
        }
        return acu/etapas;
    }

    public double diferenciaDePago(int grado){
        return Math.abs(this.sueldos[grado][etapas-1]-this.sueldos[grado][0]);
    }

    public void aumentoGrado(int grado,double monto){
        for(int c=0;c<etapas;c++)
            this.sueldos[grado][c] += monto;
    }

    public double getSueldo(int f,int c) {
        return this.sueldos[f][c];
    }

    public void setSueldo(int f, int c, double sueldo) {
        this.sueldos[f][c] = sueldo;
    }

    public String toString(){
        String mensaje = "\n ";
        for (int i=0;i<grados;i++){
            mensaje += " grado " + i + ":";
            for (int j=0;j<etapas;j++){
                mensaje += " [" + getSueldo(i,j) + "]";
            }
            mensaje += "\n";
        }
        return mensaje;
    }

}
