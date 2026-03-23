package Vista;

import Controladores.*;
import Modelo.Titular;
import Utilidades.EntradaDatos;

import java.util.List;
import java.util.Scanner;

public class MenuTitulares
{
        private Scanner sc;

        private TitularController titularController;

        public MenuTitulares()
        {
            // Objeto Scanner para leer la entrada del usuario
            sc = new Scanner(System.in);
            /*
            Creación del controlador para manejar la lógica de negocio
            relacionada con los titulares.
             */
            titularController = new TitularController();
        }

        public void mostrarMenu()
        {
            int opcion;
            do
            {
                System.out.println("\n====== MENÚ BANCO (TITULARES)  ======");
                System.out.println("1. Crear titular");
                System.out.println("2. Modificar titular");
                System.out.println("3. Borrar titular");
                System.out.println("4. Listar titulares");
                System.out.println("5. Listar titulares por nombre");
                System.out.println("6. Buscar por ID");
                System.out.println("7. Buscar por DNI");
                System.out.println("0. Salir");
                System.out.println("========================");

                opcion = EntradaDatos.leerEntero(sc, "Elige opción: ");

                switch (opcion) {
                    case 1 -> crearTitular();
                    //case 2 -> modificarTitular();
                    //case 3 -> borrarTitular();
                    //case 4 -> listarTitulares();
                    //case 5 -> listarPorNombre();
                    //case 6 -> buscarPorId();
                    //case 7 -> buscarPorDni();
                    case 0 -> System.out.println("Saliendo del programa...");
                    default -> System.out.println("Opción inválida.");
                }
            } while (opcion != 0);
        }

        private void crearTitular()
        {
            System.out.println("\n--- CREAR TITULAR ---");
            try
            {
                // Solicitar el dni y el nombre del titular al usuario
                String dni = EntradaDatos.leerTexto(sc, "Introduce DNI: ", "^[0-9]{8}[A-Za-z]$");
                if (dni != null) {
                    // Si es null, ya hemos mostrado un mensaje de error en la función leerTexto, así que no hace falta mostrar otro aquí.
                    String nombre = EntradaDatos.leerTexto(sc, "Introduce nombre: ", "^[A-Za-z ]+$");
                    if (nombre != null) {
                        // Llamar al controlador para crear el titular
                        titularController.crearTitular(dni, nombre);
                        // Mensaje para que el usuario sepa que se ha creado correctamente
                        System.out.println("Titular creado correctamente.");
                    }
                }
            }
            catch (Exception e)
            {
                // Mensaje para el usuario para que sepa que ha habido un error al crear el titular
                System.out.println("Problemas creando el titular");
            }

        }


    }

