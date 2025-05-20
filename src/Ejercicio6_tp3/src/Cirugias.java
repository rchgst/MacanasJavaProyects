import java.util.ArrayList;

public class Cirugias {

    private ArrayList<Cirugia>cirugias;
    private int cantidad;

    public Cirugias(ArrayList<Cirugia> cirugias,int cantidad){
        this.cirugias = cirugias;
        this.cantidad = cantidad;
    }

    public Cirugias(){
        this.cirugias = new ArrayList<>();
        this.cantidad = 0;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void insertarCirugia(Cirugia cirugia){
        boolean b=false;
        for(int i=this.cantidad-1;i>=0;i--){
            if(this.cirugias.get(i).fchRealizacion.comparaFechas(cirugia.fchRealizacion.fecha)>0){
                this.cirugias.add(i+1,cirugia);
                b=true;
                break;
            }
        }
        if(b==false)
            this.cirugias.add(cirugia);
        this.cantidad += 1;
    }

    public void eliminarCirugia(String osocial) {
        int i = 0;
        while (i < this.cirugias.size()) {
            String nombreOS = this.cirugias.get(i).paciente.getObraSocial().getDenominacion();
            if (nombreOS.equals(osocial)) {
                this.cirugias.remove(i);
                this.cantidad--;
            } else {
                i++;
            }
        }
    }


    public int retornaFecha(Fecha act){
        for(int i=0;i<this.cantidad;i++){
            if(this.cirugias.get(i).fchRealizacion.comparaFechas(act.fecha)>=0)
                return i;
        }
        return -1;
    }

    public double promedioDuracion(){
        int acu=0;
        for(int i=0;i<this.cirugias.size();i++){
            acu += this.cirugias.get(i).getMinutosDuracion();
        }
        return acu/this.cantidad;
    }

    public double promedioDuracion(Fecha finicial,Fecha ffinal){
        int acu=0;
        int ini=this.retornaFecha(finicial);
        int fin=this.retornaFecha(ffinal);
        if(ini!=-1 && fin!=-1){
            fin--;
            for(int i=ini;i<fin;i++){
                acu += this.cirugias.get(i).getMinutosDuracion();
            }
            return acu/this.cantidad;
        }
        System.out.println("fechas invalidas");
        return -1;
    }

    public double promedioDuracion(int edad){
        int acu=0,cant=0;

        for(int i=0;i<this.cirugias.size();i++){
            if(this.cirugias.get(i).paciente.edad()>=edad){
                acu += this.cirugias.get(i).getMinutosDuracion();
                cant++;
            }
        }
        if(cant>0)
            return acu/cant;
        System.out.println("no hay cirugias con pacientes de edad: "+edad);
        return 0;
    }

    public Cirugias cirugiasPrestador(String nombre){
        ArrayList<Cirugia>prestadorCirugias=new ArrayList<>();
        Cirugias cirugiasP;
        for (int i=0;i<this.cantidad;i++){
            if(this.cirugias.get(i).prestador.nombre.equals(nombre))
                prestadorCirugias.add(this.cirugias.get(i));
        }
        return cirugiasP=new Cirugias(prestadorCirugias,prestadorCirugias.size());
    }

    public Cirugias cirugiasOS(String os) {
        ArrayList<Cirugia> osCirugias = new ArrayList<>();
        for (int i = 0; i < this.cantidad; i++) {
            String nombreOS = this.cirugias.get(i).paciente.getObraSocial().getDenominacion();
            if (nombreOS.equals(os)) {
                osCirugias.add(this.cirugias.get(i));
            }
        }
        return new Cirugias(osCirugias, osCirugias.size());
    }


}
