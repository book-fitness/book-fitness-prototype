package ru.tiger.bookprototype.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import ru.tiger.bookprototype.entity.AbstractEntity;

/**
 *
 * @author Igor
 */
public abstract class AbstractDao<T extends AbstractEntity> { //мы же персистент контекст только в компонентах без состояния можем инжектить. 

    @PersistenceContext
    protected EntityManager entityManager;
    
    protected Class<T> type;

    public AbstractDao(Class<T> type) {
        this.type = type;
    }

    public void saveOrUpdate(T entity) {
        if (entity.getId() == null || entity.getId() < 1) {
            entityManager.persist(entity);
        } else {
            entityManager.merge(entity);
        }
    }

    public void remove(T entity) {
        entityManager.remove(entity);
    }

    public T findById(Long id) {
        return entityManager.find(type, id);
    }

    public List<T> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = cb.createQuery(type);
        Root<T> rootEntry = criteriaQuery.from(type);
        CriteriaQuery<T> all = criteriaQuery.select(rootEntry);
        TypedQuery<T> query = entityManager.createQuery(all);
        return query.getResultList();
    }
}
