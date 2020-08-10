package edu.miu.lelafoods.order.dao;

import java.util.List;

public interface GenericDao<T> {
    void save(T t);

    void deleteById(Long id);

    T findOne(Long id);

    T update(T t);

    List<T> findAll();



}
