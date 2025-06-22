package biblioteca_app.datos;

import biblioteca_app.conexionDB.ConexionBDD;
import biblioteca_app.dominio.Prestamo;
import biblioteca_app.dominio.Usuario;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UsuarioDAO implements IUsuarioDAO{

    @Override
    public void agregarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios(dni, nombre, email, password, rol, fechaRegistro) "+
                "VALUES (?, ?, ?, ?, ?, ?)";

        String hashedPassword = BCrypt.hashpw(usuario.getPassword(),BCrypt.gensalt());
        try (
                Connection conn = ConexionBDD.getConexion();
                PreparedStatement ps = conn.prepareStatement(sql);
                ){

            ps.setString(1,usuario.getDni());
            ps.setString(2,usuario.getNombre());
            ps.setString(3,usuario.getEmail());
            ps.setString(4,hashedPassword);
            ps.setString(5,usuario.getRol());
            ps.setDate(6,usuario.getFechaRegistro());

            ps.execute();

        }catch (Exception e){
            System.out.println("error de conexion: "+e.getMessage());
        }
    }

    @Override
    public Usuario buscarPorId(int idUsuario) {
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        Usuario usuario = null;

        try (
             Connection conn = ConexionBDD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
            ){

            ps.setInt(1,idUsuario);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    usuario = new Usuario();

                    usuario.setId(rs.getInt("id"));
                    usuario.setDni(rs.getString("dni"));
                    usuario.setNombre(rs.getString("nombre"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setPassword(rs.getString("password"));
                    usuario.setRol(rs.getString("rol"));
                    usuario.setFechaRegistro(rs.getDate("fechaRegistro"));

                }
            }

        }catch (Exception e){
            System.out.println("error al buscar usuario: "+e.getMessage());
        }

        return usuario;
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        String sql = "UPDATE usuarios SET dni = ?, nombre = ?, email = ?, password = ?,rol = ?, fechaRegistro = ? WHERE id = ?";
        String hashedPassword = BCrypt.hashpw(usuario.getPassword(),BCrypt.gensalt());

        try (
             Connection conn = ConexionBDD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ){
            ps.setString(1,usuario.getDni());
            ps.setString(2,usuario.getNombre());
            ps.setString(3,usuario.getEmail());
            ps.setString(4,hashedPassword);
            ps.setString(5,usuario.getRol());
            ps.setDate(6,usuario.getFechaRegistro());
            ps.setInt(7,usuario.getId());

            ps.execute();
        }catch (Exception e){
            System.out.println("error en actualizar el usuario: "+e.getMessage());
        }
    }

    @Override
    public void eliminarUsuario(int idUsuario) {
        String sql = "DELETE FROM usuarios WHERE id = ?";

        try (
             Connection conn = ConexionBDD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ){

            ps.setInt(1,idUsuario);
            ps.execute();
        }catch (Exception e){
            System.out.println("error al eliminar usuario: "+e.getMessage());
        }
    }

    @Override
    public Usuario buscarPorDni(String dni) {
        String sql = "SELECT * FROM usuarios WHERE dni = ?";
        Usuario usuario = null;

        try (
                Connection conn = ConexionBDD.getConexion();
                PreparedStatement ps = conn.prepareStatement(sql);
        ){

            ps.setString(1,dni);

            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    usuario = new Usuario();

                    usuario.setId(rs.getInt("id"));
                    usuario.setDni(rs.getString("dni"));
                    usuario.setNombre(rs.getString("nombre"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setPassword(rs.getString("password"));
                    usuario.setRol(rs.getString("rol"));
                    usuario.setFechaRegistro(rs.getDate("fechaRegistro"));

                }

            }

        }catch (Exception e){
            System.out.println("error al buscar usuario: "+e.getMessage());
        }

        return usuario;
    }

    @Override
    public Usuario buscarPorEmail(String email) {
        String sql = "SELECT * FROM usuarios WHERE email = ?";
        Usuario usuario = null;

        try (
                Connection conn = ConexionBDD.getConexion();
                PreparedStatement ps = conn.prepareStatement(sql);
        ){

            ps.setString(1,email);

            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    usuario = new Usuario();

                    usuario.setId(rs.getInt("id"));
                    usuario.setDni(rs.getString("dni"));
                    usuario.setNombre(rs.getString("nombre"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setPassword(rs.getString("password"));
                    usuario.setRol(rs.getString("rol"));
                    usuario.setFechaRegistro(rs.getDate("fechaRegistro"));

                }

            }

        }catch (Exception e){
            System.out.println("error al buscar usuario: "+e.getMessage());
        }

        return usuario;
    }

    public List<Usuario> buscarPorNombre(String nombreParcial){
        String sql = "SELECT * FROM usuarios WHERE nombre LIKE = ?";
        List<Usuario>usuarios = new ArrayList<>();

        try (
             Connection conn = ConexionBDD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ){
             ps.setString(1,nombreParcial);

             try (ResultSet rs = ps.executeQuery()){

                 while (rs.next()){
                     Usuario usuario = new Usuario();

                     usuario.setId(rs.getInt("id"));
                     usuario.setNombre(rs.getString("nombre"));
                     usuario.setDni(rs.getString("dni"));
                     usuario.setEmail(rs.getString("email"));
                     usuario.setPassword(rs.getString("password"));
                     usuario.setRol(rs.getString("rol"));
                     usuario.setFechaRegistro(rs.getDate("fechaRegistro"));

                     usuarios.add(usuario);
                 }

             }
        }catch (Exception e){
            System.out.println("error al buscar nombre: "+e.getMessage());
        }

        return usuarios;
    }

    @Override
    public List<Usuario> listarTodos() {
        String sql = "SELECT * FROM usuarios ORDER BY id";
        List<Usuario>usuarios = new ArrayList<>();

        try (Connection conn = ConexionBDD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             ){
            while (rs.next()){
                Usuario usuario = new Usuario();

                usuario.setId(rs.getInt("id"));
                usuario.setDni(rs.getString("dni"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setEmail(rs.getString("email"));
                usuario.setPassword(rs.getString("password"));
                usuario.setRol(rs.getString("rol"));
                usuario.setFechaRegistro(rs.getDate("fechaRegistro"));

                usuarios.add(usuario);
            }

        }catch (Exception e){
            System.out.println("error al generar lista: "+e.getMessage());
        }


        return usuarios;
    }

    @Override
    public List<Usuario> listarPorRol(String rol) {
        String sql = "SELECT * FROM usuarios WHERE rol = ?";
        List<Usuario>usuarios = new ArrayList<>();

        try (Connection conn = ConexionBDD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
        ){
            ps.setString(1,rol);
            try (ResultSet rs = ps.executeQuery();) {

                while (rs.next()) {
                    Usuario usuario = new Usuario();

                    usuario.setId(rs.getInt("id"));
                    usuario.setDni(rs.getString("dni"));
                    usuario.setNombre(rs.getString("nombre"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setPassword(rs.getString("password"));
                    usuario.setRol(rs.getString("rol"));
                    usuario.setFechaRegistro(rs.getDate("fechaRegistro"));

                    usuarios.add(usuario);
                }

            }

        }catch (Exception e){
            System.out.println("error al generar lista: "+e.getMessage());
        }

        return usuarios;
    }

    @Override
    public boolean existeUsuario(String dni, String email) {
        String sql = "SELECT COUNT(*) FROM usuarios WHERE dni = ? OR email = ?";
        try (Connection conn = ConexionBDD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, dni);
            ps.setString(2, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;  // True si existe al menos un registro.
                }
            }
        } catch (Exception e) {
            System.out.println("Error en existeUsuario: " + e.getMessage());
        }
        return false;
    }

    public boolean verificarPassword(String email, String passwordIngresada) {
        String sql = "SELECT password FROM usuarios WHERE email = ?";
        try (Connection conn = ConexionBDD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String hashGuardado = rs.getString("password");
                    return BCrypt.checkpw(passwordIngresada, hashGuardado);
                }
            }
        } catch (Exception e) {
            System.out.println("Error al verificar contraseña: " + e.getMessage());
        }
        return false;
    }

    // actualizaciones especificas

    public void actualizarPassword(int idUsuario, String nuevaPassword) {
        String sql = "UPDATE usuarios SET password = ? WHERE id = ?";
        try (Connection conn = ConexionBDD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            String hashedPassword = BCrypt.hashpw(nuevaPassword, BCrypt.gensalt());
            ps.setString(1, hashedPassword);
            ps.setInt(2, idUsuario);
            ps.execute();
        } catch (Exception e) {
            System.out.println("Error al actualizar contraseña: " + e.getMessage());
        }
    }

    public void actualizarEmail(int idUsuario, String nuevoEmail){
        String sql = "UPDATE usuarios SET email = ? WHERE id = ?";
        try (Connection conn = ConexionBDD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nuevoEmail);
            ps.setInt(2, idUsuario);
            ps.execute();
        } catch (Exception e) {
            System.out.println("Error al actualizar email: " + e.getMessage());
        }
    }

    public void actualizarNombre(int idUsuario, String nuevoNombre){
        String sql = "UPDATE usuarios SET nombre = ? WHERE id = ?";
        try (Connection conn = ConexionBDD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nuevoNombre);
            ps.setInt(2, idUsuario);
            ps.execute();
        } catch (Exception e) {
            System.out.println("Error al actualizar email: " + e.getMessage());
        }
    }

    public void actualizarDni(int idUsuario, String nuevoDni){
        String sql = "UPDATE usuarios SET dni = ? WHERE id = ?";
        try (Connection conn = ConexionBDD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nuevoDni);
            ps.setInt(2, idUsuario);
            ps.execute();
        } catch (Exception e) {
            System.out.println("Error al actualizar email: " + e.getMessage());
        }
    }

    public void actualizarRol(int idUsuario, String nuevoRol){
        String sql = "UPDATE usuarios SET rol = ? WHERE id = ?";
        try (Connection conn = ConexionBDD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nuevoRol);
            ps.setInt(2, idUsuario);
            ps.execute();
        } catch (Exception e) {
            System.out.println("Error al actualizar email: " + e.getMessage());
        }
    }

    public void actualizarFechaRegistro(int idUsuario, Date nuevaFechaRegistro){
        String sql = "UPDATE usuarios SET fechaRegistro = ? WHERE id = ?";
        try (Connection conn = ConexionBDD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDate(1, (java.sql.Date) nuevaFechaRegistro);
            ps.setInt(2, idUsuario);
            ps.execute();
        } catch (Exception e) {
            System.out.println("Error al actualizar email: " + e.getMessage());
        }
    }

}
