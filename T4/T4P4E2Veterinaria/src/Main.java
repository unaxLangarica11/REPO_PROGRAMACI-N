public class Main {


    public static void main(String[] args) {


    }

    public static void mostrarMenu(){

        String menu = "Escoja una de las siguientes opciones" +
                "1: Mostrar el numero de clientes que poseen un tipo de animal ´\n" +
                "concreto.\n" +
                "2: Datos personales del cliente a partir del nombre de mascota.\n" +
                "Suponemos que es unico. ´\n" +
                "3: Datos del veterinario a partir de los datos de una mascota.\n" +
                "4: Datos de las mascotas de un cliente.\n" +
                "5: Datos de las mascotas de un veterinario.\n" +
                "6: Terminar.\n";

        switch (menu){
            case "1": mostrarClientesPorAnimal();
                break;
            case "2": obtenerDatosCliente();
                break;
            case "3":
        }
    }


}