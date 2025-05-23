public class Milicia{
    private String nombre;
    private int energia;
    private Arma arma;

    public Milicia(){
        this.nombre="Sin nombre";
        this.energia=0;
        this.arma= new Arma();
    }
    public Milicia(String nombre, int energia, Arma arma){
        this.nombre=nombre;
        this.energia=energia;
        this.arma= arma;
 
    } 
    public String getNombre(){
        return nombre;
    }
    public int getEnergia(){
        return energia;
    }
    public void setenergia(int energia){
        this.energia=energia;
    }
    public void decrementaVida(){
        setenergia(getEnergia()-this.arma.getPoder());
    }
    public void ingrementaVida(){
        setenergia(getEnergia()+1);
    }
    public void golpear(Milicia Unidad){
        if(arma.getPoder()>0){
            Unidad.setenergia(Unidad.getEnergia()-arma.getPoder());
        }
    } 
    public String toString(){
        return "Nombre: "+getNombre()+" Energia: "+getEnergia()+" Arma: "+arma.toString();
    }
}