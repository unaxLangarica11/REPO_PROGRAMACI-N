public class Main {

    private static List<Libro>
    public static void main(String[] args) {

        llenarDatos();

        mostrarMenu();



    }

    private static void mostrarMenu() {

        String menu = switch(){
            case 1: alquilarLibro():

            case 2: devolverLibro():

            case 3: verDatos():

            case 4: salir():

        }


    }


}

//atributos libro
private String titulo;
private String editorial;
private int numPaginas;


//atributos persona
private String nombre;
private LocalDate fechaNacimiento;
private String paisNacimiento;

private String DNI;