import java.util.ArrayList;

public class CajaRegistradora {
    private ArrayList<Double> movimientos;

    public CajaRegistradora(ArrayList<Double> movimientos){
        this.movimientos = movimientos;
    }

    public CajaRegistradora(){
        this.movimientos = new ArrayList<>(0);
    }

    public void agregaMovimiento(double venta){
        movimientos.add(venta);
    }

    public double total(){
        double acu = 0;
        for (int i=0;i<movimientos.size();i++){
            acu+=movimientos.get(i);
        }
        return acu;
    }

}
