package com.mycompany.gamestore.persistence;

import com.mycompany.gamestore.logica.Console;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ConsoleJpaController implements Serializable{

      public ConsoleJpaController (EntityManagerFactory emf){
        this.emf = emf;
    }
    
    private EntityManagerFactory emf = null;
    
    public ConsoleJpaController() {
        this.emf = Persistence.createEntityManagerFactory("gameStorePU");
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Crear una nueva Console
    public void create(Console console) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(console);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Buscar una Console por ID
    public Console findConsole(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Console.class, id);
        } finally {
            em.close();
        }
    }

    // Obtener todas las Consolas
    public List<Console> findConsoleEntities() {
        return findConsoleEntities(true, -1, -1);
    }

    // Obtener todas las Consolas con paginación
    public List<Console> findConsoleEntities(int maxResults, int firstResult) {
        return findConsoleEntities(false, maxResults, firstResult);
    }

    private List<Console> findConsoleEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            javax.persistence.criteria.CriteriaQuery<Console> cq = em.getCriteriaBuilder().createQuery(Console.class);
            cq.select(cq.from(Console.class));
            javax.persistence.Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    // Eliminar una Console
    public void destroy(Integer id) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Console console;
            try {
                console = em.getReference(Console.class, id);
                console.getConsoleId();
            } catch (javax.persistence.EntityNotFoundException enfe) {
                throw new Exception("The console with id " + id + " no longer exists.", enfe);
            }
            em.remove(console);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Actualizar una Console
    public void edit(Console console) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            console = em.merge(console);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findConsole(console.getConsoleId()) == null) {
                throw new Exception("The console with id " + console.getConsoleId() + " no longer exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}