package ua.training.model.dao;

import java.util.List;

public interface GenericDao<T> extends AutoCloseable {
    int create(T entity);
    T findById(int id);
    List<T> findAll();
    int delete(int id);
    int update(T entity);
}
