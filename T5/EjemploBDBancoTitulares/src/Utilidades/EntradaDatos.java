package Utilidades;

import java.util.Scanner;

public class EntradaDatos {

    // Forma parte de la vista, pero es tan común que la pongo aquí para no repetir código.
    public static int leerEntero(Scanner sc, String mensaje) {
        int num = 0;
        boolean error = true;
        try {
            num = 0;
            do
            {
                System.out.print(mensaje);
                try {
                    num = Integer.parseInt(sc.nextLine());
                    // También se puede con nextInt pero así me ahorro el limpiar el buffer después.
                    error = false;
                } catch (NumberFormatException e) {
                    System.out.println("Error: introduce un número entero válido.");
                }
            }
            while (error);
            return num;
        }
        catch (Exception e) {
            System.out.println("Error leyendo el número: " + e.getMessage());
            return -1;
        }
    }

    public static double leerDouble(Scanner sc, String mensaje) {
        double num = 0;
        boolean error = true;
        try {
            num = 0;
            do
            {
                System.out.print(mensaje);
                try {
                    num = Double.parseDouble(sc.nextLine());
                    // También se puede con nextInt pero así me ahorro el limpiar el buffer después.
                    error = false;
                } catch (NumberFormatException e) {
                    System.out.println("Error: introduce un número real válido.");
                }
            }
            while (error);
            return num;
        }
        catch (Exception e) {
            System.out.println("Error leyendo el número: " + e.getMessage());
            return -1;
        }
    }

    public static String leerTexto(Scanner sc, String mensaje,String expresionRegular) {
        try
        {
            String texto;
            do
            {
                System.out.print(mensaje);
                texto = sc.nextLine();
                if (!texto.matches(expresionRegular))
                {
                    System.out.println("Error: formato no válido. Inténtalo de nuevo.");
                }
            } while (!texto.matches(expresionRegular));
            return texto;
        }
        catch (Exception e)
        {
            System.out.println("Error leyendo el texto: " + e.getMessage());
            return "";
        }
    }

    public static boolean validacionCompletaIBAN(String iban)
    {
        // Aquí iría la lógica de validación completa del IBAN (dígitos de control, etc.)
        return true;
    }

    public static boolean validacionCompletaDNI(String dni)
    {
        // Aquí iría la lógica de validación completa del dni (la letra adecuada)
        return true;
    }
}

