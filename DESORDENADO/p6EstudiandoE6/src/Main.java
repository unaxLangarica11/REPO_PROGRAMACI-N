import javax.swing.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static String menu;

    ////

    static String codigo;
    static String descripcion;
    static int minutos;
    static String fechaInput;
    static LocalDate fecha;
    static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    ////

    static int minutosMax;
    static String descMinutosMax;
    static LocalDate fechaAntigua = LocalDate.now();
    static String descAntigua;

    ////
    static StringBuilder todasTareas = new StringBuilder();


    public static void main(String[] args) {


    mostrarMenu();

    }


public static void mostrarMenu() {

    do {

        try {
            menu = JOptionPane.showInputDialog("Escoja una de las siguientes opciones: \n " +
                    "a) Guardar los datos de una tarea que estamos planificando (descripcion de la tarea, c ´ odigo de la tarea, los minutos necesarios ´\n" +
                    "para su desempeno y la fecha en la que se va a realizar). ˜\n" +
                    "b) Mostrar la descripcion de la tarea que mas minutos necesita. ´\n" +
                    "c) Mostrar la descripcion de la tarea que hay que realizar en primer ´\n" +
                    "lugar.\n" +
                    "d) Mostrar todas las tareas guardadas.\n" +
                    "e) Salir\n");


            switch (menu) {
                case "a":
                    pedirDatos();
                    break;
                case "b":
                    calcularMinutosMax();
                    break;
                case "c":
                    calcularFechaAntigua();
                    break;
                case "d":
                    mostrarTodasLasTareas();
                    break;
                case "e":
                    JOptionPane.showMessageDialog(null,"Saliendo del programa");

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }while (!menu.equals("e"));
}

public static void pedirDatos() throws Exception {

    pedirCodigo();
    pedirDescripcion();
    pedirMinutos();
    pedirFecha();

    todasTareas.append(codigo + " ");
    todasTareas.append(descripcion + " ");
    todasTareas.append(minutos + " ");
    todasTareas.append(fecha.toString() + "  \n");

}

//////PIDIENDO DATOS///////

public static void pedirCodigo() throws Exception {

        boolean error = false;

        while (!error) {

            try {

                codigo = JOptionPane.showInputDialog("Introduzca el codigo con el siguiente formato:  tres vocales (la primera en ´\n" +
                        "mayuscula y las otras dos minusculas) y tres numeros (el primero debe ser un 1).");

                if (codigo.isEmpty()) {
                    throw new Exception("DEBES ESCRIBIR EL CODIGO");

                }




                Pattern p = Pattern.compile("^[AEIOU][aeiou]{2}1[0-9]{2}$");

                if (!p.matcher(codigo).matches()) {
                    throw new Exception("EL CODIGO DEBE CUMPLIR EL FORMATO");
                }

                error = true;
            }catch (Exception e) {

                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
}

public static void pedirDescripcion() throws Exception{

        boolean error = false;

            while (error){

            try {
                descripcion = JOptionPane.showInputDialog("Introduzca una descripción");

                if (descripcion.isEmpty()) {
                    throw new Exception("DEBES ESCRIBIR LA DESCRIPCION");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());

                error = true;
            }


        };
}

public static void pedirMinutos() throws Exception{

        boolean error;

        do {
            error = false;
            try {
                minutos = Integer.parseInt(JOptionPane.showInputDialog("Introduzca los minutos que necesita la tarea"));


            } catch (NumberFormatException e) {
                System.out.println("DEBES INTRODUCIR NUMEROS, NO LETRAS");

                error = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }


        }while (error);
    }



public static void pedirFecha() throws Exception{

        boolean error = false;

        do {

            try {
                fechaInput = JOptionPane.showInputDialog("Introduzca una fecha");
                fecha = LocalDate.parse(fechaInput,formato);

            } catch (DateTimeException e) {
                System.out.println(e.getMessage());

                error = true;

            } catch (Exception e) {
                System.out.println(e.getMessage());

                error = true;
            }


        }while (error);
    }


/////////////FUNCIÓN B//////////////////



public static void calcularMinutosMax() throws Exception{

        try{


        if (minutos>minutosMax){
            minutosMax = minutos;
            descMinutosMax = descripcion;
        }

        JOptionPane.showInputDialog("La descripción de la tarea mas larga es: \n" + descMinutosMax + "\n y dura " + minutosMax);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
}

public static void calcularFechaAntigua() throws Exception{

        try{
            if (fecha.isBefore(fechaAntigua)){

                fechaAntigua = fecha;
                descAntigua = descripcion;


            }

            System.out.println("La tarea que hay que realizar antes es" +fechaAntigua);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
}

public static void mostrarTodasLasTareas() throws Exception{

        try{
            JOptionPane.showMessageDialog(null, todasTareas);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


}





