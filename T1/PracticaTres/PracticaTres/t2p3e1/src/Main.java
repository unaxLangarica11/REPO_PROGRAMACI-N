import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {

        // Fecha actual en diferentes formatos.

        LocalDate fechaActual = LocalDate.now();
        System.out.println("Fecha actual: " + fechaActual);

        mostrar(fechaActual, "yyyy-MM-dd");
        mostrar(fechaActual, "dd/MM/yyyy");
        mostrar(fechaActual, "MMM dd, yyyy");

        mostrarString(fechaActual.toString(), "yyyy-MM-dd");

        // Más información sobre formatos: https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html

    }

    public static void mostrar(LocalDate fechaActual, String formato)
    {
        // Al objeto LocalDate se le aplica un formato.
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(formato);
        System.out.println("Formato (" + formato + "): " + fechaActual.format(dtf));
    }

    public static void mostrarString(String fechaActual, String formato)
    {
        // Un String se parsea
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(formato);
        System.out.println("Formato (" + formato + "): " + LocalDate.parse(fechaActual,dtf));
    }
}