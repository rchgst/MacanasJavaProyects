import java.util.ArrayList;

public class Inventario {
    public boolean ValidarInventario(ArrayList<Producto> productos) {
       if(productos.isEmpty()){
        System.out.println("No hay Stock. . . . .");
        return false;
       }
        return true;
    }
}
