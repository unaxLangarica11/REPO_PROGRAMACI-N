package DAO;

import Utilidades.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Modelo.*;

public class CuentaTitularDAO {

    public int obtenerIdByIban(String iban) {
        String sql = "SELECT id FROM cuentas_corrientes WHERE iban = ?";

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, iban);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }

            DBConnection.closeConnection();
        }
        catch (Exception e) {
            System.out.println("  Error al verificar si la cuenta existe: " + e.getMessage());
        }

        return -1;
    }

    public int  obtenerIdByDni(String dni) {
        String sql = "SELECT * FROM titulares WHERE dni = ?";

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }

            DBConnection.closeConnection();
        }
        catch (Exception e) {
            System.out.println("  Error al verificar si el titular existe: " + e.getMessage());
        }

        return -1;
    }

    public boolean asignarTitularACuenta(int idCuenta, int idTitular) {
        String sql = "INSERT INTO cuentas_titulares (id_cuenta, id_titular) VALUES (?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idCuenta);
            ps.setInt(2, idTitular);
            ps.executeUpdate();

            System.out.println("Titular asignado a cuenta correctamente.");

            DBConnection.closeConnection();
            return true;

        } catch (Exception e) {
            System.out.println("Error al asignar titular: " + e.getMessage());
            return false;
        }
    }


    public CuentaCorriente buscarCuentaPorIban(String iban) {
        String sql = "SELECT * FROM cuentas_corrientes WHERE iban = ?";

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, iban);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new CuentaCorriente(
                        rs.getInt("id"),
                        rs.getString("iban"),
                        rs.getDouble("saldo")
                );
            }

            DBConnection.closeConnection();
        }
        catch (Exception e) {
            System.out.println("  Error al verificar si la cuenta existe: " + e.getMessage());
        }

        return null;
    }

    public int eliminarTitulares(int idCuenta) {
        String sql = "DELETE FROM cuentas_titulares WHERE id_cuenta = ?";

        int n = 0;
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, idCuenta);
            n = ps.executeUpdate();

            System.out.println("Titulares eliminados correctamente.");
            DBConnection.closeConnection();

        }
        catch (Exception e) {
            System.out.println("Error al eliminar titulares: " + e.getMessage());
        }
        finally {
            return n;
        }
    }

    public int eliminarTitularDeCuenta(int idCuenta, int idTitular) {
        String sql = "DELETE FROM cuentas_titulares WHERE id_cuenta = ? AND id_titular = ?";

        int n = 0;
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, idCuenta);
            ps.setInt(2, idTitular);
            n = ps.executeUpdate();

            System.out.println("Titular eliminado de cuenta correctamente.");
            DBConnection.closeConnection();
        } catch (Exception e) {
            System.out.println("Error al eliminar titular de cuenta: " + e.getMessage());
        } finally {
            return n;
        }
    }

    public java.util.List<Titular> listarTitularesDeCuenta(int idCuenta) {
        String sql = "SELECT t.id, t.dni, t.nombre FROM titulares t " +
                "JOIN cuentas_titulares ct ON t.id = ct.id_titular " +
                "WHERE ct.id_cuenta = ?";

        java.util.List<Titular> titulares = new java.util.ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idCuenta);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Titular titular = new Titular(
                        rs.getInt("id"),
                        rs.getString("dni"),
                        rs.getString("nombre")
                );
                titulares.add(titular);
            }
            DBConnection.closeConnection();
        } catch (Exception e) {
            System.out.println("Error al listar titulares de cuenta: " + e.getMessage());
        }
        return titulares;
    }

    public java.util.List<CuentaCorriente> listarCuentasDeTitular(int idTitular) {
        String sql = "SELECT c.id, c.iban, c.saldo FROM cuentas_corrientes c " +
                "JOIN cuentas_titulares ct ON c.id = ct.id_cuenta " +
                "WHERE ct.id_titular = ?";

        java.util.List<CuentaCorriente> cuentas = new java.util.ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idTitular);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                CuentaCorriente cuenta = new CuentaCorriente(
                        rs.getInt("id"),
                        rs.getString("iban"),
                        rs.getDouble("saldo")
                );
                cuentas.add(cuenta);
            }
            DBConnection.closeConnection();
        } catch (Exception e) {
            System.out.println("Error al listar cuentas de titular: " + e.getMessage());
        }
        return cuentas;
    }

}
