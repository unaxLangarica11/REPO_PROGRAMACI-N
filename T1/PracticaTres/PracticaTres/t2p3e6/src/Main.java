import java.time.DateTimeException;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //  Dos horas en formato HH:mm:ss e indicar la duracion en horas, minutos y segundos entre ambas.
        LocalTime hora1 = solicitarHora();
        LocalTime hora2 = solicitarHora();

        Duration duracion = Duration.between(hora1, hora2);
        System.out.println("Duración: " + duracion.toHours() + " horas " + duracion.toMinutesPart() + " minutos " + duracion.toSecondsPart() + " segundos");

    }

    public static LocalTime solicitarHora()
    {
        Scanner sc = new Scanner(System.in);
        boolean error;
        LocalTime time = null;
        do {
            error = false;
            try {
                System.out.println("Teclea la hora");
                int hora = sc.nextInt();

                System.out.println("Teclea los minutos");
                int minutos = sc.nextInt();

                System.out.println("Teclea los segundos");
                int segundos = sc.nextInt();

                time = LocalTime.of(hora, minutos, segundos);
            }
            catch (InputMismatchException e)
            {
                System.out.println("Los datos deben ser numéricos");
                sc.nextLine();
                error = true;
            }
            catch (DateTimeException e)
            {
                System.out.println("Problemas con la hora, vuelve a teclearla");
                error = true;
            }
            catch (Exception e) {
                System.out.println("Problemas " + e.getClass());
                error = true;
            }
        }
        while(error);
        return time;
    }
}