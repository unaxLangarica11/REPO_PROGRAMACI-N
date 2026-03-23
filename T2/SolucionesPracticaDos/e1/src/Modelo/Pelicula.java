package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Pelicula
{
    private String titulo;
    private  int anno;
    private float duracion;
    private String tipo;

    // Relación: Película producida por uno o más estudios
    private List<Estudio> listaEstudios;

    // Constructor que crea y llena
    public Pelicula(String titulo, int anno, float duracion, String tipo, ArrayList<Estudio> listaEstudios) {
        this.titulo = titulo;
        this.anno = anno;
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

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
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

    public List<Estudio> getListaEstudios() {
        return listaEstudios;
    }

    public void setListaEstudios(ArrayList<Estudio> listaEstudios)
    {
        this.listaEstudios = listaEstudios;
    }

    public void setListaEstudio(Estudio e)
    {
        if (this.listaEstudios == null)
            listaEstudios = new ArrayList<>();
        this.listaEstudios.add(e);
    }

}
