package gestor_libros.presentacion;

import gestor_libros.datos.ILibroDAO;
import gestor_libros.datos.LibroDAO;
import gestor_libros.dominio.Libro;
import java.util.Scanner;
import java.util.List;

public class GestorDeLibroApp {

    public static int menu(Scanner consola){
        System.out.println("""
                ______________ menu de opciones ______________
                
                opcion 1: listar todos los libros
                opcion 2: ingresar un libro
                opcion 3: buscar un libro por id
                opcion 4: actualizar un libro
                opcion 5: eliminar un libro
                opcion 6: salir de la aplicacion
                
                elija una opcion:
                _____________________________________________""");
        return Integer.parseInt(consola.nextLine());
    }

    public static boolean ejecutarOpcion(Scanner consola, int opcion, ILibroDAO libroDAO){
        boolean seguir = true;

        switch (opcion){
            case 1:
                List<Libro> libros = libroDAO.lista();
                libros.forEach(System.out :: println);
                break;
            case 2:
                System.out.print("ingrese el titulo: ");
                String titulo = consola.nextLine();
                System.out.println();

                System.out.print("ingrese el nombre del autor: ");
                String autor = consola.nextLine();
                System.out.println();

                System.out.print("ingrese el anio de emision: ");
                int anio = consola.nextInt();
                consola.nextLine();
                System.out.println();

                System.out.print("ingrese el codigo isbn: ");
                String isbn = consola.nextLine();
                System.out.println();

                Libro libro = new Libro(anio,titulo,autor,isbn);
                libroDAO.insertaLibro(libro);
                break;
            case 3:
                System.out.println("ingrese el id a buscar: ");
                int idd = Integer.parseInt(consola.nextLine());
                Libro libro2 = libroDAO.buscarId(new Libro(idd));
                System.out.println("datos del libro: \n"+libro2);
                break;
            case 4:
                System.out.println("ingrese el id del libro que desea modificar: ");
                int id2 = Integer.parseInt(consola.nextLine());

                System.out.println("ingrese los nuevos datos del libro: ");
                System.out.println();

                System.out.println("ingrese el titulo: ");
                String titulo1 = consola.nextLine();

                System.out.println("ingrese el autor: ");
                String autor1 = consola.nextLine();

                System.out.println("ingrese el anio de emision: ");
                int anio1 = Integer.parseInt(consola.nextLine());

                System.out.println("ingrese el isbn: ");
                String isbn1 = consola.nextLine();

                libroDAO.actualizaLibro(new Libro(id2,anio1,titulo1,autor1,isbn1));

                break;
            case 5:
                System.out.println("ingrese el id a eliminar: ");
                int id = Integer.parseInt(consola.nextLine());
                Libro libro1 = libroDAO.buscarId(new Libro(id));
                libroDAO.eliminaLibro(libro1);
                break;
            case 6:
                System.out.println("saliendo del programa hasta luego");
                return false;
        }

        return seguir;
    }

    public static void gestorDeLibrosApp(){
        boolean seguir = true;

        try (Scanner consola = new Scanner(System.in)) {
            while (seguir) {
                int opcion = menu(consola);
                ILibroDAO libroDAO = new LibroDAO();

                seguir = ejecutarOpcion(consola, opcion, libroDAO);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
