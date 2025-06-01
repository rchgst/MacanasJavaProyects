import java.util.ArrayList;

public class TablaPrestamos {
    private ArrayList<Prestamo> prestamos;
    private int cantidad;

    public TablaPrestamos(int cantidad) {
        this.prestamos = new ArrayList<>();
        this.cantidad = cantidad;
    }

    public void nuevoPrestamo(Prestamo p) {
        if(this.prestamos.size()<cantidad)
            this.prestamos.add(p);
        else
            System.out.println("Error, tamaño maximo alcanzado. no es posible agregar nuevo prestamo");
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public Prestamo getPrestamo(int pos) {
        if (pos >= 0 && pos < this.prestamos.size())
            return this.prestamos.get(pos);
        else
            return null;
    }

    public boolean estaPrestado(Libro libro) {
        int i=0;
        while (i<this.prestamos.size()&&!this.prestamos.get(i).getLibro().equals(libro))
            i++;
        if(i>=this.prestamos.size())
            return false;
        else
            return true;
    }
    public boolean hayPrestamos(){
        return !this.prestamos.isEmpty();
    }
}
