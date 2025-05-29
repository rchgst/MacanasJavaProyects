public class Comercio {
    private CajaRegistradora[] cajas;

    public Comercio(CajaRegistradora caja1,CajaRegistradora caja2,CajaRegistradora caja3){
        this.cajas = new CajaRegistradora[3];
        cajas[0] = caja1;
        cajas[1] = caja2;
        cajas[2] = caja3;
    }

    public double totalRecaudacion(){
        return this.cajas[0].total()+this.cajas[1].total()+cajas[2].total();
    }

    public void menorImporte(){
        double menor=cajas[0].total();
        int ind=0;
        for (int i=1;i<3;i++){
            if(cajas[i].total()<menor){
                menor=cajas[i].total();
                ind = i+1;
            }
        }
        System.out.println("el menor importe lo tiene la caja: "+ind);
    }

    public void mostrarCajas(){
        for (int i=0;i<3;i++){
            System.out.println("\nimporte total de la caja:"+(i+1)+" "+cajas[i].total());
        }
    }

}
