public class Automovil {
    private Motor motor;
    private Tanque tanque;
    private double recorrido;

    public Automovil() {
        this.recorrido = 0;
    }

    public Automovil(double recorrido) {
        this();
        this.motor = new Motor(43,10,false);
        this.tanque = new Tanque(32,43,false);
        this.recorrido = recorrido;
    }

    public void apagon() {
        if (this.tanque.getCapacidadActual() == 0) {
            this.motor.keyMaster();
        }
    }

    public double getRecorrido() {
        return this.recorrido;
    }

    public void setRecorrido(double recorrido) {
        this.recorrido = recorrido;
    }
    
    public void moverse() {
        // Encender el motor al inicio
        if (!this.motor.getEnMarcha()) {
            this.motor.keyMaster();
        }
        
        double consumoMinuto = this.motor.getConsumo() * 60;
        double distanciaPorLitro = 1 / this.motor.getCapacidad();
        
        while (this.motor.getEnMarcha() && this.tanque.getCapacidadActual() > 0) {
            this.setRecorrido(Math.abs(consumoMinuto * (distanciaPorLitro - this.tanque.getCapacidadActual())));
            this.tanque.setCapacidadActual(this.tanque.getCapacidadActual() - distanciaPorLitro);
            
            if (this.tanque.getCapacidadActual() <= 0) {
                this.motor.keyMaster(); // Apagar el motor
            }
        }
        System.out.println("El auto se apagó por falta de combustible");
    }
}