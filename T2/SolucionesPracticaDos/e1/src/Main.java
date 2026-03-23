import Modelo.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class Main {

    // Todos los estudios que existen en el mundo
    private static Estudio[] estudios;

    // Todas las películas que existen en el mundo
    private static List<Pelicula> listaPeliculas;

    public static void main(String[] args) {
        try{
            crearEstudios();
            crearPeliculas();
            buscarPeliculaMasLarga();
            buscarEstudioConMasPeliculas();
        }
        catch(Exception e)
        {
            System.out.println(e.getClass());
        }
    }

    public static void crearEstudios() throws Exception{
        // Crear objetos de tipo estudio sin películas

        estudios = new Estudio[5];
        // Lista de telefonos del primer estudio
        ArrayList<String> telefonos = new ArrayList<>();
        telefonos.add("111111111");
        telefonos.add("111111112");
        estudios[0] = new Estudio("Universal", "Los Angeles"," C/ a","www.universal.es",LocalDate.of(1950,9,23),"EEUU",telefonos);

        // Lista de telefonos del segundo estudio
        telefonos = new ArrayList<>();
        telefonos.add("222222222");
        telefonos.add("222222223");
        estudios[1] = new Estudio("Walt Disney", "Los Angeles"," C/ b","www.disney.es",LocalDate.of(1960,9,23),"EEUU",telefonos);

        // Lista de telefonos del tercer estudio
        telefonos = new ArrayList<>();
        telefonos.add("333333333");
        telefonos.add("333333334");
        telefonos.add("333333335");

        // listaEstudios[2] = new Estudio("Warner Bros", "California"," C/ c","www.warner.es",LocalDate.of(1956,1,10),"EEUU",telefonos);
        // Uso del constructor vacío
        estudios[2] = new Estudio();
        estudios[2].setNombre("Warner Bros");
        estudios[2].setPais("EEUU");
        estudios[2].setCiudad("California");
        estudios[2].setDireccion(" C/ c");
        estudios[2].setDirWeb("www.warner.es");
        estudios[2].setTelefonos(telefonos);
        estudios[2].setFechaFundacion(LocalDate.of(1956, 1,10));

        /*telefonos = new ArrayList();
        telefonos.add("444444444");
        telefonos.add("444444445");*/

        // Constructor sin teléfonos.
        estudios[3] = new Estudio("Paramount", "Los Angeles"," C/ d","www.paramount.es",LocalDate.of(1955,9,23),"EEUU");
        estudios[3].setTelefono("444444444");
        estudios[3].setTelefono("444444445");

        telefonos = new ArrayList<>();
        telefonos.add("555555555");
        estudios[4] = new Estudio("20Th Century Fox", "Los Angeles"," C/ e","www.fox.es",LocalDate.of(1953,9,23),"EEUU",telefonos);
    }

    public static void crearPeliculas() throws Exception{
        // Creo peliculas ya con los estudios
        listaPeliculas = new ArrayList<>();

        // Estudios de la película ET
        ArrayList <Estudio> lista = new ArrayList<>();
        lista.add(estudios[0]); // Universal
        lista.add(estudios[2]); // Warner
        Pelicula p = new Pelicula("ET",1980,90.7f,"Infantil",lista);
        listaPeliculas.add(p);

        // Estudios de la película Titanic
        lista = new ArrayList<>();
        lista.add(estudios[1]); // Walt Disney
        lista.add(estudios[2]); // Warner
        listaPeliculas.add(new Pelicula("Titanic",1197,180,"Romántica",lista));


        // Estudios de la película El señor de los anillos
        lista = new ArrayList<>();
        lista.add(estudios[4]); // Century Fox
        listaPeliculas.add(new Pelicula("El señor de los anillos",2003,133,"Ciencia ficción",lista));


        // Estudios de la película Piratas del Caribe
        lista = new ArrayList<>();
        lista.add(estudios[3]); // Paramount
        lista.add(estudios[4]); // Century Fox
        lista.add(estudios[1]); // Walt Disney
        //lista.add(listaEstudios[2]); // Warner Bros
        listaPeliculas.add(new Pelicula("Piratas del Caribe",2003,220,"Aventuras",lista));
        listaPeliculas.get(listaPeliculas.size() - 1).setListaEstudio(estudios[2]);
        // Con 220 minutos es la película más larga.

        // Estudios de la película El rey León
        lista = new ArrayList<>();
        lista.add(estudios[3]); // Walt Disney
        listaPeliculas.add(new Pelicula("El rey león",1994,97,"Infantil",lista));
    }

    public static void buscarPeliculaMasLarga() throws Exception
    {
        float maximo = 0;
        Pelicula objeto=null;
        for (Pelicula listaPelicula : listaPeliculas) {
            if (listaPelicula.getDuracion() > maximo) {
                maximo = listaPelicula.getDuracion();
                objeto = listaPelicula;
            }
        }

       /* Forma dos
       objeto = listaPeliculas.stream()
                .max((p1, p2) -> Float.compare(p1.getDuracion(), p2.getDuracion()))
                .orElse(null);
      */

        // Nombre de todos los estudios que han producido la película
        StringBuilder mensaje = new StringBuilder();
        for (Estudio estudio : objeto.getListaEstudios()) {
            mensaje.append(" ").append(estudio.getNombre());
        }

       //objeto.getListaEstudios().forEach(estudio -> mensaje.append(" ").append(estudio.getNombre()));

        javax.swing.JOptionPane.showMessageDialog(null," La película más larga es " + objeto.getTitulo()+ " y se ha producido en " + mensaje);
    }

    public static void buscarEstudioConMasPeliculas() throws Exception{
        // En estudio NO tengo las películas
        // Hay que conseguir el número de películas de cada estudio
        // arrays coincidentes
        
        Integer [] numeroPeliculas = new Integer[5];
        Arrays.fill(numeroPeliculas, 0);


        // Por cada Estudio recorro la lista de todas las películas para ver si está o no.
        for(int z = 0; z < estudios.length; z++)
            for (Pelicula listaPelicula : listaPeliculas) {
                boolean salir = false;
                for (int y = 0; y < listaPelicula.getListaEstudios().size() && !salir; y++)
                {
                    if (listaPelicula.getListaEstudios().get(y).equals(estudios[z])) {
                        numeroPeliculas[z] += 1;
                        salir = true;
                    }
                }
            }


        /*
        // Busco el máximo contador
        int maximo = 0;
        int posicion = 0;
        // For 'normal' o for mejorado.
        for (int x = 0; x < numeroPeliculas.length; x++)
            if(numeroPeliculas[x] > maximo)
            {
                maximo = numeroPeliculas[x];
                posicion = x;
            }
         */



        // Convertir el array a una lista para usar los métodos de Collections
        List<Integer> numeroPeliculasList = Arrays.stream(numeroPeliculas).toList();

        // Encontrar el máximo usando Collections.max
        int maximo = Collections.max(numeroPeliculasList);
        int posicion = numeroPeliculasList.indexOf(maximo);


        javax.swing.JOptionPane.showMessageDialog(null,"El estudio que más películas ha producido es: " + estudios[posicion].getNombre() + " y ha producido "+ maximo);
    }
}
