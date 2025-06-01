import java.util.ArrayList;

public class Carrito {
    private ArrayList<Libro> carrito;

    public Carrito(){
        this.carrito = new ArrayList<Libro>();
    }
    public void agregarLibro(Libro libro) {
        carrito.add(libro);
    }
    public void eliminarLibro(Libro libro){
        int pos = 0;
        boolean b=true;
        while (pos<=this.carrito.size()&&b){
            if (this.carrito.get(pos).equals(libro)){
                b=false;
            }else{
                pos++;
            }
        }
        if(b){
            System.out.println("No se encontro el libro");
        }else{
            this.carrito.remove(pos);
        }
    }
    public double calcularTotal(){
        double total=0;
        for (int i = 0; i <= carrito.size() ; i++) {
            total+=carrito.get(i).getPrecio();
        }
        return  total;
    }
    public void pagar(TipoDePago tipoDePago){
        tipoDePago.pagar(calcularTotal());
    }
 }
