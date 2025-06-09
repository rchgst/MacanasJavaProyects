import java.util.ArrayList;

public class Pedido {
    private ArrayList<PiezaCeramica> piezas;
    private FormaDePago formaDePago;

    public Pedido(){
        this.piezas=new ArrayList<>();
        this.formaDePago=null;
    }
    public void agregarPieza(PiezaCeramica pieza){
        this.piezas.add(pieza);
    }

    public void setFormaDePago(FormaDePago formaDePago) {
        this.formaDePago = formaDePago;
    }
    public double calcularTotal(){
        double ac=0;
        for (int i=0;i<this.piezas.size();i++)
            ac+=this.piezas.get(i).getPrecioFinal();
        return ac;
    }
    public void pagar(){
        double total=this.calcularTotal();
        System.out.println("Monto total a pagar: "+total);
        if(this.formaDePago!=null)
            System.out.println("Monto final despues de aplicar descuentos/recargos: "+this.formaDePago.pagar(total));
        else
            System.out.println("Error, no ha seleccionado la forma de pago");
    }
}
