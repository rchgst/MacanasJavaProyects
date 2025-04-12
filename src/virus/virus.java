package virus;



public class virus {

    private String nombre;
    private int adn;
    private boolean nocivo;

    public virus(String nombre){
        this();
        this.nombre = nombre;
    }

    public virus(){
        this.adn = (int)(Math.random()*10)+1;
        this.nocivo = true;
    }

    public boolean esNocivo(){
        return this.nocivo;
    }

    public void neutralizar(int adnNeutralizante){
        if(adnNeutralizante == this.adn){
            System.out.println("el virus fue neutralizado");
            this.nocivo = true;
        }
        else{
            System.out.println("el virus no fue neutralizado");
            //System.err.println("el virus contenia el adn: "+ this.adn);
        }
    }

    @Override
    public String toString(){
        return   "nombre del nombre ='" + this.nombre + ", adn=" + this.adn + ", nocivo=" + this.nocivo;
    }

}