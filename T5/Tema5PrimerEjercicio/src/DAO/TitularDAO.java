package DAO;

import Modelo.*;
import Utilidades.BaseDatos;

import java.sql.*;
import java.util.ArrayList;

public class TitularDAO {



    public void insertar(Titular titular){

        String sql = "insert into titulares (dni, nombre) values (?,?)";

        try{

            Connection conexion = BaseDatos.getConnection();
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setString(1, titular.getDni());
            ps.setString(2, titular.getNombre());

            ps.executeUpdate;



        }catch (Exception e){
            e.getMessage();

        }finally {

            System.out.println("El titular ha sifo insertado correctamente, cerrando base de datos.");
            BaseDatos.closeConnection();

        }
    }

    public int borrar(int id) throws Exception{

        String sql = "DELETE FROM titulares WHERE id = ?";

        int numBorrados = 0;

        try{

            Connection conexion = BaseDatos.getConnection();
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setInt(1, id);

            numBorrados = ps.executeUpdate();

            if (numBorrados != 1){

                System.out.println("No se puede borrar el titular");
            }else{
                System.out.println("El titular ha sido eliminado");

            }



        }catch(Exception e){

            e.getMessage();
        }finally {

            BaseDatos.closeConnection();
            return numBorrados;

        }

    }

    public Titular buscarPorID(int id){

        String sql = "SELECT * FROM titulares WHERE id = ?";

        try{
            Connection conexion = BaseDatos.getConnection();
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Titular(
                        rs.getInt("id"),
                        rs.getString("dni"),
                        rs.getString("nombre")
                );
            }
            BaseDatos.closeConnection();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;

    }


    public ArrayList<Titular> buscarPorNombre(String nombre){

        String sql = "SELECT * FROM titulares WHERE nombre = ?";

        try {

            Connection conexion = BaseDatos.getConnection();
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setString

        }catch(Exception e){
            System.out.println(e.getMessage);
            
        }

    }

}
