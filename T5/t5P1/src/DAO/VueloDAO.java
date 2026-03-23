package DAO;

import Modelo.Vuelo;
import Utilidades.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VueloDAO {

    public void insertarVuelo(Vuelo vuelo) {
        String sql = "INSERT INTO vuelos (codVuelo, fechaSalida,destino, procedencia) VALUES(?,?,?,?)";

        try{

            Connection conexion = ConexionBD.getConnection();
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setString(1, vuelo.getCodVuelo());
            ps.setString(2, vuelo.getFechaSalida().toString());
            ps.setString(3, vuelo.getDestino());
            ps.setString(4, vuelo.getProcedencia());

            ps.executeUpdate();

            System.out.println("Se ha insertado el vuelo correctamente");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void eliminarVuelo(int codVuelo) throws SQLException {
        String sql = "DELETE FROM vuelos WHERE codVuelo = ?";

        try{

            Connection conexion = ConexionBD.getConnection();
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setInt(1, codVuelo);

            int numBorrados = ps.executeUpdate();

            if (numBorrados != 1) {

                throw new Exception("No se pudo eliminar el vueo");
            }

            System.out.println("Vuelo eliminado correctamente");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        ConexionBD.closeConnection();
    }

    public void modificarVuelo(Vuelo vuelo) throws SQLException {

        String sql = "UPDATE vuelos SET fechaSalida = ?, destino = ?, procedencia = ? WHERE codVuelo = ?";

        try{
            Connection conexion = ConexionBD.getConnection();
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setDate(1,vuelo.getFechaSalida());
            ps.setString(2,vuelo.getDestino());
            ps.setString(3, vuelo.getProcedencia());

            ps.executeUpdate();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        ConexionBD.closeConnection();


    }

    public Vuelo selectVueloPorCodigo(int codVuelo) throws SQLException {
        String sql = "SELECT * FROM vuelos WHERE cod_vuelo = ?";

        Vuelo vuelo = null;

        try{

            Connection conexion = ConexionBD.getConnection();
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setString(1, vuelo.getCodVuelo());
            ResultSet rs = ps.executeQuery();

            ConexionBD.closeConnection();

            if (rs.next()) {
                return new Vuelo(
                        rs.getString("codVuelo"),
                        rs.getDate("fechaSalida").toLocalDate(),
                        rs.getString("destino"),
                        rs.getString("procedencia")
                );
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;

    }


    public Vuelo selectVueloPorDestino(String destino) {
        String sql = "SELECT * FROM vuelos WHERE destino = ?";

        Vuelo vuelo = null;

        try{
            Connection conexion = ConexionBD.getConnection();
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setString(1, destino);

            ResultSet rs = ps.executeQuery();

            ConexionBD.closeConnection();


        }catch (Exception e){

            System.out.println(e.getMessage());
        }

        return vuelo;
    }

    public Vuelo selectVueloPorOrigen(String origen) {
        String sql = "SELECT cod_vuelo FROM vuelos WHERE procedencia = ?";
        Vuelo vuelo = null;


        try{
            Connection conexion = ConexionBD.getConnection();
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, origen);

            ResultSet rs = ps.executeQuery();

            ConexionBD.closeConnection();

            return vuelo;

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return null;
    }

    public static List<Vuelo> listarVuelosPorFecha(LocalDate fechaSalida) {
        String sql = "SELECT cod_vuelo FROM vuelos WHERE fecha_salida = ?";
        List<Vuelo> listaVuelos = null;

        try{

            Connection coonexion = ConexionBD.getConnection();
            PreparedStatement ps = coonexion.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                listaVuelos.add(new Vuelo(
                        rs.getString("cod_vuelo"),
                        rs.getDate("fechaSalida").toLocalDate(),
                        rs.getString("destino"),
                        rs.getString("procedencia"))
                );

            }

            return listaVuelos;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return null;
    }


}






