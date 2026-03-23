import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        try {

            mostrarMenu();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }

    public static void mostrarMenu(){

        String menu = JOptionPane.showInputDialog("Escoja una de las siguientes opciones" +
                "a) Anadir un libro a la pila: Solicitar al usuario el t ˜ ´ıtulo del libro y\n" +
                "colocarlo en la parte superior de la pila.\n" +
                "b) Consultar el libro en la parte superior: Mostrar el t´ıtulo del libro\n" +
                "que esta en la parte superior sin eliminarlo. ´\n" +
                "c) Retirar el libro en la parte superior: Eliminar el libro de la parte\n" +
                "superior de la pila y mostrar su t´ıtulo.\n" +
                "d) Mostrar todos los libros en la pila: Listar todos los libros, desde\n" +
                "el mas reciente hasta el m ´ as antiguo. ´\n" +
                "e) Verificar si la pila esta vac ´ ´ıa: Informar al usuario si no hay libros\n" +
                "en la pila.\n" +
                "f) Salir del programa");


        switch(menu){

            case "a":
                añadirLibro();

            case "b":
                consultarLibro();

            case "c":

            case "d":
        }
    }

    public static void añadirLibro(){

        String titulo = JOptionPane.showInputDialog("Introduzca el titulo del libro");


    }

    public static void consultarLibro(){



    }


    public static void eliminarLibro(){



    }

    public static void listarLibros(){



    }


    public static void verificarPilaVacia(){



    }



}