package biblioteca_app.datos;

import biblioteca_app.dominio.Usuario;

import java.util.Date;
import java.util.List;

public interface IUsuarioDAO {

    // CRUD Básico
    void agregarUsuario(Usuario usuario);
    Usuario buscarPorId(int idUsuario);
    void actualizarUsuario(Usuario usuario);
    void eliminarUsuario(int idUsuario);

    // Búsquedas Específicas
    Usuario buscarPorDni(String dni);
    Usuario buscarPorEmail(String email);
    List<Usuario> buscarPorNombre(String nombreParcial);

    // Listados con Filtros
    List<Usuario> listarTodos();
    List<Usuario> listarPorRol(String rol);  // Enum: ADMIN, BIBLIOTECARIO, CLIENTE

    // Validación
    boolean existeUsuario(String dni, String email);
    boolean verificarPassword(String email,String password);

    //Actualizaciones especificas
    void actualizarDni(int idUsuario,String nuevoDni);
    void actualizarNombre(int idUsuario,String nuevoNombre);
    void actualizarEmail(int idUsuario,String nuevoEmail);
    void actualizarPassword(int idUsuario,String nuevaPassword);
    void actualizarRol(int idUsuario,String nuevoRol);
    void actualizarFechaRegistro(int idUsuario, Date nuevaFechaRegistro);

}
