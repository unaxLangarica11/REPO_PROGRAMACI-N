package Controladores;

import DAO.CuentaCorrienteDAO;
import Modelo.CuentaCorriente;

import java.util.List;

public class CuentaController {
    private CuentaCorrienteDAO cuentaDAO;

    public CuentaController() {
        cuentaDAO = new CuentaCorrienteDAO();
    }

    public void crearCuenta(String isbn, Double saldo) {
        CuentaCorriente cuenta = new CuentaCorriente(isbn,saldo);
        cuentaDAO.insertar(cuenta);
    }

    public void modificarCuenta(CuentaCorriente cuenta, Double nuevoSaldo) {
        cuenta.setSaldo(nuevoSaldo);
        cuentaDAO.modificar(cuenta);
    }

    public CuentaCorriente buscarCuentaPorIban(String iban) {
        CuentaCorriente cuenta = cuentaDAO.buscarPorIban(iban);
        return cuenta;
    }

    public int eliminarCuenta(String iban) {
        return cuentaDAO.borrar(iban);
    }

    public String listarCuentas() {
        StringBuilder sb = new StringBuilder();
        List<CuentaCorriente> cuentas = cuentaDAO.listarTodas();
        if (cuentas != null)
            if (cuentas.size() > 0) {
                cuentas.forEach(c -> sb.append(c.toString()).append("\n"));
                return sb.toString();
            }
        return "No hay cuentas registradas.";
    }

    public String listarCuentasPorSaldo(Double saldoMinimo) {
        StringBuilder sb = new StringBuilder();
        List<CuentaCorriente> cuentas = cuentaDAO.listarPorSaldo(saldoMinimo);
        if (cuentas != null)
            if (cuentas.size() > 0) {
                cuentas.forEach(c -> sb.append(c.toString()).append("\n"));
                return sb.toString();
            }
        return "No hay cuentas con saldo superior a " + saldoMinimo;
    }

}
