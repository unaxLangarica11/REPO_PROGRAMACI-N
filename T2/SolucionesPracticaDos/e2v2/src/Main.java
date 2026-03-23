import Modelo.Estudio;
import Modelo.Pelicula;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    // Todos los estudios que existen en el mundo
    private static Estudio[] listaEstudios;

    // Todas las películas que existen en el mundo
    private static ArrayList<Pelicula> listaPeliculas;

    public static void main(String[] args) {
        try
        {
            crearEstudios();
            crearPeliculas();
            // relacionarEstudiosConPeliculas(); El código está dentro de Pelicula.
            buscarPeliculaMasLarga();
            buscarEstudioConMasPeliculas();
        }
        catch(Exception e)
        {
            javax.swing.JOptionPane.showMessageDialog(null,e.getClass());
        }
    }

    public static void crearEstudios() throws Exception{
        // Crear objetos de tipo estudio sin películas

        listaEstudios = new Estudio[5];
        // Lista de telefonos
        ArrayList<String> telefonos = new ArrayList<>();
        telefonos.add("111111111");
        telefonos.add("111111112");
        listaEstudios[0] = new Estudio("Universal", "Los Angeles"," C/ a","www.universal.es",LocalDate.of(1950,9,23),"EEUU",telefonos);



        telefonos = new ArrayList<>();
        telefonos.add("222222222");
        telefonos.add("222222223");
        listaEstudios[1] = new Estudio("Walt Disney", "Los Angeles"," C/ b","www.disney.es",LocalDate.of(1960,9,23),"EEUU",telefonos);



        telefonos = new ArrayList<>();
        telefonos.add("333333333");
        telefonos.add("333333334");
        telefonos.add("333333335");
        //listaEstudios[2] = new Estudio("Warner Bros", "California"," C/ c","www.warner.es",LocalDate.of(1956,1,10),"EEUU",telefonos);
        listaEstudios[2] = new Estudio();
        listaEstudios[2].setNombre("Warner Bros");
        listaEstudios[2].setPais("EEUU");
        listaEstudios[2].setCiudad("California");
        listaEstudios[2].setDireccion(" C/ c");
        listaEstudios[2].setFechaFundacion(null);
        listaEstudios[2].setDirWeb("www.warner.es");
        listaEstudios[2].setTelefonos(telefonos);
        listaEstudios[2].setFechaFundacion(LocalDate.of(1956, 1,10));



        /*telefonos = new ArrayList();
        telefonos.add("444444444");
        telefonos.add("444444445");*/
        listaEstudios[3] = new Estudio("Paramount", "Los Angeles"," C/ d","www.paramount.es",LocalDate.of(1955,9,23),"EEUU");
        listaEstudios[3].setTelefono("444444444");
        listaEstudios[3].setTelefono("444444445");


        telefonos = new ArrayList<>();
        telefonos.add("555555555");
        listaEstudios[4] = new Estudio("20Th Century Fox", "Los Angeles"," C/ e","www.fox.es",LocalDate.of(1953,9,23),"EEUU",telefonos);
    }

    public static void crearPeliculas() throws Exception{
        // Creo peliculas ya con los estudios
        listaPeliculas = new ArrayList<>();

        // Estudios de la película
        ArrayList <Estudio> lista = new ArrayList<>();
        lista.add(listaEstudios[0]);
        lista.add(listaEstudios[2]);
        Pelicula p = new Pelicula("ET",1980,90.7f,"Infantil",lista);
        listaPeliculas.add(p);

        // Estudios de la película
        lista = new ArrayList<>();
        lista.add(listaEstudios[1]);
        lista.add(listaEstudios[2]);
        listaPeliculas.add(new Pelicula("Titanic",1997,180,"Romántica",lista));


        // Estudios de la película
        lista = new ArrayList<>();
        lista.add(listaEstudios[4]);
        listaPeliculas.add(new Pelicula("El señor de los anillos",2003,133,"Ciencia ficción",lista));


        // Estudios de la película
        lista = new ArrayList<>();
        lista.add(listaEstudios[3]);
        lista.add(listaEstudios[4]);
        lista.add(listaEstudios[1]);
        lista.add(listaEstudios[2]);
        listaPeliculas.add(new Pelicula("Piratas del Caribe",2003,220,"Aventuras",lista));

        // Estudios de la película
        lista = new ArrayList<>();
        lista.add(listaEstudios[4]);
        listaPeliculas.add(new Pelicula("El rey león",1994,97,"Infantil",lista));
    }

    public static void buscarPeliculaMasLarga() throws Exception{
        float maximo = 0;
        Pelicula objeto=null;
        for (Pelicula listaPelicula : listaPeliculas) {
            if (listaPelicula.getDuracion() > maximo) {
                maximo = listaPelicula.getDuracion();
                objeto = listaPelicula;
            }
        }

        // Nombre de todos los estudios que han producido la película
        StringBuilder mensaje = new StringBuilder();
        for (int x = 0; x < objeto.getListaEstudios().size();x++)
            mensaje.append(" ").append(objeto.getListaEstudios().get(x).getNombre());

        javax.swing.JOptionPane.showMessageDialog(null," La pelicula más larga es " + objeto.getTitulo()+ " y se ha producido en " + mensaje);
    }

    public static void buscarEstudioConMasPeliculas() throws Exception{
        // En estudio tengo el arrayList de películas.
        float maximo = 0;
        Estudio objeto=null;
        for (Estudio listaEstudio : listaEstudios)
            if (listaEstudio.getListaPeliculas().size() > maximo) {
                maximo = listaEstudio.getListaPeliculas().size();
                objeto = listaEstudio;
            }
        StringBuilder mensaje = new StringBuilder(" El estudio que más películas ha producido es " + objeto.getNombre() + " y ha producido " + objeto.getListaPeliculas().size() + " peliculas cuyos títulos son: ");
        for (int x = 0; x < objeto.getListaPeliculas().size();x++)
            mensaje.append("\n").append(objeto.getListaPeliculas().get(x).getTitulo());

        javax.swing.JOptionPane.showMessageDialog(null, mensaje.toString());
    }

}
