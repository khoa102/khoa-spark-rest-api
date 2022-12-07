package org.example.khoa_spark_rest_api.database.dao;

import org.example.khoa_spark_rest_api.database.JPAUtil;
import org.example.khoa_spark_rest_api.database.entity.EducationEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class EducationDAOImpl extends BaseDAOImpl<EducationEntity> implements EducationDAO {

    @Override
    public List<EducationEntity> getByUserId(int userId) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        return em.createQuery("SELECT table FROM EducationEntity table WHERE table.user.id = :userId", EducationEntity.class)
                .setParameter("userId", userId)
                .getResultList();
    }
}
