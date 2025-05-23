import java.util.Random;
public class Virus{
    private String nombre;
    private int adn;
    private boolean nocivo;

    public Virus(String nombre){
        this();
        this.nombre=nombre;

    }
    public Virus(){
        Random rd=new Random();
        this.adn=rd.nextInt(1,10);
        this.nocivo=true;
    }
    public boolean esNocivo(){
        System.out.println("el virus fue neutralizado");
        return this.nocivo=false;
    }
    public int getAdn(){
    return this.adn;
    }
    public  void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void neutralizar(int adnNeutralizante){
        if(adnNeutralizante==this.adn){
            this.nocivo=esNocivo();
        }
        else{
            System.out.println("No es posible neutralizar el virus");
        }    
    }
    public String toString(){
        return "\nel nombre del virus es: "+this.nombre+"\n el adn es: "+this.adn+"\npeligrosidad: "+this.nocivo;
    }
}