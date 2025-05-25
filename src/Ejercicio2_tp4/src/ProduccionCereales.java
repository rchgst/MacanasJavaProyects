public class ProduccionCereales {
    private double[][] produccion;
    private int tipos;
    private int meses;

    public ProduccionCereales(double[][] produccion){
        this.produccion = produccion;
        this.tipos = produccion.length;
        this.meses = produccion[0].length;
    }

    public double promedioAnual(int tipo){
        double acu=0;
        for(int c=0;c<meses;c++){
            acu+=this.produccion[tipo][c];
        }
        return acu/meses;
    }

    public int cantMejoresCosechas(int tipo){
        int c=0;
        double promAnual = this.promedioAnual(tipo);
        for (int i=0;i<meses;i++)
            if(this.produccion[tipo][i] > promAnual)
                c++;
        return c;
    }

    public int cantPeoresCosechas(int tipo){
        int c=0;
        double promAnual = this.promedioAnual(tipo);
        for (int i=0;i<meses;i++)
            if(this.produccion[tipo][i] < promAnual)
                c++;
        return c;
    }

    public double getSueldo(int f,int c) {
        return this.produccion[f][c];
    }
    public void setSueldo(int f, int c, double tonelada) {
        this.produccion[f][c] = tonelada;
    }
    public String toString(){
        String mensaje = "\n ";
        for (int i=0;i<tipos;i++){
            mensaje += " tipo " + i + ":";
            for (int j=0;j<meses;j++){
                mensaje += " [" + getSueldo(i,j) + "]";
            }
            mensaje += "\n";
        }
        return mensaje;
    }
}
