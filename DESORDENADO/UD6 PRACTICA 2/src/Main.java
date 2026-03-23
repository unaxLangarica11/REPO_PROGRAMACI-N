import javax.swing.*;

public class Main {

    static int cantidadXprecio = 0;
    static double precio;
    public static void main(String[] args) {


        generarFactura(pedirNombre());


    }

    public static String pedirNombre(){
        String nombreCliente = JOptionPane.showInputDialog("Ingrese el nombre del cliente");
        return nombreCliente;
    }

    public static String generarFactura(String nombreCliente){

        StringBuilder factura = new StringBuilder();
        StringBuilder porcentajesIVA = new StringBuilder();

        factura.append("NOMBRE: " + nombreCliente + "\nLINEAS DE DETALLE:\n");

        int cantidadProd = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el cantidad de productos"));

        int i = 0;
        do {

            cantidadXprecio += cantidadProd  * precio;
            precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto"));
            int IVA = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el IVA (21,10,4): "));

            factura.append(cantidadProd + " x " + precio + " = " + (cantidadProd  * precio)+ "\n" + "TOTAL SIN IVA: " + cantidadXprecio);
            porcentajesIVA.append(IVA + "% de IVA de " + (cantidadProd  * precio) + " = " + (cantidadProd  * precio) * 0.01*IVA + "\n");
            i++;



        }while (i < cantidadProd);



    }
}