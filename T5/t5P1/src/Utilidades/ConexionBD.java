package Utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL = "jdbc:mysql://localhost:3306/P1_aerolinea";
    private static final String USER = "root";
    private static final String PASSWORD = ""; //vacia por usar XAAMP
    private static Connection conexion = null;


    public static Connection getConnection() throws SQLException {

        conexion = DriverManager.getConnection(URL,USER,PASSWORD);

        return conexion;
    }

    public static void closeConnection() throws SQLException {
        conexion.close();

    }


}


