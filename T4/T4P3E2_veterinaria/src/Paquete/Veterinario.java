package Paquete;

import java.util.ArrayList;

public class Veterinario extends Cliente{

    private String dni;
    private String numSS;
    //
    ArrayList<Mascota> listaMascotasPacientes;
    //


    public Veterinario(String dni, String numSS, ArrayList<Mascota> listaMascotasPacientes) {
        this.dni = dni;
        this.numSS = numSS;
        this.listaMascotasPacientes = listaMascotasPacientes;
    }

    //

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNumSS() {
        return numSS;
    }

    public void setNumSS(String numSS) {
        this.numSS = numSS;
    }

    public ArrayList<Mascota> getListaMascotasPacientes() {
        return listaMascotasPacientes;
    }

    public void setListaMascotasPacientes(ArrayList<Mascota> listaMascotasPacientes) {
        this.listaMascotasPacientes = listaMascotasPacientes;
    }

    //

    @Override
    public String toString() {
        return "Veterinario{" +
                "dni='" + dni + '\'' +
                ", numSS='" + numSS + '\'' +
                ", listaMascotasPacientes=" + listaMascotasPacientes +
                '}';
    }
}
