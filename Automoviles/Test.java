public class Test {
    public static void main (String[] args){
        Automoviles autos= new Automoviles(133);
        Automovil auto0= new Automovil(new Motor(1.5, 0.5, true), new Tanque(50, 50, false), 0, new Corredor("Juan"));
        Automovil auto1= new Automovil(new Motor(3.4, 0.75, true), new Tanque(50, 50, false), 0, new Corredor("Pedro"));
        Automovil auto2= new Automovil(new Motor(2.0, 0.4, true), new Tanque(50, 50, false), 0, new Corredor("Luis"));
        autos.agregaalinea(auto0);
        autos.agregaalinea(auto1);
        autos.agregaalinea(auto2);
        System.out.println("Los autos en linea son: Corredor 1\n"+auto0.getPiloto()+"\nCorredor 2\n"+auto1.getPiloto()+"\nCorredor 3\n"+auto2.getPiloto());
        System.out.println("-----------------------"); 
        System.out.println("La carrera esta apunto de comenzar. . . . . ¡¡¡BANG!!!\n");
        autos.simulacion();
        System.out.println("-----------------------");
        System.out.println("El auto 1 ha recorrido: " + auto0.getRecorrido() + " km\n");
        System.out.println("-----------------------");
        System.out.println("El auto 2 ha recorrido: " + auto1.getRecorrido() + " km\n");
        System.out.println("-----------------------");
        System.out.println("El auto 3 ha recorrido: " + auto2.getRecorrido() + " km\n");
        System.out.println("-----------------------");
    }
    
}
