package Vista;
import DAO.*;
import Controller.*;

import javax.swing.*;


public class Menu {

    private static VueloController vueloController;
    private static PasajeroController pasajeroController;

    public static void mostrarMenuPrincipal() {

        String menuPrincipal = JOptionPane.showInputDialog("==========SELECCIONE UNA DE LAS OPCIONES DEL MENU===========" +
                "A) ADMINISTRAR VUELOS" +
                "B) ADMINISTRAR PASAJEROS" +
                "C) CONSULTAR INFORMACIÓN"

        );

        switch (menuPrincipal) {
            case "A":
                mostrarMenuVuelos();
            case "B":
                mostrarMenuPasajeros();
            case "C":
                mostrarMenuConsultas();

        }
    }

    public static void mostrarMenuVuelos() {

        String menuVuelos = JOptionPane.showInputDialog("==========SELECCIONE UNA DE LAS OPCIONES DEL MENU===========" +
                "A) AÑADIR VUELO" +
                "B) ELIMINAR VUELO" +
                "C) ACTUALIZAR VUELO"

        );

        switch (menuVuelos) {
            case "A":
                vueloController.crearVuelo();
            case "B":
                vueloController.borrarVuelo();
            case "C":
                vueloController.modificarVuelo();


        }


    }




    public static void mostrarMenuPasajeros() {

        String menuPasajeros = JOptionPane.showInputDialog("==========SELECCIONE UNA DE LAS OPCIONES DEL MENU===========" +
                "A) AÑADIR PASAJERO" +
                "B) ELIMINAR PASAJERO" +
                "C) ACTUALIZAR PASAJERO"

        );

        switch (menuPasajeros) {
            case "A":
                pasajeroController.crearPasajero();
            case "B":
                pasajeroController.borrarPasajero();
            case "C":
                pasajeroController.modificarPasajero();

        }
    }

    public static void mostrarMenuConsultas() {

        String menuConsultas = JOptionPane.showInputDialog("==========SELECCIONE UNA DE LAS OPCIONES DEL MENU===========" +
                "A) BUSCAR PASAJERO POR DNI" +
                "B) BUSCAR VUELO DEL PASAJERO" +
                "C) LISTAR PASAJEROS DEL VUELO" +
                "D) BUSCAR VUELO POR CODIGO DEL VUELO" +
                "E) BUSCAR VUELO POR DESTINO" +
                "F) BUSCAR VUELO POR PROCEDENCIA" +
                "G) LISTAR VUELOS POR FECHA DE SALIR "

        );

        switch (menuConsultas) {
            case "A":
                pasajeroController.obtenerPasajeroDni();
            case "B":
                pasajeroController.obtenerVueloPorPasajero();
            case "C":
                pasajeroController.obtenerPasajerosDelVuelo();
            case "D":
                vueloController.obtenerVueloCodVuelo();
            case "E":
                vueloController.obtenerVueloDestino();
            case "F":
                vueloController.obtenerVueloProcedencia();
            case "G":
                vueloController.obtenerListaVuelosFechaSalida();
        }
    }



}


