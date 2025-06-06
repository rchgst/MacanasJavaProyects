public abstract class Colectivo {
    private int ID,capacidad;
    private double costo;
    private static int sgteId = 1;

    public Colectivo(int capacidad,double costo){
        ID = sgteId++;
        this.capacidad = capacidad;
        this.costo = costo;
    }

    abstract public double getAcel();

    public final int getID(){
        return this.ID;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public double getCosto() {
        return costo;
    }


}
