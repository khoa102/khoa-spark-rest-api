package org.example.khoa_spark_rest_api.database.dao;

import java.util.List;

@SuppressWarnings("UnusedReturnValue")
public interface BaseDAO<T> {
    boolean save(T object);
    List<T> getAll();
    T getById(int id);
}
