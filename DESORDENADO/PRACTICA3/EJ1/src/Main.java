import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Main {
            public static void main(String[] args) {




                LocalDate fechaActual = LocalDate.now();

                DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                DateTimeFormatter formato3 = DateTimeFormatter.ofPattern("MMM dd, yyyy", Locale.ENGLISH);


                System.out.println("Formato 1 (YYYY-MM-DD): " + fechaActual.format(formato1));
                System.out.println("Formato 2 (DD/MM/YYYY): " + fechaActual.format(formato2));
                System.out.println("Formato 3 (MMM dd, yyyy): " + fechaActual.format(formato3));
            }
        }



    }
}