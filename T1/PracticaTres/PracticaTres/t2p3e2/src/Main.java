import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    private static LocalDate fechaUno, fechaDos;
    private static Scanner sc;

    public static void main(String[] args) {

        /*
        Programa que reciba dos fechas en formato YYYY-MM-DD e indique cual de las dos fechas es anterior,
         o si son iguales. ´
        */
        sc = new Scanner(System.in);
        fechaUno = solicitarFecha();
        fechaDos = solicitarFecha();
        sc.close();
        comparar();
    }
    public static LocalDate solicitarFecha(){
        System.out.println("Teclea una fecha en formato YYYY-MM-DD");
        String fecha = sc.nextLine();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(fecha,formato);
    }

    public static void comparar()
    {
        if (fechaUno.isEqual(fechaDos))
            System.out.println("Las dos fechas son iguales");
        else
            if (fechaUno.isBefore(fechaDos))
                System.out.println("La primera fecha es anterior");
            else
                System.out.println("La segunda fecha es anterior");
    }
}