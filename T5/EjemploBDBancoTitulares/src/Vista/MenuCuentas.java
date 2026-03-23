package Vista;

import Controladores.BancoController;
import Modelo.CuentaCorriente;
import Utilidades.EntradaDatos;

import javax.swing.*;
import java.util.Scanner;

public class MenuCuentas {

    private Scanner sc;

    private BancoController bancoController;

    public MenuCuentas()
    {
        // Objeto Scanner para leer la entrada del usuario
        sc = new Scanner(System.in);
            /*
            Creación del controlador para manejar la lógica de negocio
            relacionada con los titulares.
             */
        bancoController = new BancoController();
    }

    public void mostrarMenu()
    {
        int opcion;
        do
        {
            System.out.println("\n====== MENÚ BANCO (CUENTAS)  ======");
            System.out.println("1. Crear cuenta corriente");
            System.out.println("2. Modificar cuenta corriente");
            System.out.println("3. Borrar cuenta corriente");
            System.out.println("4. Listar cuentas");
            System.out.println("5. Listar cuentas con saldo superior a un valor");
            System.out.println("6. Buscar por número de cuenta");
            System.out.println("0. Salir");
            System.out.println("========================");

            opcion = EntradaDatos.leerEntero(sc, "Elige opción: ");

            switch (opcion) {
                case 1 -> crearCuenta();
                case 2 -> modificarCuenta();
                case 3 -> borrarCuenta();
                case 4 -> listarCuentas();
                case 5 -> listarCuentasPorSaldo();
                case 6 -> buscarPorIban();
                case 0 -> System.out.println("Volviendo al menú principal");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }
   // genera solo la cabecera de los métodos del menú
    private void crearCuenta() {
        System.out.println("\n--- CREAR CUENTA ---");
        try
        {
            // Solicitar el iban y el saldo inicial de la cuenta
            String iban = EntradaDatos.leerTexto(sc, "Introduce IBAN: ", "^ES[0-9]{22}$");
            if (iban != null) {
                // Si es null, ya hemos mostrado un mensaje de error en la función leerTexto, así que no hace falta mostrar otro aquí.
                if (EntradaDatos.validacionCompletaIBAN(iban))
                {
                    double saldo  = EntradaDatos.leerDouble(sc, "Introduce el saldo: ");
                    if (saldo != -1) {
                        // Si es -1, ya hemos mostrado un mensaje de error en la función leerDouble, así que no hace falta mostrar otro aquí.
                         bancoController.crearCuenta(iban, saldo);
                        // Mensaje para que el usuario sepa que se ha creado correctamente
                        JOptionPane.showMessageDialog(null,"Cuenta creada correctamente.");
                    }
                }
            }
        }
        catch (Exception e)
        {
            // Mensaje para el usuario para que sepa que ha habido un error al crear la cuenta
            JOptionPane.showMessageDialog(null,"Problemas creando la cuenta");
        }
    }



    private void modificarCuenta() {
        // Solicitar el id o el número de cuenta para modificar el saldo.
            System.out.println("\n--- MODIFICAR CUENTA ---");
                try
                {
                    String iban = EntradaDatos.leerTexto(sc, "Introduce el IBAN de la cuenta a modificar: ", "^ES[0-9]{22}$");
                    if (iban != null) {
                        if (EntradaDatos.validacionCompletaIBAN(iban))
                        {
                            CuentaCorriente cuenta = bancoController.buscarCuentaPorIban(iban);
                            if (cuenta == null) {
                                // Mensaje para el usuario para que sepa que no se ha encontrado la cuenta
                                JOptionPane.showMessageDialog(null,"No se ha encontrado ninguna cuenta con ese IBAN.");
                            }
                            else {
                                double nuevoSaldo = EntradaDatos.leerDouble(sc, "Introduce el nuevo saldo: ");
                                if (nuevoSaldo != -1) {
                                    // Si es -1, ya hemos mostrado un mensaje de error en la función leerDouble, así que no hace falta mostrar otro aquí.
                                    bancoController.modificarCuenta(cuenta, nuevoSaldo);
                                    // Mensaje para que el usuario sepa que se ha modificado correctamente
                                    JOptionPane.showMessageDialog(null, "Cuenta modificada correctamente.");
                                }
                            }
                        }
                    }
                }
                catch (Exception e)
                {
                    // Mensaje para el usuario para que sepa que ha habido un error al modificar la cuenta
                    JOptionPane.showMessageDialog(null,"Problemas modificando la cuenta");
                }


    }

    private void borrarCuenta() {
        // Por id o por número de cuenta. Se puede hacer de las dos formas.
        System.out.println("\n--- BORRAR CUENTA ---");
        try {
            String iban = EntradaDatos.leerTexto(sc, "Introduce el IBAN de la cuenta a borrar: ", "^ES[0-9]{22}$");
            if (iban != null) {
                if (EntradaDatos.validacionCompletaIBAN(iban)) {
                    int n = bancoController.eliminarCuenta(iban);
                    if (n == 1) {
                        JOptionPane.showMessageDialog(null, "Cuenta borrada correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se ha encontrado ninguna cuenta con ese IBAN.");
                    }
                }
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas borrando la cuenta");
        }
    }

    private void listarCuentas() {
        // Mostrar los datos de todas las cuentas
        String datos = bancoController.listarCuentas();
        JOptionPane.showMessageDialog(null, datos);
    }

    private void listarCuentasPorSaldo() {
        // Solicitar un valor y mostrar las cuentas con saldo superior a ese valor
        System.out.println("\n--- LISTAR CUENTAS POR SALDO ---");
        try {
            double saldo = EntradaDatos.leerDouble(sc, "Introduce el saldo mínimo: ");
            if (saldo != -1) {
                String datos = bancoController.listarCuentasPorSaldo(saldo);
                JOptionPane.showMessageDialog(null, datos);
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas listando las cuentas por saldo");
        }
    }

    private void buscarPorIban() {
        // Mostrar los datos de la cuenta que tenga el número de cuenta introducido por el usuario
        System.out.println("\n--- BUSCAR CUENTA POR IBAN ---");
        try {
            String iban = EntradaDatos.leerTexto(sc, "Introduce el IBAN de la cuenta a buscar: ", "^ES[0-9]{22}$");
            if (iban != null) {
                if (EntradaDatos.validacionCompletaIBAN(iban)) {
                    CuentaCorriente cuenta = bancoController.buscarCuentaPorIban(iban);
                    if (cuenta == null) {
                        JOptionPane.showMessageDialog(null, "No se ha encontrado ninguna cuenta con ese IBAN.");
                    } else {
                        JOptionPane.showMessageDialog(null, cuenta.toString());
                    }
                }
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas buscando la cuenta por IBAN");
        }
    }

}
