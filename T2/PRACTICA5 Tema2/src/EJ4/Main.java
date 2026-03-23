package EJ4;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) {

    String correo = "";
    if (validarCorreo(correo)){
        JOptionPane.showMessageDialog(null, "El correo es correcto");
    } else {JOptionPane.showMessageDialog(null, "El correo no existe");}


    }


    public static boolean validarCorreo(String correo) {
        correo = JOptionPane.showInputDialog("Ingrese su correo");
        Pattern p = Pattern.compile("^[\\\\w.-]+@(gmail|hotmail|ikasle.egibide)\\\\.(com|org|net|es)$");
        Matcher m = p.matcher(correo);

        return m.matches();
    }
}