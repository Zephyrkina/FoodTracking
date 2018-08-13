package ua.training.model.dao;

import java.util.List;

public interface GenericDao<T> extends AutoCloseable {
    void create(T entity);
    T findById(int id);
    List<T> findAll();
    void delete(int id);
    void update(T entity);
}
