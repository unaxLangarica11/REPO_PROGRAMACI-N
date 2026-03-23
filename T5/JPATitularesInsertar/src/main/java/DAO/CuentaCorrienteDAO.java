package DAO;

import Modelo.CuentaCorriente;
import Utilidades.DBConnection;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class CuentaCorrienteDAO {

    private EntityManagerFactory emf;

    public CuentaCorrienteDAO() {
        this.emf = DBConnection.getEntityManagerFactory();
    }

    public void insertar (CuentaCorriente cuentaCorriente) {
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(cuentaCorriente);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    }
}
