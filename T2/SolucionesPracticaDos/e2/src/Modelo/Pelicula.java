package Modelo;

import java.util.ArrayList;

public class Pelicula {
    private String titulo;
    private  int año;
    private float duracion;
    private String tipo;

    // Relación: Película producida por uno o más estudios
    private ArrayList<Estudio> listaEstudios;

    // Constructor que crea y llena
    public Pelicula(String titulo, int año, float duracion, String tipo, ArrayList<Estudio> listaEstudios) {
        this.titulo = titulo;
        this.año = año;
        this.duracion = duracion;
        this.tipo = tipo;
        this.listaEstudios = listaEstudios;
    }

    // set y get de cada uno de los atributos
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public float getDuracion() {
        return duracion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Estudio> getListaEstudios() {
        return listaEstudios;
    }

    public void setListaEstudios(ArrayList<Estudio> listaEstudios) {

        this.listaEstudios = listaEstudios;
    }

    public void setListaEstudio(Estudio e)
    {
        this.listaEstudios.add(e);
    }

}
