public class Main {
    public static void main(String[] args) {
        Exprimidora E1 = new Exprimidora();
        Zanahoria Z1 = new Zanahoria("Zana",100);
        Naranja N1 = new Naranja("Nan",200);
        System.out.println(E1.extraerJugo(Z1));
        System.out.println(E1.extraerJugo(N1));
    }
}