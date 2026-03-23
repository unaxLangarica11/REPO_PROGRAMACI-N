import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

    static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static LocalDate fechaNacimiento;
    static LocalDate fechaActual = LocalDate.now();

    public static void main(String[] args) {
        mostrarMenu();
    }

    public static void mostrarMenu() {

        String menu = JOptionPane.showInputDialog(
                "Elija una de las siguientes opciones:\n" +
                        "A) Calcular edad.\n" +
                        "B) Números pares y primos.\n" +
                        "C) Verificar palíndromo.\n" +
                        "D) Salir."
        ).toUpperCase();

        switch (menu) {
            case "A":
                calcularEdad();
                break;

            case "B":
                numerosParesYPrimos();
                break;

            case "C":
                verificarPalindromo();
                break;

            case "D":
                JOptionPane.showMessageDialog(null, "TERMINADO");
                break;

        }
    }

    public static void calcularEdad() {
        try {
            String fechaTexto = JOptionPane.showInputDialog("Introduzca su fecha de nacimiento (dd/MM/yyyy):");
            fechaNacimiento = LocalDate.parse(fechaTexto, formato);

            int edad = fechaActual.getYear() - fechaNacimiento.getYear();

            if (fechaActual.getMonthValue() < fechaNacimiento.getMonthValue() ||
                    (fechaActual.getMonthValue() == fechaNacimiento.getMonthValue() &&
                            fechaActual.getDayOfMonth() < fechaNacimiento.getDayOfMonth())) {
                edad--;
            }

            LocalDate proximoCumple = fechaNacimiento.withYear(fechaActual.getYear());
            if (!proximoCumple.isAfter(fechaActual)) {
                proximoCumple = proximoCumple.plusYears(1);
            }

            int diasRestantes = proximoCumple.getDayOfYear() - fechaActual.getDayOfYear();
            if (diasRestantes < 0) diasRestantes += fechaActual.lengthOfYear();

            JOptionPane.showMessageDialog(null,
                    "Tienes " + edad + " años.\n" +
                            "Faltan " + diasRestantes + " días para tu cumple");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "FORMATO INCORRECTO (dd/MM/yyyy).");
        }

        mostrarMenu();
    }

    public static void numerosParesYPrimos() {
        try {
            int num1 = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el primer número:"));
            int num2 = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el segundo número:"));

            int inicio = Math.min(num1, num2);
            int fin = Math.max(num1, num2);

            StringBuilder resultado = new StringBuilder("Números entre " + inicio + "y" + fin + ":\n");

            for (int i = inicio; i <= fin; i++) {
                if (i % 2 == 0) {
                    resultado.append(i).append(" es par.\n");
                } else if (esPrimo(i)) {
                    resultado.append(i).append(" es primo.\n");
                } else {
                    resultado.append(i).append(" no es par ni primo.\n");
                }
            }

            JOptionPane.showMessageDialog(null, resultado.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "INTRRDUZCA NÚMEROS VALIDOS.");
        }

        mostrarMenu();
    }

    public static boolean esPrimo(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void verificarPalindromo() {
    }
