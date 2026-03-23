import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {


    static String descripcionTarea;
    static int codigoTarea;
    static double tiempoTarea;

    static String fecha;
    static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static LocalDate fechaTarea;


    static String confirmacion;



    public static void main(String[] args) {
        ;
    }

    public static void mostrarMenu(){

        String menu = JOptionPane.showInputDialog("Escoja una opcion:" +
                "a) Guardar los datos de una tarea que estamos planificando (descripcion de la tarea, c ´ odigo de la tarea, los minutos necesarios ´\n" +
                "para su desempeno y la fecha en la que se va a realizar)" +
                "b) Mostrar la descripcion de la tarea que m ´ as minutos necesita" +
                "c) Mostrar la descripcion de la tarea que hay que realizar en primer ´\n" +
                "lugar."+
                "d) Mostrar todas las tareas guardadas."+
                "e) Salir");

        switch (menu) {
            case "a": recogerDatos();

        }

    }

    public static void recogerDatos(){

        recogerDescripcion();
        recogerCodigo();
        recogerTiempo();
        recogerFecha();

    }


    public static void recogerDescripcion(){
        descripcionTarea = JOptionPane.showInputDialog("Ingrese la descripcion de la tarea: ");
    }

    public static void recogerCodigo(){
        codigoTarea= Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo de la tarea: "));
    }

    public static void recogerTiempo(){
        tiempoTarea= Double.parseDouble(JOptionPane.showInputDialog("Ingrese el tiempo de la tarea: "));
    }

    public static void recogerFecha(){
        fecha = JOptionPane.showInputDialog("Ingrese la fecha de la tarea: ");
        fechaTarea = LocalDate.parse(fecha,formato);
    }

    public static void obtenerTareaMasLarga(){

        do {
            recogerDatos();
            String confirmacion = JOptionPane.showInputDialog("QUIERE SEGUIR? SI o NO:");

        } while (confirmacion != null && confirmacion.equalsIgnoreCase("SI"));
    }
}
