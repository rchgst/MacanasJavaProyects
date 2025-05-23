public class Tanque {
     double capacidadTotal;
    private double capacidadActual;
    private boolean tanqueVacio;

    public Tanque(){
  
        this.tanqueVacio=true;
    }
    public Tanque (double capacidadTotal, double capacidadActual, boolean tanque){
        this.capacidadTotal=capacidadTotal;
        this.capacidadActual=capacidadActual;
        this.tanqueVacio=tanque;
    }
    public double getCapacidadActual(){
        return this.capacidadActual;
    }
    public void setCapacidadActual(double capacidadActual){
        this.capacidadActual=capacidadActual;
    }
    public void setTanqueVacio(Boolean tanquebool){
        this.tanqueVacio=tanquebool;
    }
    public boolean gettanquevacio(){
        return this.tanqueVacio;
    }
    public void determineTanque(){
       if(this.capacidadActual==0){
        setCapacidadActual(0);
       } 
    }
}
