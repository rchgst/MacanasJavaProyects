public class Test {
    public static void main(String[] args){
        // Crear instancias de las clases
        Elecciones elecciones = new Elecciones();
        
        elecciones.SetNombreEleccion ("Exactas 2025");
        // Agregar candidatos y personas a las elecciones
        elecciones.AgregaCandidatos(new Candidatos("Juan Perez", "12345678", 0));
        elecciones.AgregaAlumnmo(new Alumno("Maria Lopez", "87654321", 12345, 3, true));
        elecciones.AgregaDocente(new Docente("Pedro Garcia", "23456789", true, "Matematica"));
        elecciones.AgregaPersonal(new Personal("Ana Torres", "34567890", "Administrativo"));
        // Verificar aptos para votar
        // Mostrar información de la persona    
        System.out.println("Nombre de la elección: " + elecciones.GetNombreEleccion());
        System.out.println("Cantidad de alumnos aptos para votar: %" + elecciones.CuantosvotanAlu());
        System.out.println("Cantidad de docentes aptos para votar: %" + elecciones.CuantosvotanDoc());

    }
}
