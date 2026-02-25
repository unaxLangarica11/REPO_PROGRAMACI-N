import java.time.LocalDate;

public class Mascota {

    private String nombre;
    private String raza;
    private LocalDate fechaNacimiento;
    private float peso;
    private String sexo;
    private float longitud;
    private String color;


    //relaciones

    private Cliente dueño;
    public Veterinario v;

    //constructor

    public Mascota() {

    }
}
