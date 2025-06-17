package gestor_libros.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionDB {
    public static Connection getConexion(){
        Connection connection = null;

        String url = "jdbc:mysql://localhost:3306/gestor_libros_db";
        String usuario = "root";
        String password = "rchsqladmin!";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,usuario,password);
        }catch (Exception e){
            System.out.println(e);
        }

        return connection;
    }

}
