package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Estudio {
    private String nombre;
    private String ciudad;
    private String direccion;
    private String dirWeb;
    private LocalDate fechaFundacion;
    private String pais;
    private List<String> telefonos;

    // Estudio NO se relaciona con película

    // Constructor sobrecargado
    public Estudio(){

    }

    public Estudio(String nombre, String ciudad, String direccion, String dirWeb, LocalDate fechaFundacion, String pais, ArrayList<String> telefonos) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.dirWeb = dirWeb;
        this.fechaFundacion = fechaFundacion;
        this.pais = pais;
        this.telefonos = telefonos;
    }

    // Sin teléfonos.
    public Estudio(String nombre, String ciudad, String direccion, String dirWeb, LocalDate fechaFundacion, String pais) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.dirWeb = dirWeb;
        this.fechaFundacion = fechaFundacion;
        this.pais = pais;
    }

    // Métodos set y get
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDirWeb() {
        return dirWeb;
    }

    public void setDirWeb(String dirWeb) {
        this.dirWeb = dirWeb;
    }

    public LocalDate getFechaFundacion() {
        return fechaFundacion;
    }

    public void setFechaFundacion(LocalDate fechaFundacion) {
        this.fechaFundacion = fechaFundacion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public List<String> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(ArrayList<String> telefonos) {
        this.telefonos = telefonos;
    }

    public void setTelefono(String t)
    {
        if (this.telefonos == null) // Por si no está creado.
            this.telefonos = new ArrayList<>();

        // Opción dos new en el constructor.
        this.telefonos.add(t);
    }

}
