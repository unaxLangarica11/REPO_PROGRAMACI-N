import javax.swing.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Main {
    public static void main(String[] args) {

        try {
            // Calcular edad
            String fechaNacimientoString = JOptionPane.showInputDialog("Teclea tu fecha de nacimiento (dd/mm/yyyy)");
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoString, formato);

            int años = Period.between(fechaNacimiento, LocalDate.now()).getYears();

            //int resultado = años / 0;
            System.out.println("Edad: " + años);
        }
        catch(DateTimeParseException e)
        {
            JOptionPane.showMessageDialog(null, " La fecha introducida no es correcta");
        }
        /*catch(ArithmeticException e)
        {
            JOptionPane.showMessageDialog(null, "No se puede dividir entre cero");
        }*/
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getClass() + " " + e.getMessage());
        }
        finally {

        }

    }
}