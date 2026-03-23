import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Fecha y hora actuales en distintas zonas horarias.
        System.out.println("Indica una zona horaria");
        Scanner sc = new Scanner(System.in);
        String zona = sc.nextLine();

        ZonedDateTime fecha;
        switch (zona) {
            case "Madrid":
               fecha = ZonedDateTime.now(ZoneId.of("Europe/Madrid"));
                System.out.println("Fecha y hora en " + zona + " es " + fecha);
               break;
            case "New_York":
                fecha = ZonedDateTime.now(ZoneId.of("America/New_York"));
                System.out.println("Fecha y hora en " + zona + " es " + fecha);
                break;
            default:
                System.out.println("No conozco esa zona");
        }

        // Mostrar zonas horarias disponibles.
        Set<String> zonasHorarias = ZoneId.getAvailableZoneIds();
        zonasHorarias.stream().forEach(System.out::println);
    }
}