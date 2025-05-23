import java.util.Random;
public class Test {
public static void main (String[] args){
    matriz1 m = new matriz1(4, 4);
    for(int i=0;i<m.getcolumna();i++){
        for(int j=0;j<m.getfila();j++){
            m.setvalor(i, j, (char)new Random().nextInt(120));
        }
    }
    System.out.println("Original Matrix:");
    System.out.println(m.toString());
    //m.Espejo();
        m.maxpool(2);
    System.out.println("Maxpool Matrix:");
    
    System.out.println(m.toString());
    System.out.println(m.toString());
}
}