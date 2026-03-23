import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static List<Coche> coches = new ArrayList();
    public static List<Propietario> propietarios = new ArrayList();


    public static void main(String[] args) {




        // COCHES
        Coche c1 = new Coche("1234 ABC", "Toyota", 2018, 18000);
        Coche c2 = new Coche("5678 DEF", "BMW", 2015, 25000);
        Coche c3 = new Coche("9012 GHI", "Seat", 2012, 12000);

        Coche c4 = new Coche("3456 JKL", "Toyota", 2020, 22000);
        Coche c5 = new Coche("7890 MNO", "Audi", 2017, 30000);
        Coche c6 = new Coche("1122 PQR", "BMW", 2010, 15000);

        Coche c7 = new Coche("3344 STU", "Seat", 2019, 16000);
        Coche c8 = new Coche("5566 VWX", "Audi", 2014, 20000);
        Coche c9 = new Coche("7788 YZA", "Toyota", 2021, 24000);

        coches.add(c1);
        coches.add(c2);
        coches.add(c3);
        coches.add(c4);
        coches.add(c5);
        coches.add(c6);
        coches.add(c7);
        coches.add(c8);
        coches.add(c9);



        // PROPIETARIOS
        Propietario p1 = new Propietario(
                "Carlos",
                List.of(c1, c2, c3)
        );

        Propietario p2 = new Propietario(
                "Ana",
                List.of(c4, c5, c6)
        );

        Propietario p3 = new Propietario(
                "Luis",
                List.of(c7, c8, c9)
        );



        //1
        List<String> matriculas = new ArrayList<>();

        //forma normal
        for (Coche c : coches) {
            matriculas.add(c.getMatricula());
        }

        //stream
        matriculas = coches.stream().map(Coche::getMatricula).toList();

        //2

        long contadorCoches = p1.getCoches().stream().count();
        JOptionPane.showInputDialog(null, "Numero de coches: " + contadorCoches);

        //3

        coches.stream().filter((Coche c)-> c.getAño() > 2015).toList();






    }

    //4

    //forma 1


    double mediaPrecio = coches.stream().mapToDouble(Coche::getPrecio).average().orElse(0.0);






    //5


    Coche cocheMasCaro = coches.stream().max(Comparator.comparing(Coche::getPrecio)).orElse(null);


    //6

    Coche cocheBMW = coches.stream().filter(c -> c.getMarca().equalsIgnoreCase("BMW"))
            .findFirst().orElse(null);


    //7

    List<Coche> ordenados = coches.stream()
            .sorted(Comparator.comparingDouble(Coche::getPrecio).reversed())

}