package Paquete;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pedido {

    private LocalDate fecha;
    //
    Usuario usuario;
    ArrayList<Producto> productos;
    //

    public Pedido(LocalDate fecha, ArrayList<Producto> productos) {
        this.fecha = fecha;
        this.productos = productos;
    }

    public Pedido() {
    }

    //


    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    //


    @Override
    public String toString() {
        return "Pedido{" +
                "fecha=" + fecha +
                ", productos=" + productos +
                '}';
    }
}
