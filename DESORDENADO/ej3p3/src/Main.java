import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        obtenerHora();
    }

    public static void obtenerHora(){

        String zonaHoraria = JOptionPane.showInputDialog("Introduce la zona horaria (Continente/Ciudad)");

        try{
            //Esta es la linea que puede lanzar la excepcion pero las otras es conveniente meterlas//
            ZonedDateTime hora = ZonedDateTime.now(ZoneId.of(zonaHoraria));


            DateTimeFormatter formato = DateTimeFormatter.ofPattern("hh:mm");

            System.out.println("La hora actual en " + zonaHoraria + " es " + hora.format(formato));

        } catch (Exception a) {
            System.out.println("La zona horaria no es correcta");
        }


    }

}

