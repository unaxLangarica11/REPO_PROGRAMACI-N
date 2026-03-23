package EJ1;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) {



         String cadena = "";


        if (validarCodigoPostal(cadena)){
            JOptionPane.showMessageDialog(null, "El codigo postal es valido");
        } else {
            JOptionPane.showMessageDialog(null, "El codigo no es valido");
        }


    }

    public static boolean validarCodigoPostal(String cadena)
    {
        cadena = (JOptionPane.showInputDialog("Introduzca un código postal"));
        Pattern p = Pattern.compile("^01\\d{3}$");

        Matcher m = p.matcher(cadena);
        return m.matches();
    }
}



// int codPostal = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo postal"));

//Pattern pat = Pattern.compile("^[0-9]{5}$");



// 2

 /*
 String codPostal = JOptionPane.showInputDialog("Ingrese el codigo postal");

 Pattern pat = Pattern.compile("^01[0-9]{4}$");

 Matcher mat = pat.matcher(codPostal);

 if (!mat.matches()) {
     JOptionPane.showMessageDialog(null, "El codigo postal no es valido");
 }


  */


// 3

 /*
 String cadena = JOptionPane.showInputDialog("Ingrese el codigo postal");

 Pattern pat = Pattern.compile("[a-zA-Z ]+");


  */