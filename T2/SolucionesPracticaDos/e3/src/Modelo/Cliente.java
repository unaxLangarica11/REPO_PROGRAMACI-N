package Modelo;

public class Cliente extends Persona{

    private String telefonoContacto;

    public Cliente(String nombre,int edad,String telefono)
    {
       // this.setNombre(nombre);
        super(nombre,edad);
        this.telefonoContacto =  telefono;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public String mostrar(){
        //return this.getNombre() + " " + this.getEdad() + " " + this.getTelefonoContacto();
        return super.mostrar() + " " + this.telefonoContacto;
    }

}

