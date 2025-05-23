import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        var Scanner=new Scanner(System.in);   
        Virus v1= new Virus("Antrax");  
        Virus v2= new Virus(); 

        System.out.println("Ingrese un numero del 1 al 10: ");

        v1.neutralizar((int)(Scanner.nextInt()));
        System.out.println(v1.toString());
        System.out.println("Ingrese un numero del 1 al 10: ");
        
        v2.neutralizar((int)(Scanner.nextInt()));
        
        if(v2.esNocivo()==true){
            System.out.println("el adn es correcto, no se expandio el virus por lo tanto no tiene nombre");
        }
        else{
            System.out.println("no se erradico el virus cuidado con: ");
            v2.setNombre(Scanner.nextLine());
        }
        System.out.println(v2.toString());
        Scanner.close();
    }
}
