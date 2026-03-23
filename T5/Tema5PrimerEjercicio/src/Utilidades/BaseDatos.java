package Utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDatos {

    private static final String URL = "";
    private static final String USER = "";
    private static final String PASS  ="";
    private static Connection conexion =null;


    public static Connection getConnection() throws Exception{

        conexion = DriverManager.getConnection(URL, USER, PASS);
        return conexion;
    }


    public static void closeConnection() throws SQLException {

        conexion.close();

    }


}
