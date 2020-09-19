package ru.tiger.bookprototype.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Igor
 */
public abstract class AbstractLikeDao<T> {
    
    @PersistenceContext
    protected EntityManager em;
    
    public void create(T entityLike) {
        em.persist(entityLike);
    }
    
    public void update(T entityLike) {
        em.merge(entityLike);
    }
    
    public void remove(T entityLike) {
        em.remove(entityLike);
    }   
}
