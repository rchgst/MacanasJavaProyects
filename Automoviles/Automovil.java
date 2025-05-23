public class Automovil {
    private Motor motor;
    private Tanque tanque;
    private double recorrido;
    private Corredor piloto;
    public Automovil() {
        this.recorrido = 0;
        this.motor= new Motor();
        this.tanque= new Tanque();
    }

    public Automovil(Motor motor, Tanque tanque,double recorrido, Corredor piloto) {
        this();
        this.motor = motor;
        this.tanque = tanque;
        this.recorrido = recorrido;
        this.piloto = piloto;
    }

   /*  public void apagon() {
        if (this.tanque.getCapacidadActual() == 0) {
            this.motor.keyMaster();
        }
    }*/

    public double getRecorrido() {
        return this.recorrido;
    }
    public String getPiloto(){
        return this.piloto.getNombre();
    }

    public void setRecorrido(double recorrido) {
        this.recorrido = recorrido;
    }
    public double getTanque(){
        return this.tanque.getCapacidadActual();
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