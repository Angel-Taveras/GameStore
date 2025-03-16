package com.mycompany.gamestore.persistence;

import com.mycompany.gamestore.logica.Costumer;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CostumerJpaController implements Serializable {

    
    public CostumerJpaController(EntityManagerFactory emf){
        this.emf = emf;
    }
    
    private EntityManagerFactory emf = null;

    public CostumerJpaController() {
        this.emf = Persistence.createEntityManagerFactory("gameStorePU");
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Crear un nuevo Costumer
    public void create(Costumer costumer) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(costumer);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Buscar un Costumer por ID
    public Costumer findCostumer(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Costumer.class, id);
        } finally {
            em.close();
        }
    }

    // Obtener todos los Costumers
    public List<Costumer> findCostumerEntities() {
        return findCostumerEntities(true, -1, -1);
    }

    // Obtener todos los Costumers con paginación
    public List<Costumer> findCostumerEntities(int maxResults, int firstResult) {
        return findCostumerEntities(false, maxResults, firstResult);
    }

    private List<Costumer> findCostumerEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            javax.persistence.criteria.CriteriaQuery<Costumer> cq = em.getCriteriaBuilder().createQuery(Costumer.class);
            cq.select(cq.from(Costumer.class));
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

    // Eliminar un Costumer
    public void destroy(Integer id) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Costumer costumer;
            try {
                costumer = em.getReference(Costumer.class, id);
                costumer.getId_costumer();
            } catch (javax.persistence.EntityNotFoundException enfe) {
                throw new Exception("The costumer with id " + id + " no longer exists.", enfe);
            }
            em.remove(costumer);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Actualizar un Costumer
    public void edit(Costumer costumer) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            costumer = em.merge(costumer);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCostumer(costumer.getId_costumer()) == null) {
                throw new Exception("The costumer with id " + costumer.getId_costumer() + " no longer exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}