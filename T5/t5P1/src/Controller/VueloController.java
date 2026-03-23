package Controller;

import Modelo.Vuelo;
import DAO.*;

import javax.swing.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VueloController {

    private VueloDAO vueloDAO;

    public VueloController() { vueloDAO = new VueloDAO(); }


    public void crearVuelo(String codVuelo, LocalDate fechaSalida, String destino, String procedencia){
        Vuelo vuelo = new Vuelo(codVuelo, fechaSalida, destino, procedencia);
        vueloDAO.insertarVuelo(vuelo);
    }


    public void borrarVuelo(int codVuelo) throws SQLException {
        vueloDAO.eliminarVuelo(codVuelo);
    }

    public void modificarVuelo(Vuelo vuelo) throws SQLException {
        vueloDAO.modificarVuelo(vuelo);
    }

    public Vuelo obtenerVueloCodVuelo(int codVuelo) throws SQLException {
        codVuelo = Integer.parseInt(JOptionPane.showInputDialog("Indique el codigo del vuelo del cual desea recibir la informacion"));

        return vueloDAO.selectVueloPorCodigo(codVuelo);
    }

    public Vuelo obtenerVueloDestino(String destino) throws SQLException {
        destino = JOptionPane.showInputDialog("Indique el codigo del vuelo del cual desea recibir la informacion");

        return vueloDAO.selectVueloPorDestino(destino);
    }

    public Vuelo obtenerVueloProcedencia(String procedencia) throws SQLException {
        procedencia = JOptionPane.showInputDialog("Indique la procedencia del vuelo del cual desea recibir la informacion");

        return  vueloDAO.selectVueloPorOrigen(procedencia);

    }

    public List<Vuelo> obtenerListaVuelosFechaSalida(LocalDate fechaSalida) throws SQLException {
        fechaSalida = LocalDate.parse(JOptionPane.showInputDialog("Introduzca la fecha de salida para obtener la lista de vuelos"));

        return vueloDAO.listarVuelosPorFecha(fechaSalida);
    }







}
