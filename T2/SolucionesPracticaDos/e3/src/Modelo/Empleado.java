package Modelo;

public class Empleado extends Persona{

    private double sueldoBruto;

    // private Director d;

    public Empleado(String nombre,int edad,double sueldo)
    {
        // Constructor de la clase padre
        super(nombre,edad);
        //this.setNombre(nombre);
        this.sueldoBruto = sueldo;
    }

    public double getSueldoBruto() {
        return sueldoBruto;
    }

    public void setSueldoBruto(double sueldoBruto) {
        this.sueldoBruto = sueldoBruto;
    }

    @Override
    public String mostrar(){
        //return nombre + " " + edad + " " + sueldoBruto;
        return this.getNombre() + " " + this.getEdad() + " " + this.getSueldoBruto();
    }

    public Double calcularSalarioNeto(){
        return sueldoBruto * 0.9;
    }

}

