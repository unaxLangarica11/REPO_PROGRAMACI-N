package Controller;

import DAO.PasajeroDAO;
import DAO.VueloDAO;
import Modelo.Pasajero;
import Modelo.Vuelo;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class PasajeroController {

    private PasajeroDAO pasajeroDAO;

    public PasajeroController() { pasajeroDAO = new PasajeroDAO();}

    public void crearPasajero() {
        Pasajero pasajero = new Pasajero();
        PasajeroDAO.insertarPasajero(pasajero);
    }

    public void borrarPasajero() throws SQLException {
        String dni = JOptionPane.showInputDialog("Ingrese el DNI que quiere eliminar");
        if(!dni.isEmpty()) {
            PasajeroDAO.eliminarPasajero(dni);
            JOptionPane.showMessageDialog(null, "Pasajero eliminado");
        } else{
            JOptionPane.showMessageDialog(null, "Pasajero no encontrado");
        }
    }

    public void modificarPasajero(Pasajero pasajero) throws SQLException {
        PasajeroDAO.updatePasajero(pasajero);

    }


    public Pasajero obtenerPasajeroDni(String dni) throws Exception {
        dni = JOptionPane.showInputDialog("Ingrese el DNI del pasajero del que quiere obtener los datos");
        return pasajeroDAO.selectPasajerosPorDni(dni);
    }

    public Vuelo obtenerVueloPorPasajero(String dni) throws Exception{
        dni = JOptionPane.showInputDialog("Indique el DNI del pasajero del cual desea saber el vuelo");
        return pasajeroDAO.selectVueloPasajero(dni);
    }


    public ArrayList<Pasajero> obtenerPasajerosDelVuelo(int codVuelo) throws Exception{

        codVuelo = Integer.parseInt(JOptionPane.showInputDialog("Indique el codigo del vuelo del cual desea recibir la lista de pasajeros"));
        return pasajeroDAO.selectListarPasajerosPorVuelo(codVuelo);
    }




}
