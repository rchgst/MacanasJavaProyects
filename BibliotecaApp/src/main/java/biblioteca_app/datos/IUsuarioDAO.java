package biblioteca_app.datos;

import biblioteca_app.dominio.Usuario;

import java.util.List;

public interface IUsuarioDAO {

    // CRUD Básico
    void agregarUsuario(Usuario usuario);
    Usuario buscarPorId(int idUsuario);
    void actualizarUsuario(Usuario usuario);
    void eliminarUsuario(int idUsuario);  // O desactivarUsuario(int idUsuario)

    // Búsquedas Específicas
    Usuario buscarPorDni(String dni);
    Usuario buscarPorEmail(String email);

    // Listados con Filtros
    List<Usuario> listarTodos();
    List<Usuario> listarPorRol(String rol);  // Enum: ADMIN, BIBLIOTECARIO, CLIENTE

    // Validación
    boolean existeUsuario(String dni, String email);

}
