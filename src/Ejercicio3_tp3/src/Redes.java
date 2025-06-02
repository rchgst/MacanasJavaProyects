public class Redes {
    public static void main(String[] args) {
        Red red1, red2, red3;
        Router r1, r2;
        Host h11, h12, h21, h22, h31, h32;

        // Creamos las redes
        red1 = new Red(new Direccion(192, 0));
        red2 = new Red(new Direccion(128, 0));
        red3 = new Red(new Direccion(10, 0));

        // Creamos los hosts
        h11 = new Host(new Direccion(192, 1));
        h12 = new Host(new Direccion(192, 2));
        h21 = new Host(new Direccion(128, 1));
        h22 = new Host(new Direccion(128, 2));
        h31 = new Host(new Direccion(10, 1));
        h32 = new Host(new Direccion(10, 2));

        // Conectamos los hosts a las redes
        red1.conectar(h11); h11.conectar(red1);
        red1.conectar(h12); h12.conectar(red1);
        red2.conectar(h21); h21.conectar(red2);
        red2.conectar(h22); h22.conectar(red2);
        red3.conectar(h31); h31.conectar(red3);
        red3.conectar(h32); h32.conectar(red3);

        // Creamos los Routers
        r1 = new Router(new Direccion(172, 0), 3);
        r2 = new Router(new Direccion(225, 0), 3);

        // Conectamos los Routers y las redes
        r1.conectar(red1); red1.conectar(r1);
        r1.conectar(red2); red2.conectar(r1);
        r1.conectar(r2);   r2.conectar(r1);
        r2.conectar(red3); red3.conectar(r2);
    }
}
