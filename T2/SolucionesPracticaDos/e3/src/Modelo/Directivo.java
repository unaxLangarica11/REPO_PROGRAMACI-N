package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Directivo extends Empleado{

    private String categoria;
    // Relación con Empleado
    private List<Empleado> subordinados;

    public Directivo(String nombre,int edad,double sueldo,String categoria)
    {
        super(nombre,edad,sueldo);
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<Empleado> getSubordinados() {
        return subordinados;
    }

    public void setSubordinados(ArrayList<Empleado> subordinados) {
        this.subordinados = subordinados;
    }


    @Override
    public String mostrar(){
        return this.getNombre() + " " + this.getEdad() + " " + this.getSueldoBruto() + " " + this.getCategoria();
    }
}

