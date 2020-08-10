package edu.miu.lelafoods.order.dao.impl;

import edu.miu.lelafoods.order.dao.GenericDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public  abstract  class GenericDaoImpl<T> implements GenericDao<T> {
    @PersistenceContext
    protected EntityManager entityManager;

    protected Class<T> daoType;

    public void setDaoType(Class<T> type) {
        daoType = type;
    }

    @Override
    public void save( T entity ){
        entityManager.persist( entity );
    }


    public void delete( T entity ){
        entityManager.remove( entity );
    }

    @Override
    public void deleteById(Long id) {
        T entity = findOne( id );
        delete( entity );
    }

    @Override
    public T findOne( Long id ){
        return (T) entityManager.find( daoType, id );
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> findAll(){
        return entityManager.createQuery( "from " + daoType.getName() )
                .getResultList();
    }

    @Override
    public T update( T entity ){
        return entityManager.merge( entity );
    }

}
