package biblioteca_app.conexionDB;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBDD {

    public static Connection getConexion(){
        Connection conn = null;

        String url = "jdbc:mysql://localhost:3306/libros";
        String usuario = "root";
        String password = "rchsqladmin!";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,usuario,password);
        }catch (Exception e){
            System.out.println("error al hacer la conexion: "+e.getMessage());
        }

        return conn;
    }



}
