package dbs;

import jakarta.persistence.*;
import java.util.List;

public class DAO {


    private EntityManager em;

    public DAO(EntityManagerFactory emf) {

        em = emf.createEntityManager();
    }


    public static <T> void createEntity(EntityManager em, T entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    public static <T> T getEntity(EntityManager em, Class<T> entityType, Object primaryKey) {
        return em.find(entityType, primaryKey);
    }

    public static <T> void updateEntity(EntityManager em, T entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    public static <T> void deleteEntity(EntityManager em, T entity) {
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
    }

    public Long getTableEntryCount(EntityManager em, String tableName) {
        String query = "SELECT COUNT(e) FROM " + tableName + " e";
        TypedQuery<Long> typedQuery = em.createQuery(query, Long.class);
        return typedQuery.getSingleResult();
    }

    public static <T> List<T> getAllEntities(EntityManager em, Class<T> entityType) {
        TypedQuery<T> query = em.createQuery("SELECT e FROM " + entityType.getSimpleName() + " e", entityType);
        return query.getResultList();
    }

    public static <T> List<T> getAllEntities(EntityManager em, Class<T> entityType, Integer primaryKey) {
        TypedQuery<T> query = em.createQuery("SELECT e FROM " + entityType.getSimpleName() + " e WHERE e.id = " + primaryKey, entityType);
        return query.getResultList();
    }

    public EntityManager getEm() {
        return em;
    }



}
