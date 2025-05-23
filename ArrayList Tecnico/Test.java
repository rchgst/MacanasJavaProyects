import java.util.Scanner;
public class Test {
    public static void main(String [] args){
        TecnicoDT tecnico= new TecnicoDT();
        Scanner sc= new Scanner( System.in);
        
        System.out.println("----------------------------");
        do{
 
            System.out.println("\nIngresa el nombre del torneo: ");
            String Torneo=sc.nextLine();
            tecnico.AgregaTorneo(Torneo);
           
        }while(tecnico.CantidadTorneos()<5);
        

        
        
        
        
        System.out.println(tecnico.toString());
        tecnico.EliminaTorneo("COPA ACOPLE FEDERAL A");
        System.out.println(tecnico.toString());
        tecnico.EliminaTorneos();

        System.out.println(tecnico.toString()+"esta vacia?\n"+tecnico.CantidadTorneos());
        sc.close();
    }    
}
