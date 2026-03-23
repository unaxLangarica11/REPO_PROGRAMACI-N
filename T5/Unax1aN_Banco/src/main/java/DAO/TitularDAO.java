package DAO;

import Modelo.Titular;
import Utilidades.DBConnection;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class TitularDAO {

    private EntityManagerFactory emf;
    private Titular t;

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

    public Titular buscarPorDni(String dni) {
        EntityManager em = emf.createEntityManager();
        try
        {
            TypedQuery<Titular> query = em.createQuery(
                    "SELECT t FROM Titular t WHERE t.dni = :dni", Titular.class);
            query.setParameter("dni", dni);
            return query.getSingleResult();
            // necesita el constructor vacío en la clase Titular para funcionar, si no lo encuentra lanza NoResultException
        }
        catch (Exception e) {
            // NoResultException o cualquier otra excepción
            return null; // Si no se encuentra el titular, devuelve null
        }
        finally {
            em.close();
        }
    }

    public void modificar(Titular titular) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(titular);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public void borrar(int id) throws Exception{
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Titular titular = em.find(Titular.class, id);
            if (titular != null) {
                em.remove(titular);
                em.getTransaction().commit();
            } else {
                throw new Exception("No se encontró ningún titular con el ID proporcionado.");
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public List<Titular> listarTodos() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Titular> query = em.createQuery("SELECT t FROM Titular t ORDER BY t.id", Titular.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Titular> buscarPorNombre(String nombre) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Titular> query = em.createQuery(
                    "SELECT t FROM Titular t WHERE t.nombre LIKE :nombre", Titular.class);
            // Que contenga el texto introducido, por eso los % antes y después
            query.setParameter("nombre", "%" + nombre + "%");
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public Titular buscarPorId(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Titular.class, id);
        } finally {
            em.close();
        }
    }
}

