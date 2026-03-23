package Modelo;

public class Titular {
    private int id;
    private String dni;
    private String nombre;

    // Lista de cuentas corrientes asociadas a este titular (opcional, dependiendo de cómo quieras manejar las relaciones)

    public Titular() {}

    public Titular(int id, String dni, String nombre) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
    }

    public Titular(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Titular{" +
                "id=" + id +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}

