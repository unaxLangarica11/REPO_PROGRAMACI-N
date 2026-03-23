package Vista;

import Controladores.BancoController;
import Utilidades.EntradaDatos;

import javax.swing.*;
import java.util.Scanner;

public class MenuCuentasTitulares {
    private Scanner sc;

    private BancoController bancoController;

    public MenuCuentasTitulares()
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
            System.out.println("\n====== MENÚ BANCO (CUENTAS Y TITULARES)  ======");
            System.out.println("1. Asignar titulares a cuentas");
            System.out.println("2. Modificar titulares de una cuenta");
            System.out.println("3. Borrar titular de una cuenta");
            System.out.println("4. Listar titulares de una cuenta");
            System.out.println("5. Listar cuentas de un titular");
            System.out.println("0. Salir");
            System.out.println("========================");

            opcion = EntradaDatos.leerEntero(sc, "Elige opción: ");

            switch (opcion) {
                case 1 -> asignarTitulares();
                case 2 -> modificarTitulares();
                case 3 -> borrarTitular();
                case 4 -> listarTitulares();
                case 5 -> listarCuentas();
                case 0 -> System.out.println("Volviendo al menú principal..");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private void asignarTitulares() {
        // Solicitar el número de cuenta y comprobar que existe.
        String iban = EntradaDatos.leerTexto(sc, "Introduce IBAN: ", "^ES[0-9]{22}$");
        if (iban != null) {
            if (EntradaDatos.validacionCompletaIBAN(iban)) {
                // Buscar en base de datos la cuenta con el número de cuenta introducido.
                int idCuenta = bancoController.obtenerIdByIban(iban);
                if (idCuenta != -1) {
                    do {
                        // Solicitar el dni del titular y comprobar que existe.
                        String dni = EntradaDatos.leerTexto(sc, "Introduce DNI: ", "^[0-9]{8}[A-Za-z]$");
                        if (dni != null) {
                            // Buscar en base de datos el titular con el dni introducido.
                            int idTitular = bancoController.obtenerIdByDni(dni);
                            // En vez del id podemos traer el objeto
                            if (idTitular != -1) {
                                // Asignar el titular a la cuenta.
                                if (bancoController.asignarTitularACuenta(idCuenta, idTitular))
                                    JOptionPane.showMessageDialog(null, "Titular asignado correctamente.");
                                else
                                    JOptionPane.showMessageDialog(null, "Error al asignar el titular a la cuenta.");
                            } else
                                JOptionPane.showMessageDialog(null, "No existe ningún titular con el DNI " + dni);
                        }
                    }
                    while(JOptionPane.showConfirmDialog(null, "¿Quieres asignar otro titular a esta cuenta?", "Asignar otro titular", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
                }
                else
                    JOptionPane.showMessageDialog(null, "No existe ninguna cuenta con el IBAN " + iban);

            }
        }
    }


    private void modificarTitulares() {
        // Seleccionar la cuenta
        String iban = EntradaDatos.leerTexto(sc, "Introduce IBAN: ", "^ES[0-9]{22}$");
        if (iban != null) {
            if (EntradaDatos.validacionCompletaIBAN(iban)) {
                // Buscar en base de datos la cuenta con el número de cuenta introducido.
                int idCuenta = bancoController.obtenerIdByIban(iban);
                if (idCuenta != -1) {

                    // Elimino todos los titulares y luego vuelvo a dar de alta.
                    int n = bancoController.eliminarTitulares(idCuenta);
                    if (n > 0)
                        JOptionPane.showMessageDialog(null, "Titulares eliminados, ahora hay que añadir los nuevos.");
                    else
                        JOptionPane.showMessageDialog(null, "No había titulares, añadelos ahora");
                    // Titulares nuevos.
                    do {
                        String dni = EntradaDatos.leerTexto(sc, "Introduce DNI: ", "^[0-9]{8}[A-Za-z]$");
                        if (dni != null) {
                            // Buscar en base de datos el titular con el dni introducido.
                            int idTitular = bancoController.obtenerIdByDni(dni);
                            if (idTitular != -1) {
                                // Modificar el titular de la cuenta.
                                if (bancoController.asignarTitularACuenta(idCuenta, idTitular))
                                    JOptionPane.showMessageDialog(null, "Titular modificado correctamente.");
                                else
                                    JOptionPane.showMessageDialog(null, "Error al modificar el titular de la cuenta.");
                            } else
                                JOptionPane.showMessageDialog(null, "No existe ningún titular con el DNI " + dni);
                        }
                    }
                    while (JOptionPane.showConfirmDialog(null, "¿Quieres asignar otro titular a esta cuenta?", "Asignar otro titular", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
                } else
                    JOptionPane.showMessageDialog(null, "No existe ninguna cuenta con el IBAN " + iban);
            } else
                JOptionPane.showMessageDialog(null, "El IBAN no es válido.");
        }
        else
            JOptionPane.showMessageDialog(null, "El IBAN no es válido.");

    }

    private void borrarTitular() {
        // Eliminar solo un titular de la cuenta, no todos como en modificarTitulares. Para eliminar todos ya tenemos la opción de modificarTitulares.
        String iban = EntradaDatos.leerTexto(sc, "Introduce IBAN: ", "^ES[0-9]{22}$");
        if (iban != null) {
            if (EntradaDatos.validacionCompletaIBAN(iban)) {
                // Buscar en base de datos la cuenta con el número de cuenta introducido.
                int idCuenta = bancoController.obtenerIdByIban(iban);
                if (idCuenta != -1) {
                    String dni = EntradaDatos.leerTexto(sc, "Introduce DNI: ", "^[0-9]{8}[A-Za-z]$");
                    if (dni != null) {
                        // Buscar en base de datos el titular con el dni introducido.
                        int idTitular = bancoController.obtenerIdByDni(dni);
                        if (idTitular != -1) {
                            // Eliminar el titular de la cuenta.
                            if (bancoController.eliminarTitularDeCuenta(idCuenta, idTitular) == 1)
                                JOptionPane.showMessageDialog(null, "Titular eliminado correctamente.");
                            else
                                JOptionPane.showMessageDialog(null, "Error al eliminar el titular de la cuenta.");
                        } else
                            JOptionPane.showMessageDialog(null, "No existe ningún titular con el DNI " + dni);
                    }
                }
            }
        }
    }

    private void listarTitulares() {
        // Lista titulares de una cuenta
        String iban = EntradaDatos.leerTexto(sc, "Introduce IBAN: ", "^ES[0-9]{22}$");
        if (iban != null) {
            if (EntradaDatos.validacionCompletaIBAN(iban)) {
                // Buscar en base de datos la cuenta con el número de cuenta introducido.
                int idCuenta = bancoController.obtenerIdByIban(iban);
                if (idCuenta != -1) {
                    // Listar titulares de la cuenta.
                    String sb = bancoController.listarTitularesDeCuenta(idCuenta);
                    if (!sb.isEmpty())
                        JOptionPane.showMessageDialog(null, "Titulares de la cuenta con IBAN " + iban + ":\n" + sb);
                    else
                        JOptionPane.showMessageDialog(null, "No hay titulares asignados a esta cuenta.");
                }
                else
                    JOptionPane.showMessageDialog(null, "No existe ninguna cuenta con el IBAN " + iban);
            }
            else
                JOptionPane.showMessageDialog(null, "El IBAN no es válido.");
      }
    }


    private void listarCuentas() {
        // Lista cuentas de un titular
        String dni = EntradaDatos.leerTexto(sc, "Introduce DNI: ", "^[0-9]{8}[A-Za-z]$");
        if (dni != null) {
            // Buscar en base de datos el titular con el dni introducido.
            int idTitular = bancoController.obtenerIdByDni(dni);
            if (idTitular != -1) {
                // Listar cuentas del titular.
                String sb = bancoController.listarCuentasDeTitular(idTitular);
                if (!sb.isEmpty())
                    JOptionPane.showMessageDialog(null, "Cuentas del titular con DNI " + dni + ":\n" + sb);
                else
                    JOptionPane.showMessageDialog(null, "No hay cuentas asignadas a este titular.");

            } else
                JOptionPane.showMessageDialog(null, "No existe ningún titular con el DNI " + dni);
        }
    }

}
