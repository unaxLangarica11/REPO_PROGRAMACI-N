import java.util.Scanner;

public class Main {

    /**
     * Dada una cadena de caracteres mostrar por pantalla la cantidad de vocales que tiene.
     * Ejemplo:
     * Entrada: Hola tu
     * Salida: La cantidad de vocales es 3
     */
    private static StringBuilder cadena;

    public static void main(String[] args)
    {
        // Entrada y validación
        boolean correcta;
        do
        {
            solicitarCadena();
            correcta = validarCadena();
        }
        while(!correcta); // Mientras no sea correcta.

        // Proceso
        int numero = contarVocales();
        // Salida
        //System.out.println(" La cadena tiene " + numero + " vocales");
        System.out.printf(" La cadena tiene %s vocales", numero);
    }

    public static void solicitarCadena()
    {
        // Entrada y validación de una cadena de carácteres.
        cadena = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        System.out.println("Teclea una cadena de caracteres");
        cadena.append(sc.nextLine());
        //sc.nextLine();
    }

    public static int contarVocales()
    {
        // Cuenta las vocales que hay en una cadena de caracteres.
        int contador = 0;
        // Repetitiva para ir recorriendo la cadena
        for(int x = 0; x < cadena.length(); x++)
        {
            // charAt(x) == caracter de la posición x
            switch (cadena.charAt(x))
            {
                case 'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U' -> contador = contador + 1;
            }
            //cadena = cadena.toLowerCase();
            //if (cadena.charAt(x) == 'a' || cadena.charAt(x) == 'e' || cadena.charAt(x) == 'i' || cadena.charAt(x) == 'o' || cadena.charAt(x) == 'u')

        }
        return contador;
    }

    public static boolean validarCadena()
    {
        // Está vacía cadena.length() == 0
        return !cadena.isEmpty();
    }

}
