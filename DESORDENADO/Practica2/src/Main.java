import javax.swing.*;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        /*EJERCICIO 1
        public static int contarVocales (String cadena){

            String cadena = JOptionPane.showInputDialog("Introduzca su frase")
            int num_vocales = 0;
            for (int i = 0; i < cadena.length(); i++) {
                if (cadena.charAt(i) == 'A' || cadena.charAt(i) == 'E' || cadena.charAt(i) == 'I' || cadena.charAt(i) == 'O' || cadena.charAt(i) == 'U') {

                    num_vocales++;
                }


            }
            return num_vocales;


        }
    }

        String cadena = JOptionPane.showInputDialog("Introduce tu frase").toUpperCase(Locale.ROOT);
        int num_vocales = contarVocales(cadena);

        JOptionPane.showMessageDialog(null, "El numero de vocales de la frase es: " + num_vocales);

         */

        /*EJERCICIO 2
        String invertido = "";
        String texto = JOptionPane.showInputDialog("Digite un texto: ");


        for (int i = texto.length() - 1; i >= 0; i--) {
            invertido += texto.charAt(i);
        }

        JOptionPane.showMessageDialog(null, "Invertido: " + invertido);


         */

        /*EJERCICIO 3
        String text = JOptionPane.showInputDialog("Ingrese un texto ");
        String texto2 = JOptionPane.showInputDialog("Ingrese una letra ");

        char letra = texto2.charAt(0);

        int contador = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == letra) {
                contador++;
            }
        }

        JOptionPane.showMessageDialog((null,"La letra " + letra + " se repite " + contador " veces");

         */

        int nombre = Integer.parseInt(JOptionPane.showInputDialog("Teclea el nombre del alumno"));
        int nota = Integer.parseInt(JOptionPane.showInputDialog("Teclea la nota del alumno"));

        StringBuilder texto = new StringBuilder("El alumno  llamado ha sacado un ");

        texto.insert(11, nombre);
        texto.insert(32, nota);

        System.out.println(texto);

    }


}