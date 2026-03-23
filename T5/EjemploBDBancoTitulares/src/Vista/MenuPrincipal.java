package Vista;

import Controladores.TitularController;
import Utilidades.EntradaDatos;

import java.util.Scanner;

public class MenuPrincipal {
    private Scanner sc;

    public MenuPrincipal()
    {
        // Objeto Scanner para leer la entrada del usuario
        sc = new Scanner(System.in);
    }

    public void mostrarMenu()
    {
        int opcion;
        do
        {
            System.out.println("\n====== MENÚ BANCO (PRINCIPAL)  ======");
            System.out.println("1. Operaciones con titulares");
            System.out.println("2. Operaciones con cuentas corrientes");
            System.out.println("3. Relación entre titulares y cuentas");
            System.out.println("0. Salir");
            System.out.println("========================");

            opcion = EntradaDatos.leerEntero(sc, "Elige opción: ");

            switch (opcion) {
                case 1 -> mostrarMenuTitulares();
                case 2 -> mostrarMenuCuentas();
                case 3 -> mostrarMenuCuentasTitulares();
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    public void mostrarMenuTitulares()
    {
        MenuTitulares menuTitulares = new MenuTitulares();
        menuTitulares.mostrarMenu();
    }
    public void mostrarMenuCuentas()
    {
        MenuCuentas menuCuentas = new MenuCuentas();
        menuCuentas.mostrarMenu();
    }
    public void mostrarMenuCuentasTitulares() {
        MenuCuentasTitulares menuCuentasTitulares = new MenuCuentasTitulares();
        menuCuentasTitulares.mostrarMenu();
    }

}
