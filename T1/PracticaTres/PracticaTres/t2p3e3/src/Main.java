import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        /*
        Crear un programa que recoja una fecha introducida por el usuario
        como 3 campos numericos (día, mes, año) y le sume 10 días, reste dos
        meses y, por ultimo, le sume 3 a años. ˜
        El resultado de las distintas operaciones hay que mostrarlo como Dia
        de la semana, día del mes, mes y ano (Viernes, 11 de octubre del 2024)
         */

        // Datos de entrada
        int año,mes,dia;
        Scanner sc = new Scanner(System.in);
        System.out.println("Teclea el dia");
        dia = sc.nextInt();
        System.out.println("Teclea el mes");
        mes = sc.nextInt();
        System.out.println("Teclea el año");
        año = sc.nextInt();

        // Generar la fecha
        LocalDate fecha = LocalDate.of(año,mes,dia);
        sumarDias(fecha,10);
        restarMeses(fecha,2);
        sumarAños(fecha,3);
    }

    public static void sumarDias(LocalDate fecha,int dias)
    {
        LocalDate nuevaFecha = fecha.plusDays(dias);
        mostrar(nuevaFecha);
    }

    public static void restarMeses(LocalDate fecha,int meses)
    {
        LocalDate nuevaFecha = fecha.minusMonths(meses);
        mostrar(nuevaFecha);
    }
    public static void sumarAños(LocalDate fecha,int años)
    {
        LocalDate nuevaFecha = fecha.plus(años, ChronoUnit.YEARS); // plusYears
        mostrar(nuevaFecha);
    }

    public static void mostrar(LocalDate fecha)
    {
        // Obtener el nombre del día en español con mayúscula inicial
        DayOfWeek diaSemana = fecha.getDayOfWeek();
        String diaEnEspanol = diaSemana.getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
        // Obtener el nombre del mes.
        Month mes = fecha.getMonth();
        String mesEnEspanol = mes.getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
        System.out.println(diaEnEspanol+ ", " + fecha.getDayOfMonth() +
                " de " + mesEnEspanol+ " del " + fecha.getYear());


        DateTimeFormatter formatoLargoCastellano =
                DateTimeFormatter
                        .ofPattern("EEEE, dd 'de' MMMM 'de' yyyy")
                        .withLocale(new Locale("es", "ES"));

        System.out.println(fecha.format(formatoLargoCastellano));
    }
}