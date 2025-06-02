import java.util.ArrayList;

public class TablaPrestamo {
    private ArrayList<Prestamo>prestamos;
    private int cantidad;

    public TablaPrestamo(ArrayList<Prestamo>prestamos){
        this.prestamos = prestamos;
        cantidad = prestamos.size();
    }

    public void nuevoPrestamo(Prestamo p){
        prestamos.add(p);
    }

    public int getCantidad(){
        return cantidad;
    }

    public Prestamo getPrestamo(int pos){
        return prestamos.get(pos);
    }

    public boolean estaPrestado(Libro libro){
        for(int i=0;i<cantidad;i++){
            if(prestamos.get(i).getLibro().igual(libro))
                return true;
        }
        return false;
    }

    public Libro getLibro(int pos){
        return prestamos.get(pos).getLibro();
    }

    public boolean hayPrestamos(){
        return cantidad>0;
    }

}
