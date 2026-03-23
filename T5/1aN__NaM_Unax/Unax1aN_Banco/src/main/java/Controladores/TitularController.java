package Controladores;

import DAO.TitularDAO;
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

    public Titular buscarPorDni(String dni) {
        return titularDAO.buscarPorDni(dni);
    }

    public void modificarTitular(Titular titular, String nuevoNombre) {
        // Implementar método para modificar titular por ID
        titular.setNombre(nuevoNombre);
        titularDAO.modificar(titular);
    }

    public void borrarTitular(int id) throws Exception{
        // Implementar método para borrar titular por ID
        titularDAO.borrar(id);
    }

    public StringBuilder listarTitulares()
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
        List<Titular> lista = titularDAO.buscarPorNombre(nombre);
        StringBuilder sb = new StringBuilder();
        for (Titular t : lista) {
            sb.append(t.toString()).append("\n");
        }
        return sb;
    }

    public String buscarPorId(int id) {
        Titular t = titularDAO.buscarPorId(id);
        if (t == null) {
            return "No se encontró el titular con ID: " + id;
        }
        return t.toString();
    }



}

