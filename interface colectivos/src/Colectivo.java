public abstract class Colectivo {
    private int ID;
    private int capacidad;
    private double costo;
    private static int sgteID = 1;

    public Colectivo(int capacidad, double costo) {
        ID = sgteID++;
        this.capacidad = capacidad;
        this.costo = costo;
    }

    abstract public double getAcel();

    public final int getID() {
        return this.ID;
    }

    public int getCapacidad() {
        return this.capacidad;
    }

    public double getCosto() {
        return this.costo;
    }
}