package org.example.khoa_spark_rest_api.database.dao;

import org.example.khoa_spark_rest_api.database.entity.EducationEntity;

import java.util.List;

public interface EducationDAO extends BaseDAO<EducationEntity> {
    List<EducationEntity> getByUserId(int id);
}
