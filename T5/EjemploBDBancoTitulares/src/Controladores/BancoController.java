package Controladores;

import DAO.CuentaCorrienteDAO;
import DAO.CuentaTitularDAO;
import DAO.TitularDAO;
import Modelo.CuentaCorriente;
import Modelo.Titular;

import java.util.List;

public class BancoController {
    private CuentaCorrienteDAO cuentaDAO;
    private TitularDAO titularDAO;
    private CuentaTitularDAO cuentaTitularDAO;

    public BancoController() {
        cuentaDAO = new CuentaCorrienteDAO();
        titularDAO = new TitularDAO();
        cuentaTitularDAO = new CuentaTitularDAO();
    }

    // Código de CuentaController

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


    // Código de TitularController
    public void crearTitular(String dni, String nombre) {
        Titular titular = new Titular(dni, nombre);
        titularDAO.insertar(titular);
    }

    public int borrarTitular(int id) throws Exception{
        // Implementar método para borrar titular por ID
        return titularDAO.borrar(id);
    }

    public void modificarTitular(Titular titular, String nuevoNombre) {
        // Implementar método para modificar titular por ID
        titular.setNombre(nuevoNombre);
        titularDAO.modificar(titular);
    }

    public Titular buscarPorDni(String dni) {
        return titularDAO.buscarPorDni(dni);
    }

    public List<Titular> listarTitulares() {

        return titularDAO.listarTodos();
    }

    public StringBuilder listarTitulares2()
    {
        // Más puro
        List<Titular> lista = titularDAO.listarTodos();
        StringBuilder sb = new StringBuilder();
        for (Titular t : lista) {
            sb.append(t.toString()).append("\n");
        }
        return sb;
    }

    public StringBuilder buscarPorNombre(String nombre)
    {
        // Más puro
        List<Titular> lista = titularDAO.buscarPorNombre(nombre);
        StringBuilder sb = new StringBuilder();
        for (Titular t : lista) {
            sb.append(t.toString()).append("\n");
        }
        return sb;
    }

    public Titular buscarPorId(int id) {

        return titularDAO.buscarPorId(id);
        // return titularDAO.buscarPorId(id).toString();
    }

    // Código de CuentaTitularController

    public int obtenerIdByIban(String iban) {
        return cuentaTitularDAO.obtenerIdByIban(iban);
    }

    public int obtenerIdByDni(String dni) {
        return cuentaTitularDAO.obtenerIdByDni(dni);
    }

    public  boolean asignarTitularACuenta(int idCuenta, int idTitular) {
        return cuentaTitularDAO.asignarTitularACuenta(idCuenta, idTitular);
        // Creación del objeto de tipo CuentaTitular con ids o con objetos
    }

    public int eliminarTitulares(int idCuenta){
        return cuentaTitularDAO.eliminarTitulares(idCuenta);
    }

    public int eliminarTitularDeCuenta(int idCuenta, int idTitular){
        return cuentaTitularDAO.eliminarTitularDeCuenta(idCuenta, idTitular);
        // Creación del objeto de tipo CuentaTitular con ids o con objetos
    }

    public String listarTitularesDeCuenta(int idCuenta) {
        StringBuilder sb = new StringBuilder();
        List<Titular> titulares = cuentaTitularDAO.listarTitularesDeCuenta(idCuenta);
        if (titulares != null)
            if (titulares.size() > 0) {
                titulares.forEach(t -> sb.append(t.toString()).append("\n"));
                return sb.toString();
            }
        return "No hay titulares asociados a esta cuenta.";
    }

    public String listarCuentasDeTitular(int idTitular) {
        StringBuilder sb = new StringBuilder();
        List<CuentaCorriente> cuentas = cuentaTitularDAO.listarCuentasDeTitular(idTitular);
        if (cuentas != null)
            if (cuentas.size() > 0) {
                cuentas.forEach(c -> sb.append(c.toString()).append("\n"));
                return sb.toString();
            }
        return "No hay cuentas asociadas a este titular.";
    }
}
