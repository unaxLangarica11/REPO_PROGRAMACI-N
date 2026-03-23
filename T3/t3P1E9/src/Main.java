import javax.swing.*;
import java.util.Scanner;

public class Main {
    static int [][][] tiempo;



    static double[] grados;
    static int[] dias;
    static String[] ciudades;
    static StringBuilder mediaPorCiudades = new StringBuilder();
    static StringBuilder mediaPorDias = new StringBuilder();

    public static void main(String[] args) {
        boolean error;
        do {
            error = false;
            try {
                pedirDatos();
                pedirTemperatura();
                sacarMediaCiudad();
                sacarMediaDia();

            }catch (Exception e){
                error = true;
                JOptionPane.showMessageDialog(null,e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            }

        }while (error);

    }

    public static void pedirDatos() throws Exception{
        int numCiudades = Integer.parseInt(JOptionPane.showInputDialog("Teclea el numero de ciudades: "));
        int numDias = Integer.parseInt(JOptionPane.showInputDialog("Teclea el numero de dias: "));

        tiempo = new int[numCiudades][numDias][3];
    }

    public static void pedirTemperatura() throws Exception{

        for(int i = 0; i < tiempo.length; i++){
            for(int j = 0; j < tiempo[i].length; j++){
                for(int k = 0; k < tiempo[i][j].length; k++){
                    tiempo[i][j][k] = Integer.parseInt(JOptionPane.showInputDialog("Introduce la temperatura de " + (i+1) + " dia " + (j+1) + " hora " + (k+1) ""));
                }
            }
        }
    }


    public static void sacarMediaCiudad() throws Exception{

        int media = 0;
        int contador = 0;

        for(int i = 0; i < tiempo.length; i++){

            for(int j = 0; j < tiempo[i].length; j++){

                for(int k = 0; k < tiempo[i][j].length; k++){

                    media += tiempo[i][j][k];
                    contador++;

                }
            }
            media = media/contador;
            mediaPorCiudades.append("\nCiudad" + (i+1) + ": " + media);
        }

        JOptionPane.showMessageDialog(null,mediaPorCiudades.toString());
    }

    public static void sacarMediaDia() throws Exception{

        int media = 0;
        int contador = 0;

        for(int i = 0; i < tiempo.length; i++){

            for(int j = 0; j < tiempo[i].length; j++){

                for(int k = 0; k < tiempo[i][j].length; k++){

                    media += tiempo[i][j][k];
                    contador++;

                }
                media = media/contador;
                mediaPorDias.append("\nCiudad" + (i+1) + ": " + media);
            }

        }
        JOptionPane.showMessageDialog(null,mediaPorDias.toString());


    }
}