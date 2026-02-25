public class Coche {
    private String matricula;
    private String marca;
    private int año;
    private double precio;

    public Coche(String matricula, String marca, int año, double precio) {
        this.matricula = matricula;
        this.marca = marca;
        this.año = año;
        this.precio = precio;
    }

    public String getMatricula() { return matricula; }
    public String getMarca() { return marca; }
    public int getAño() { return año; }
    public double getPrecio() { return precio; }
}