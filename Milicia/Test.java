import java.util.Random;
public class Test {
    public static void main(String[] args) {
        boolean Turno;
        int movimiento=0;
        Milicia milicia = new Milicia("Espadachin",100,new Arma("Espada de esgrima",10));
        System.out.println(milicia.toString());
        
        Milicia arquero= new Milicia("Arquero",100,new Arma("Arco de guerra",15));
    
        while((milicia.getEnergia()>0)&&(arquero.getEnergia()>0)){
            Turno = new Random().nextBoolean();
            if(Turno==true){
                System.out.println("Turno del Arquero");
                System.out.println(arquero.toString());
                System.out.println("Golpea a Espadachin");
                arquero.golpear(milicia);
                System.out.println(("-----------"));
            }
            else{
                System.out.println("Turno del Espadachin");
                System.out.println(milicia.toString());
                System.out.println("Golpea a Arquero");
                arquero.golpear(arquero);
                System.out.println("-----------");
            }
            ++movimiento;
            System.out.println("movimiento numero: \n"+movimiento);
    
        }
        if(milicia.getEnergia()<=0){
            System.out.println("El ganador es el Arquero");
        }
        else{
            System.out.println("El ganador es el Espadachin");
        }

    }
}
