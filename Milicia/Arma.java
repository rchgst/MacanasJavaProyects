public class Arma {
    protected String nombre;
    protected int poder;
    public Arma(){
        this.nombre="Sin nombre";
        this.poder=0;
    }
    public Arma(String nombre, int poder){
        this.nombre=nombre;
        this.poder=poder;
    }
    public String getNombre(){
        return nombre;
    }
    public int getPoder(){
        return poder;
    }
    public void incrementaPoder(){
        ++this.poder;
    }
    public void decrementaPoder(){
        --this.poder;
    }
    public void dañar(Milicia Unidad){
        if(getPoder()>0){
            Unidad.setenergia(Unidad.getEnergia()-getPoder());
        }
        
    }
    @Override
    public String toString(){
        return "Nombre: "+getNombre()+" Poder: "+getPoder();
    }
    
}
