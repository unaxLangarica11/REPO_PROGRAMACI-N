import javax.swing.*;

public class Main {

    static int [][] matrizNotas;

    public static void main(String[] args) {

        boolean error;

        do {
            error = false;
            try{
                pedirDatos();
                completarMatriz();

            }catch (Exception e) {
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
        }while(error);



    }

    public static void pedirDatos() throws Exception {

        int numAlumnos = Integer.parseInt(JOptionPane.showInputDialog("Indique el numero de alumnos"));
        int numAsignaturas = Integer.parseInt(JOptionPane.showInputDialog("Indique el numero de asignaturas"));


        matrizNotas = new int[numAlumnos][numAsignaturas];

    }



    public static void completarMatriz() throws Exception {

        for (int i = 0; i < matrizNotas; i++){
            for(int j = 0; j < matrizNotas[i].length; j++){

                matrizNotas[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Indica la nota " + (j+1) + " del alumno " +   º (i+1)));
            }
        }

    }

    public static void calcularMedias() throws Exception {

        for(int i = 0; i < matrizNota[i]s.length; i++){}
    }

}