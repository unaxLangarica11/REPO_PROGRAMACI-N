import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    static String descripcion;
    static int numUnidades;
    static LocalDate caducidad;
    static String nombre;
    static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
 static int mayorUnidades = -1;

 static String nombreMasUnidades;
 static String nombreCaducidad;

    static String nombreLargo = "";
    static LocalDate caducidadPrimera = LocalDate.of(9999,12,31);


    public static void main(String[] args) {



        for (int i = 0; i < 10; i++)
        {

            solicitarDescripcion();
            solicitarFechaCaducidad();
            solicitarNumUnidades();

            if (nombre.length() > nombreLargo.length()){
                nombreLargo = nombre;
            }

             if (caducidad.isAfter(caducidadPrimera)){
                 caducidadPrimera = caducidad;
                 nombreCaducidad = nombre;
             }

             if (numUnidades > mayorUnidades ) {
                 mayorUnidades = numUnidades;
                 nombreMasUnidades = nombre;
             }


        }

        JOptionPane.showMessageDialog(null, "PRODUCTOS:" +
                "NOMBRE MAS LARGO: " + nombreLargo + " CADUCA ANTES: " + caducidadPrimera + " MAS UNIDADES: " +numUnidades);
        ;
    }

    public static void solicitarDescripcion(){

        descripcion = JOptionPane.showInputDialog("Introduzca la descricion del producto");

    }

    public static void solicitarNumUnidades (){

        numUnidades = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la descricion del producto"));

    }

    public static void solicitarFechaCaducidad (){

        caducidad = LocalDate.parse(JOptionPane.showInputDialog("Introduzca la fecha de caducidad del producto"),formato);

    }

    public static void solicitarNombre (){

        nombre = JOptionPane.showInputDialog("Introduzca el nombre del producto");

    }


}