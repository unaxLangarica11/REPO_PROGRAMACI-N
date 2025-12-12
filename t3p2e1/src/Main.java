import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {


    static ArrayList<Integer> lista1 = new ArrayList<>();

    static String menu;

    static int numMax;
    static int numMin;
    static int numBuscado;

    static int sumaTotal;


    public static void main(String[] args) {

        añadirNumero();

        do {
            mostrarMenu();
        }while (!menu.equalsIgnoreCase("j"));



    }


    public static void añadirNumero() {


        String continuar = "si";


        do {


            int numero = Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero para añadirlo al array: "));
            lista1.add(numero);
            continuar = JOptionPane.showInputDialog("Desea introducir otro numero? (teclee SI ");


        } while (continuar.equalsIgnoreCase("SI"));

    }


    public static void mostrarMenu() {

        String menu = JOptionPane.showInputDialog("Escoja una opción: " +
                "a) Visualizar el valor maximo y el m ´ ´ınimo.\n" +
                "b) Solicitar un numero y buscarlo. Muestra un mensaje indicando ´\n" +
                "si lo has encontrado o no.\n" +
                "c) Solicitar un numero, buscarlo y borrarlo. Sino se encuentra mues- ´\n" +
                "tra un mensaje de error.\n" +
                "d) Convertir el arrayList en un array.\n" +
                "e) Si no esta vac´ıo, mostrar el numero de elementos que contiene. ´\n" +
                "f) Insertar un nuevo elemento por el final.\n" +
                "g) Insertar un nuevo elemento en la posicion que te indique el ´\n" +
                "usuario.\n" +
                "h) Borrar un elemento de una posicion concreta. ´\n" +
                "i) Calcular la suma y la media aritmetica de los valores contenidos. ´\n" +
                "j) Finalizar.");


        switch (menu) {
            case "a":
                calcularMaxMin();
                break;
            case "b":
                buscarNum();
                break;
            case "c":
                borrarNumBuscado();
                break;
            case "d":
                convertirEnArray();
                break;
            case "e":
                mostrarNumElementos();
                break;
            case "f":
                insertarElementoFinal();
                break;
            case "g":
                insertarEnPosicion();
                break;
            case "h":
                borrarElemento();
                break;
            case "i":
                calcularSuma();
                calcularMedia();
                break;
            case "j":
                JOptionPane.showMessageDialog(null, "Cerrando el programa.");
                break;
        }

    }

    public static void calcularMaxMin() {

        numMax = Collections.max(lista1);
        numMin = Collections.min(lista1);

        JOptionPane.showMessageDialog(null, "El numero maximo es :" + numMax +
                "\nEl numero minimo es :" + numMin
        );

    }

    public static void buscarNum() {

        numBuscado = Integer.parseInt(JOptionPane.showInputDialog("Introduzca un numero para buscarlo en el array: "));

        if (lista1.contains(numBuscado)) {
            JOptionPane.showMessageDialog(null, "SE HA ENCONTRADO SU NUMERO EN EL ARRAY");
        } else {
            JOptionPane.showMessageDialog(null, "NO SE ENCUENTRA EL NUMERO INTRODUCIDO");
        }

    }

    public static void borrarNumBuscado() {

        numBuscado = Integer.parseInt(JOptionPane.showInputDialog("Introduzca un numero para buscarlo en el array: "));

        if (lista1.contains(numBuscado)) {
            JOptionPane.showMessageDialog(null, "SE HA ENCONTRADO SU NUMERO EN EL ARRAY, ELIMINANDO...");
            lista1.remove(numBuscado);

        } else {
            JOptionPane.showMessageDialog(null, "ERROR. NO SE ENCUENTRA EL NUMERO INTRODUCIDO");

        }


    }

    public static void convertirEnArray(){


        JOptionPane.showMessageDialog(null,"CONVIRTIENDO EL ARRAYLIST EN ARRAY...");
        int[] array = new int[lista1.size()];

    }

    public static void mostrarNumElementos() {

        if (!lista1.isEmpty()) {

            JOptionPane.showMessageDialog(null, "Este arraylist contiene : " + lista1.size()+ " elementos.");

        }

    }

    public static void insertarElementoFinal() {

        lista1.add(Integer.parseInt(JOptionPane.showInputDialog("INTRODUCE EL NUMERO QUE QUIERES AÑADIR AL FINAL DEL ARRAY: ")));

    }

    public static void insertarEnPosicion() {


        int indice = Integer.parseInt(JOptionPane.showInputDialog("ESCOJA LA POSICION/INDICE DONDE AÑADIR EL NÚMERO: "));
        lista1.add(indice, Integer.parseInt(JOptionPane.showInputDialog("INTRODUCE EL NUMERO QUE VAYAS A AÑADIR EN LA POSICION " + indice)));

        JOptionPane.showMessageDialog(null, "NUMERO INTRODUCIDO CORRECTAMENTE EN LA POSICION");
    }


    public static void borrarElemento() {

        int indice = Integer.parseInt(JOptionPane.showInputDialog("ESCOJA LA POSICION/INDICE DONDE AÑADIR EL NÚMERO: "));
        lista1.remove(indice);

        JOptionPane.showMessageDialog(null, "ELIMINADO EL NUMERO DEL INDICE " + indice);


    }

    public static void calcularSuma() {

        sumaTotal = 0;

        for (int numero: lista1) {

            sumaTotal += numero;

        }

        JOptionPane.showMessageDialog(null, "La suma de todos los elementos del arraylist es: " + sumaTotal);

    }

    public static void calcularMedia() {

        double media = sumaTotal/lista1.size();

    }


}