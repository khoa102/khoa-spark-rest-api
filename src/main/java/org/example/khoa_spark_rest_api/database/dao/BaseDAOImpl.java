package org.example.khoa_spark_rest_api.database.dao;

import lombok.extern.slf4j.Slf4j;
import org.example.khoa_spark_rest_api.database.JPAUtil;

import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Slf4j
public abstract class BaseDAOImpl<T> implements BaseDAO<T> {

    public boolean save(T object) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
            em.close();
            return true;
        } catch (Exception e) {
            log.error("Exception when save in {}: {}", getActualDAOName(), e.getMessage(), e);
        }
        return false;
    }

    public List<T> getAll() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        return em.createQuery(String.format("SELECT table FROM %s table", getPersistentClass().getSimpleName()), getPersistentClass())
                .getResultList();
    }

    public T getById(int id) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        return em.createQuery(String.format("SELECT table FROM %s table WHERE table.id = :id", getPersistentClass().getSimpleName()), getPersistentClass())
                .setParameter("id", id)
                .getSingleResult();
    }

     protected String getActualDAOName() {
        return this.getClass().getSimpleName();
     }

    @SuppressWarnings("unchecked")
    private Class<T> getPersistentClass() {
        return (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }
}
