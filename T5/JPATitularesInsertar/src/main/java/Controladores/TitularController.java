package Controladores;

import DAO.*;
import Modelo.Titular;

import java.util.List;

public class TitularController {

    private TitularDAO titularDAO;

    public TitularController() {
        titularDAO = new TitularDAO();
    }

    public void crearTitular(String dni, String nombre) {
        Titular titular = new Titular(dni, nombre);
        titularDAO.insertar(titular);
    }

}

