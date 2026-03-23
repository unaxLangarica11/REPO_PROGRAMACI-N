import Modelo.Cuenta;
import Modelo.Titular;
import Utilidades.DBConnection;
import jakarta.persistence.EntityManager;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        // Crear la fábrica de EntityManager al inicio del programa para que esté disponible durante toda la ejecución
        DBConnection.crearEMF();

        // Crear cuenta
        Cuenta c = new Cuenta();
        c.setIban("ES1234567890123456789031");
        c.setSaldo(1000.0);

        EntityManager em = DBConnection.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
        System.out.println("Cuenta creada sin titulares (31)");


        // Añadir titulares
        c = new Cuenta();
        c.setIban("ES1234567890123456789032");
        c.setSaldo(1000.0);
        Set<Titular> titulares = new HashSet<Titular>();
        titulares.add(new Titular("32345678N","Juan Pérez",c));
        titulares.add(new Titular("32345678R","Mari Pérez",c));

        c.setTitulares(titulares);

        em = DBConnection.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
        System.out.println("Cuenta creada (32) pero con los titulares no ha hecho nada pero si ponemos lo de cascade también los inserta");


        //Insertar titulares
        /*c.getTitulares().forEach(t -> {
            EntityManager em2 = DBConnection.getEntityManagerFactory().createEntityManager();
            try {
                em2.getTransaction().begin();
                em2.persist(t);
                em2.getTransaction().commit();
            } catch (Exception e) {
                em2.getTransaction().rollback();
                throw e;
            } finally {
                em2.close();
            }
        });
        System.out.println("Titulares creados NR");*/

        // Mostrar titulares de una cuenta
        em = DBConnection.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            c= em.find(Cuenta.class, "ES1234567890123456789032");

            // Objeto completo. Datos de la cuenta y de los titulares.
        } finally {
            em.close();
        }
        System.out.println(c.toString());

        // Mostrar cuenta de un titular.
        Titular t;
        em = DBConnection.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            t= em.find(Titular.class, "32345678N");

            // Objeto completo.
        } finally {
            em.close();
        }
        System.out.println(t.toString());

        // Borrar cuenta
        em = DBConnection.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            c = em.find(Cuenta.class, "ES1234567890123456789032");
            if (c != null) {
                em.remove(c);
                // Al hacer commit falla porque hay titulares. Hay que cambiar la clase cuenta.
                em.getTransaction().commit();
            } else {
                throw new Exception("La cuenta no existe.");
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        System.out.println("Cuenta y titulares borrados");
    }
}
