import java.util.ArrayList;
public class Pedido{
    ArrayList<PiezaCeramica> piezas;
    FormadePago format;
    public Pedido(){
        this.piezas=new ArrayList<PiezaCeramica>();
        this.format=null;
    }
    public void agregapieza(PiezaCeramica Pc1){
        this.piezas.add(Pc1);
    }
    public void setFormadePago(FormadePago Fpay){
        this.format=Fpay;
    }
    public double CalculeTot(){
        double CalculeTot=0;
        for(int i=0;i<piezas.size();i++){
            CalculeTot+=piezas.get(i).getPrecioFinal(); 
        }
        return CalculeTot;
    }
    public void pagar(){
        if(format==null){
            System.out.println("NONE . .");
        }
        double monto=CalculeTot();
        double montoF=format.pagar(monto);
        System.out.println("Monto Original: "+monto);
        System.out.println("Monto FInal: "+montoF);
    }
}
