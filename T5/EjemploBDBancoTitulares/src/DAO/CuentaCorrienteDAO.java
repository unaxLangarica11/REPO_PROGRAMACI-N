package DAO;

import Modelo.CuentaCorriente;
import Utilidades.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class CuentaCorrienteDAO {

    public void insertar(CuentaCorriente cuenta) {
        String sql = "INSERT INTO cuentas_corrientes (iban, saldo) VALUES (?, ?)";

        try
        {
            Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, cuenta.getIban());
            ps.setDouble(2, cuenta.getSaldo());
            ps.executeUpdate();

            /*
                Mensaje para nosotros. No para el usuario final.
                En un proyecto real, esto se manejaría con logs o se mostraría en la interfaz de usuario.
             */

            System.out.println("Cuenta insertada correctamente.");
            DBConnection.closeConnection();

        }
        catch (Exception e)
        {
            System.out.println("Error al insertar cuenta: " + e.getMessage());
        }
    }

    public void modificar(CuentaCorriente cuenta) {
        String sql = "UPDATE cuentas_corrientes SET saldo = ? WHERE iban = ?";

        try
        {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDouble(1, cuenta.getSaldo());
            ps.setString(2, cuenta.getIban());
            int n = ps.executeUpdate();

            // no es necesario porque hemos buscado
            /*if (n != 1) {
                System.out.println("Cuenta no modificada.");
                throw new Exception(" No se encontró ninguna cuenta con el IBAN proporcionado.");
            }*/
            System.out.println("Cuenta modificada correctamente.");
            DBConnection.closeConnection();

        }
        catch (Exception e)
        {
            System.out.println("Error al modificar cuenta: " + e.getMessage());
        }
    }

    public CuentaCorriente buscarPorIban(String iban) {
        String sql = "SELECT * FROM cuentas_corrientes WHERE iban = ?";
        CuentaCorriente cuenta = null;

        try
        {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, iban);
            var rs = ps.executeQuery();

            if (rs.next()) {
                cuenta = new CuentaCorriente(rs.getInt("id" ),rs.getString("iban"), rs.getDouble("saldo"));
            }

            DBConnection.closeConnection();

        }
        catch (Exception e)
        {
            System.out.println("Error al buscar cuenta por IBAN: " + e.getMessage());
        }

        return cuenta;
    }

    public int borrar(String iban) {
        String sql = "DELETE FROM cuentas_corrientes WHERE iban = ?";
        int n = 0;

        try
        {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, iban);
            n = ps.executeUpdate();

            if (n != 1) {
                System.out.println("Cuenta no borrada.");
                throw new Exception(" No se encontró ninguna cuenta con el IBAN proporcionado.");
            }
            System.out.println("Cuenta borrada correctamente.");
            DBConnection.closeConnection();

        }
        catch (Exception e)
        {
            System.out.println("Error al borrar cuenta: " + e.getMessage());
        }
        finally
        {
            return n;
        }
    }

    public List<CuentaCorriente> listarTodas() {
        try{
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM cuentas_corrientes");
            var rs = ps.executeQuery();

            List<CuentaCorriente> cuentas = new java.util.ArrayList<>();

            while (rs.next()) {
                cuentas.add(new CuentaCorriente(rs.getInt("id" ),rs.getString("iban"), rs.getDouble("saldo")));
            }

            DBConnection.closeConnection();
            return cuentas;

        }
        catch (Exception e)
        {
            System.out.println("Error al listar cuentas: " + e.getMessage());
            return null;
        }
    }

    public List<CuentaCorriente> listarPorSaldo(Double saldoMinimo) {
        String sql = "SELECT * FROM cuentas_corrientes WHERE saldo > ?";
        try{
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, saldoMinimo);
            var rs = ps.executeQuery();

            List<CuentaCorriente> cuentas = new java.util.ArrayList<>();

            while (rs.next()) {
                cuentas.add(new CuentaCorriente(rs.getInt("id" ),rs.getString("iban"), rs.getDouble("saldo")));
            }

            DBConnection.closeConnection();
            return cuentas;

        }
        catch (Exception e)
        {
            System.out.println("Error al listar cuentas por saldo: " + e.getMessage());
            return null;
        }
    }
}

