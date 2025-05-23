public class Motor {
    private double consumoPorMin;
    private double distanciaPorLitro;
    private boolean enMarcha;

    public Motor() {
        this.consumoPorMin = 0;
        this.enMarcha = false;
        this.distanciaPorLitro = 0;
    }

    public Motor(double consumoPorMin, double capacidad, boolean enMarcha) {
        this.consumoPorMin = consumoPorMin;
        this.distanciaPorLitro = capacidad;
        this.enMarcha = enMarcha;
    }

    public boolean keyMaster() {
        if (!this.enMarcha) {
            return this.enMarcha = true;
        } else {
            return this.enMarcha = false;
        }
    }
    public double getConsumo() {
        return this.consumoPorMin;
    }

    public double getCapacidad() {
        return this.distanciaPorLitro;
    }

    public boolean getEnMarcha() {
        return this.enMarcha;
    }
}

