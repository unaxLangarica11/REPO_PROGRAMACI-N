package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String nombre;

    // Relaciones: Empresa formada por clientes y empleados
    private List<Cliente> listaClientes;
    private List<Empleado> listaEmpleados;

    public Empresa(String nombre) {
        this.nombre = nombre;
    }

    public Empresa(String nombre, List<Cliente> listaClientes)
    {
        this.nombre = nombre;
        this.listaClientes = listaClientes;
        this.listaEmpleados = new ArrayList<>();
    }

    public Empresa(String nombre, List<Cliente> listaClientes, List<Empleado> listaEmpleados) {
        this.nombre = nombre;
        this.listaClientes = listaClientes;
        this.listaEmpleados = listaEmpleados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public void setEmpleado(Empleado e){
        listaEmpleados.add(e);
    }

    public Empleado getEmpleado(int x){
        return listaEmpleados.get(x);
    }

}
