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


            ZonedDateTime hora = ZonedDateTime.now(ZoneId.of(zonaHoraria));
            System.out.println("La hora actual en " + zonaHoraria + "es" + hora);}

        }




