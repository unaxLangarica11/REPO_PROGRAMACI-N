package DAO;

import Modelo.Pasajero;
import Modelo.Vuelo;
import Utilidades.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PasajeroDAO {


    public static void insertarPasajero(Pasajero pasajero) {
        String sql = "INSERT INTO pasajeros (dni,nombre,telefono) VALUES(?,?,?)";

        try {

            Connection conexion = ConexionBD.getConnection();
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setString(1, pasajero.getDni());
            ps.setString(2, pasajero.getNombre());
            ps.setString(3, pasajero.getTelefono());

            ps.executeUpdate();

            System.out.println("Se ha insertado el pasajero correctamente");

            ConexionBD.closeConnection();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void eliminarPasajero(String dni) throws SQLException {
        String sql = "DELETE FROM pasajeros WHERE dni = ?";

        try {

            Connection conexion = ConexionBD.getConnection();
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setString(1, dni);

            int numBorrados = ps.executeUpdate();

            if (numBorrados != 1) {

                throw new Exception("No se pudo eliminar el pasajero");
            }

            System.out.println("Pasajero eliminado correctamente");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        ConexionBD.closeConnection();
    }


    public static void updatePasajero(Pasajero pasajero) throws SQLException {

        String sql = "UPDATE pasajeros SET nombre = ?, telefono = ?  WHERE dni = ?";

        try {
            Connection conexion = ConexionBD.getConnection();
            PreparedStatement ps = conexion.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        ConexionBD.closeConnection();


    }


    public Pasajero selectPasajerosPorDni(String dni) {

        String sql = "SELECT * FROM pasajeros WHERE dni = ?";

        Pasajero pasajero = null;

        try {

            Connection conexion = ConexionBD.getConnection();
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setString(1, pasajero.getDni());
            ResultSet rs = ps.executeQuery();

            ArrayList<Pasajero> listaPasajeros = new ArrayList<>();

            if (rs.next()) {

                new Pasajero(
                        rs.getString("dni"),
                        rs.getString("nombre"),
                        rs.getString("telefono")
                );
            }

            ConexionBD.closeConnection();
            return pasajero;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        return null;

    }

    public Vuelo selectVueloPasajero(String dni) {
        String sql = "SELECT v.cod_vuelo FROM vuelos v JOIN pasajeros p WHERE dni = ?";

        Vuelo vuelo = null;

        try {

            Connection conexion = ConexionBD.getConnection();
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, pasajero.getDni());
            ResultSet rs = ps.executeQuery();


            ConexionBD.closeConnection();

            return vuelo;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public ArrayList<Pasajero> selectListarPasajerosPorVuelo(int codVuelo) {
        String sql = "SELECT p.nombre, v.cod_vuelo " +
                "FROM vuelos v JOIN pasajeros p ON v.cod_vuelo = p.cod_vuelo " +
                "WHERE cod_vuelo = ?";

        ArrayList<Pasajero> listaPasajeros = new ArrayList<>();



        try{
            Connection conexion = ConexionBD.getConnection();
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                listaPasajeros.add(new Pasajero(
                        rs.getString("dni"),
                        rs.getString("nombre"),
                        rs.getString("telefono")
                ));

                ConexionBD.closeConnection();
            }


        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
