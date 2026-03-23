package Controladores;

import DAO.CuentaTitularDAO;
import Modelo.Titular;

public class CuentaTitularController {
    private CuentaTitularDAO cuentaTitularDAO;

    public CuentaTitularController() {
        cuentaTitularDAO= new CuentaTitularDAO();
    }

    public int obtenerIdByIban(String iban) {
        return cuentaTitularDAO.obtenerIdByIban(iban);
    }

    public int obtenerIdByDni(String dni) {
        return cuentaTitularDAO.obtenerIdByDni(dni);
    }

    public  boolean asignarTitularACuenta(int idCuenta, int idTitular) {
        return cuentaTitularDAO.asignarTitularACuenta(idCuenta, idTitular);
    }

}
