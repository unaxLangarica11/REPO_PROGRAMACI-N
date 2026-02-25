package Utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDatos {

    private static final String URL = "";
    private static final String USER = "";
    private static final String PASS  ="";


    public static Connection getConnection() throws Exception{

        Class.forName();
        return DriverManager.getConnection(URL, USER, PASS);
    }


    public static void cerrarConnection(Connection conn) throws SQLException {

        conn.close();

    }
}
