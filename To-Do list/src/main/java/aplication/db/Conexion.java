package aplication.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    public static Connection getConexion(){
        String url = "jdbc:mysql://localhost:3306/tareas_db";
        String usuario = "root";
        String password = "rchsqlasmin!";

        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,usuario,password);
        }catch (Exception e){
            System.out.println("error al hacer la conexion");
        }

        return con;
    }

}
