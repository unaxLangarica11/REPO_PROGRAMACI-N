package Paquete;

public class Producto {

    private String nombre;
    private double precio;
    private int stock;
    //
    Pedido pedido;
    //


    public Producto(String nombre, double precio, int stock, Pedido pedido) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.pedido = pedido;
    }

    public Producto() {
    }

    //


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    //

    
}
