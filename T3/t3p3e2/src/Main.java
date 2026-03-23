import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static Queue<LocalDate> fechasCad = new LinkedList<>();
    public static Queue<String> nombresProd = new LinkedList<>();

    public static void main(String[] args) {
        try {
            conseguirProductos();
            pedirFechaDeHoy();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e);
        }


    }



    public static LocalDate pedirFecha() throws Exception{

        String fecha = JOptionPane.showInputDialog("Indica la fecha de Caducidad");
        return LocalDate.parse(fecha,formato);

    }

    public static String pedirNombre() throws Exception{
        return JOptionPane.showInputDialog("Indica el nombre del producto");
    }

    public static void pedirFechaDeHoy() throws Exception{
        String fecha = JOptionPane.showInputDialog("Indica la fecha de hoy");
        LocalDate hoy = LocalDate.parse(fecha,formato);
        eliminarCaducados(hoy);
    }

    public static void eliminarCaducados(LocalDate hoy) throws Exception{
        for (LocalDate fecha : fechasCad) {
            if(fecha.(hoy)){
                fechasCad.remove(fecha);
            }
        }
    }



}