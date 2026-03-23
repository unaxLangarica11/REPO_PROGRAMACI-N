package Paquete;

import java.util.ArrayList;

public class Usuario {

    private String nombre;
    private String email;

    //

    ArrayList<Pedido> pedidos;

    //

    public Usuario(String nombre, String email, ArrayList<Pedido> pedidos) {
        this.nombre = nombre;
        this.email = email;
        this.pedidos = pedidos;
    }

    public Usuario() {
    }

    //


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    //

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", pedidos=" + pedidos +
                '}';
    }
}


