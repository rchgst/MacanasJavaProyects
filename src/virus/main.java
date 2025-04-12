package virus;
import java.util.*;
public class main {
    public static void main(String[] args) {
        virus covid;
        Scanner consola;
        System.out.println("ingrese un numero del 1 al 10 para intentar neutralizar el virus");
        consola = new Scanner(System.in);
        int adnNeutralizante = consola.nextInt();   
        covid = new virus();
        covid.neutralizar(adnNeutralizante);
    }
    
}
