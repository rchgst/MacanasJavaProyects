import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Crear obras sociales
        ObraSocial os1 = new ObraSocial(201, "OSDE", "Salta 123");
        ObraSocial os2 = new ObraSocial(202, "Swiss Medical", "Buenos Aires 456");

        // Crear pacientes
        Paciente p1 = new Paciente(1001, "Juan Pérez", 'M', new Fecha(1990, 5, 10), os1);
        Paciente p2 = new Paciente(1002, "Ana Gómez", 'F', new Fecha(1985, 8, 22), os2);

        // Crear profesionales
        Profesional prof1 = new Profesional(12345, "Dr. House", 'M', new Fecha(1970, 3, 15),55);
        Profesional prof2 = new Profesional(54321, "Dra. Grey", 'F', new Fecha(1980, 11, 30),56);

        // Crear cirugías
        Cirugia c1 = new Cirugia(1, "Apendicitis", p1, prof1, new Fecha(2024, 6, 15), 90);
        Cirugia c2 = new Cirugia(2, "Bypass gástrico", p2, prof2, new Fecha(2024, 7, 10), 120);
        Cirugia c3 = new Cirugia(3, "Colecistectomía", p1, prof1, new Fecha(2025, 2, 20), 60);

        // Crear colección de cirugías
        Cirugias lista = new Cirugias();

        // Insertar cirugías
        lista.insertarCirugia(c1);
        lista.insertarCirugia(c2);
        lista.insertarCirugia(c3);

        // Mostrar promedio de duración
        System.out.println("Promedio de duración total: " + lista.promedioDuracion());

        // Promedio entre fechas
        System.out.println("Promedio entre junio 2024 y diciembre 2024: " +
                lista.promedioDuracion(new Fecha(2024, 6, 1), new Fecha(2024, 12, 31)));

        // Promedio por edad (mayores de 30)
        System.out.println("Promedio de duración en mayores de 30 años: " +
                lista.promedioDuracion(30));

        // Mostrar cirugías de un profesional
        Cirugias delDrHouse = lista.cirugiasPrestador("Dr. House");
        System.out.println("Cantidad de cirugías del Dr. House: " + delDrHouse.getCantidad());

        // Mostrar cirugías por obra social
        Cirugias deOsde = lista.cirugiasOS("OSDE");
        System.out.println("Cantidad de cirugías con OSDE: " + deOsde.getCantidad());


        /* implementar el siguiente metodo, no lo hice por flojera xdxdxxd*/

        // Cirugías de un paciente
        //Cirugias deJuan = lista.cirugiasPcte(p1);
        //System.out.println("Cantidad de cirugías realizadas a Juan Pérez: " + deJuan.getCantidad());

        // Eliminar cirugías de una obra social
        lista.eliminarCirugia("OSDE");
        System.out.println("Cantidad luego de eliminar OSDE: " + lista.getCantidad());
    }
}