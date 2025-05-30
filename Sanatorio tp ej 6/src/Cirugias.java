import java.util.ArrayList;
public class Cirugias {
    private ArrayList<Cirugia> cirugias;
    private int cantidad;

    public Cirugias(){
        this.cirugias=new ArrayList<>();
        this.cantidad=0;
    }
    public void insertarCirugia(Cirugia cirugia){
        /*implementar busqueda binaria XXDDDD*/
        if(this.cantidad==0)
            this.cirugias.add(cirugia);
        else {
            int j = this.cantidad - 1;
            while (j >= 0 && (this.cirugias.get(j).fchRealizacion.comparaFechas(cirugia.fchRealizacion)) > 0) {
                j--;
            }
            this.cirugias.add(j + 1, cirugia);
            }
        this.cantidad++;
        }
    public void eliminarCirugia(String osocial){
      int i=0;
      while(i<this.cantidad){
            if(this.cirugias.get(i).paciente.getObraSocial().equals(osocial)){
               this.cirugias.remove(i);
               this.cantidad--;
                }
            else
                i++;
            }
    }
    public double promedioDuracion(){
        int i;
        double ac=0;
        for (i=0;i<this.cantidad;i++)
            ac+=this.cirugias.get(i).getMinutosDuracion();
        return ac/this.cantidad;
    }
    public double promedioDuracion(Fecha desde,Fecha hasta){
        int ini=-1,fin=-1;
        for(int i=0;i<this.cantidad;i++){
            if(this.cirugias.get(i).fchRealizacion.comparaFechas(desde)==0)
                ini = i;

            if(this.cirugias.get(i).fchRealizacion.comparaFechas(hasta)==0)
                fin=i;
        }
        if(ini==-1||fin==-1||ini>fin)
            return 0.0;

        double ac=0;
        for(int j=ini;j<=fin;j++)
            ac+=this.cirugias.get(j).getMinutosDuracion();
        return ac/(fin-ini+1);
    }
    public double promedioDuracion(int edad){
        int c=0;
        double ac=0;
        for(int i=0;i<this.cantidad;i++){
            if(this.cirugias.get(i).paciente.edad()>edad) {
                ac += this.cirugias.get(i).getMinutosDuracion();
                c++;
            }
        }
        if(c!=0)
            return ac/c;
        else
            return 0.0;
    }
    public Cirugias cirugiasPrestador(String prestador){
        Cirugias cirugiasXprestador = new Cirugias();
        for(int i=0;i<this.cantidad;i++){
            if(this.cirugias.get(i).prestador.nombre.equals(prestador)){
                cirugiasXprestador.cirugias.add(this.cirugias.get(i));
                cirugiasXprestador.cantidad++;
            }
        }
        if(cirugiasXprestador.cantidad!=0)
            return cirugiasXprestador;
        else
            return null;
    }
    public Cirugias cirugiasOS(String so){
        Cirugias cirugiasXOS = new Cirugias();
        for(int i=0;i<this.cantidad;i++){
            if(this.cirugias.get(i).paciente.getObraSocial().getDenominacion().equals(so)) {
                cirugiasXOS.cirugias.add(this.cirugias.get(i));
                cirugiasXOS.cantidad++;
            }

        }
        if(cirugiasXOS.cantidad!=0)
            return cirugiasXOS;
        else
            return null;
    }
    public int cirugiasPcte(Paciente p){
        int c = 0;
        for(int i=0;i<this.cantidad;i++){
            if(this.cirugias.get(i).paciente.esIgual(p))
                c++;
        }
        return c;
    }
}

