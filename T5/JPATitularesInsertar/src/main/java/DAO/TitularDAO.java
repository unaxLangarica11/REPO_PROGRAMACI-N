package DAO;

import Modelo.Titular;
import Utilidades.DBConnection;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class TitularDAO {

    private EntityManagerFactory emf;

    public TitularDAO()
    {
            this.emf = DBConnection.getEntityManagerFactory();
    }

    public void insertar(Titular titular) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(titular);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    //persist find remove query

    public void modificar (Titular titular) {
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();
            em.merge(titular);
            em.getTransaction().commit();


        }catch(Exception e){
            em.getTransaction().rollback();
            throw e;

        }finally {
            em.close();

        }


    }

    public void eliminar (int id) {

        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();
            Titular titular = em.find(Titular.class, id);
            em.remove(titular);
            em.getTransaction().commit();

        }catch (Exception e){
            em.getTransaction().rollback();
        }
    }



}

