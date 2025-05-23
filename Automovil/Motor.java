public class Motor {
    private double consumoPorMin;
    private double distanciaPorLitro;
    private boolean enMarcha;

    public Motor() {
        this.enMarcha = false;
    }

    public Motor(double consumoPorMin, double capacidad, boolean enMarcha) {
        this.consumoPorMin = consumoPorMin;
        this.distanciaPorLitro = capacidad;
        this.enMarcha = enMarcha;
    }

    public boolean keyMaster() {
        if (!this.enMarcha) {
            System.out.println("Se Encenderá el motor");
            return this.enMarcha = true;
        } else {
            System.out.println("Se Apagará el motor");
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

