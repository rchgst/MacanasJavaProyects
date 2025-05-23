import java.util.ArrayList;
public class Carrito extends Cliente{
    private Cliente cliente;
    private ArrayList<Producto> productos;
    private Distribucion Distribuidora;
    private Inventario inventario;
    private MetododePago metodoPago;
    
    public Carrito(Cliente cliente){
        this.cliente=cliente;
        this.inventario= new Inventario();
        this.Distribuidora= new Distribucion();
        this.metodoPago= new MetododePago();
        this.productos= new ArrayList<>();
    }
    public void AgregaUnProducto(Producto Prod){
        this.productos.add(Prod);
    }
    public void EliminaUnProducto(Producto Prod){
        this.productos.remove(Prod);
    }
    public boolean Validar(){
        boolean Valor; 
        if(this.Distribuidora.ValidarC(cliente)==true){
            Valor=true;
            if(this.metodoPago.ValidaPago(1000)==true){
                Valor=true;
                if((this.inventario.ValidarInventario(this.productos)==true)){
                    Valor=true;
                }
                else{
                    Valor=false;
                }
        }
            else{
                Valor=false;
            }
        }
        else{
            Valor=false;
    }
    return Valor;
}
}