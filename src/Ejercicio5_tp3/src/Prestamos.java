import java.util.ArrayList;

public class Prestamos {
    private ArrayList<Prestamo> prestamos;
    private int cantidad;

    public Prestamos(ArrayList<Prestamo> prestamos){
        this.prestamos = prestamos;
        this.cantidad = prestamos.size();
    }

    public Prestamos(){
        this.prestamos = new ArrayList<>(0);
        this.cantidad = 0;
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
        int i = 0;
        while (i<cantidad && this.prestamos.get(i).getLibro().igual(libro)==false)
            i++;
        if(i<cantidad)
            return true;
        return false;
    }

    public boolean hayPrestamos(){
        return cantidad>0;
    }
}
