import java.util.ArrayList;
public class Automoviles {
    private ArrayList<Automovil> autos;
    private double recorridocarrera;

    public Automoviles(){
        this.autos= new ArrayList<>();
        this.recorridocarrera=0;
    }
    public Automoviles(double recorrido){
        this();
        this.autos= new ArrayList<>();
        this.recorridocarrera=recorrido;
    }
    public void agregaalinea(Automovil auto){
        this.autos.add(auto);
    }
    public void fueradecarrera(Automovil auto){
        if(auto.getTanque()==0){
            this.autos.remove(auto);
            System.out.println("QUEDA DESCALIFICADO");
        }
    }
    public void simulacion(){
        for(int i=0;i<autos.size();i++){
            Automovil auto= autos.get(i);
            while((auto.getTanque()>0) &&(auto.getRecorrido()<recorridocarrera)){
                auto.moverse();}
                System.out.println("El auto ha recorrido: " + auto.getRecorrido() + " km");
                if(auto.getRecorrido()>=recorridocarrera){
                    System.out.println("El auto ha llegado a la meta, el piloto es:"+auto.getPiloto());
                }
                else{
                    System.out.println("El auto no ha llegado a la meta, sus pits no calcularon bien el combustible");
                }
            }
        }
    }
    

