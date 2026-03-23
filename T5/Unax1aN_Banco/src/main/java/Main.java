//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import Utilidades.DBConnection;
import Vista.MenuTitulares;

public class Main {
    public static void main(String[] args) {

        // Crear la fábrica de EntityManager al inicio del programa para que esté disponible durante toda la ejecución
        DBConnection.crearEMF();

        /*
        Main crea el primer elemento de la vista y a partir de ahí,
        el controlador se encarga de gestionar la lógica y la interacción
        con el modelo.
         */

        MenuTitulares menu = new MenuTitulares();
        menu.mostrarMenu();
    }
}
