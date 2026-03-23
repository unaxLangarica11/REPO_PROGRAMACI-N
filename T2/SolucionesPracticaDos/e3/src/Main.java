import Modelo.*;
import java.util.ArrayList;
import java.util.List;

public class Main{

    public static void main(String[] args) {
        // Creo empresas
        Empresa [] listaEmpresas = new Empresa[3];
        // La primera solo con el nombre
        listaEmpresas[0] = new Empresa("Michelin");
        listaEmpresas[0].setListaClientes(getListaClientes0());
        listaEmpresas[0].setListaEmpleados(getListaEmpleados0());

        // La segunda con nombre y clientes
        listaEmpresas[1] = new Empresa("Mercedes",getListaClientes1());
        listaEmpresas[1].setListaEmpleados(getListaEmpleados1());

        // La tercera con nombre y clientes. Los empleados los añado de uno en uno.
        listaEmpresas[2] = new Empresa("Egibide",getListaClientes2());
        annadirEmpleados(listaEmpresas[2]);

        // Proceso
        buscarDirectivoConMasSubordinados(listaEmpresas);
    }

    public static void annadirEmpleados(Empresa empresa){
        // Añadir empleados a una empresa.
        Empleado e = new Empleado("Juan",50,1000);
        empresa.setEmpleado(e);
        e = new Empleado("Pepe",50,1000);
        empresa.setEmpleado(e);
        Directivo objD = new Directivo("Jefe egibide",45,50000,"Categoria uno");

        // El directivo todavía no está completo, faltan los subordinados.
        ArrayList<Empleado> listaSubordinados = new ArrayList<>();
        listaSubordinados.add(e);
        objD.setSubordinados(listaSubordinados);

        empresa.setEmpleado(objD);

    }
    public static ArrayList<Cliente> getListaClientes0(){
        // ArrayList con los clientes de la empresa de la posición cero.
        ArrayList<Cliente> lista = new ArrayList<>();
        // Clientes con nombre, edad y teléfono
        lista.add(new Cliente("c1",21,"111"));
        lista.add(new Cliente("c2",31,"411"));
        lista.add(new Cliente("c3",41,"611"));
        return lista;
    }
    public static List<Cliente> getListaClientes2(){
        // ArrayList con los clientes de la empresa de la posición dos del array.
        List<Cliente> lista = new ArrayList<>();
        // Clientes con nombre, edad y teléfono
        lista.add(new Cliente("A1",21,"111"));
        lista.add(new Cliente("A2",31,"411"));
        lista.add(new Cliente("A3",41,"611"));
        return lista;
    }
    public static ArrayList<Empleado> getListaEmpleados0(){
        // Lista de empleados de la empresa de la posición cero del array.
        ArrayList<Empleado> lista = new ArrayList<>();
        // Empleados con nombre, edad y sueldoBruto
        lista.add(new Empleado("e1",21,10000));
        lista.add(new Empleado("e2",31,20000));
        lista.add(new Empleado("e3",41,30000));

        // Uno de los empleados será el jefe
        Directivo objD = new Directivo("Jefe1",45,50000,"Categoria uno");

        // Un directivo también es un empleado
        lista.add(objD);

        // El directivo todavía no está completo, faltan los subordinados.
        ArrayList<Empleado> listaSubordinados = new ArrayList<>();
        listaSubordinados.add(lista.get(0));
        objD.setSubordinados(listaSubordinados);

        objD = new Directivo("Jefe2",45,50100,"Categoria uno");
        listaSubordinados = new ArrayList<>();
        listaSubordinados.add(lista.get(1));
        listaSubordinados.add(lista.get(2));
        objD.setSubordinados(listaSubordinados);
        lista.add(objD);

        return lista;
    }
    public static ArrayList<Cliente> getListaClientes1(){
        // Lista de los clientes de la empresa de la posición uno del array.
        ArrayList<Cliente> lista = new ArrayList<>();
        lista.add(new Cliente("Pepe",27,"118"));
        lista.add(new Cliente("Juan",37,"418"));
        lista.add(new Cliente("Imanol",47,"618"));
        lista.add(new Cliente("Maria",61,"111"));
        lista.add(new Cliente("Teresa",39,"411"));
        return lista;
    }
    public static ArrayList<Empleado> getListaEmpleados1(){
        // Lista de empleados de la empresa de la posición uno del array.
        ArrayList<Empleado> lista = new ArrayList<>();
        lista.add(new Empleado("e11",21,10500));
        lista.add(new Empleado("e21",31,20500));
        lista.add(new Empleado("e31",41,30500));
        lista.add(new Empleado("e51",21,100500));
        lista.add(new Empleado("e61",36,40000));

        Directivo objD = new Directivo("Jefe 56",45,50000,"Categoria uno");
        ArrayList<Empleado> listaSubordinados = new ArrayList<>();
        listaSubordinados.add(lista.get(0));
        listaSubordinados.add(lista.get(1));
        listaSubordinados.add(lista.get(2));
        objD.setSubordinados(listaSubordinados);
        lista.add(objD);

        objD = new Directivo("Jefe 67",45,50100,"Categoria uno");
        listaSubordinados = new ArrayList<>();
        listaSubordinados.add(lista.get(3));
        listaSubordinados.add(lista.get(4));
        objD.setSubordinados(listaSubordinados);
        lista.add(objD);

        return lista;
    }
    public static void buscarDirectivoConMasSubordinados(Empresa [] lista){
        int max = 0;
        Directivo objetoMaximo = null;

        // En todas las empresas.
        for (Empresa empresa : lista) {
            // empleados de una empresa
            for (int y = 0; y < empresa.getListaEmpleados().size(); y++) {
                // Es o no es un directivo? En el ArrayList hay empleados y directivos.
                if (empresa.getListaEmpleados().get(y) instanceof Directivo) {
                    // conversión
                    Directivo objeto = (Directivo) empresa.getListaEmpleados().get(y);
                    if (objeto.getSubordinados().size() > max) {
                        objetoMaximo = objeto;
                        max = objeto.getSubordinados().size();
                    }
                }
            }

        }
        javax.swing.JOptionPane.showMessageDialog(null, " El directivo que más subordinados tiene es " + objetoMaximo.getNombre() + " y tiene " + max + " empleados a su cargo");

        /* Versión más funcional
        Directivo objetoMaximo = lista.stream()                   // Transforma la lista de empresas en stream
        .flatMap(empresa -> empresa.getListaEmpleados().stream()) // Convertir la lista de empleados en un stream
        .filter(empleado -> empleado instanceof Directivo)        // Se queda solo con los directivos
        .map(empleado -> (Directivo) empleado)                    // Convierte en objeto directivo.
        .max(Comparator.comparingInt(objeto -> objeto.getSubordinados().size())) // Compara el tamaño de la lista de subordinados
        .orElse(null);
         */
    }
}

