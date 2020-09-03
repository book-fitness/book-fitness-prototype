package ru.tiger.bookprototype.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;
import ru.tiger.bookprototype.entity.AbstractLikeEntity;

/**
 *
 * @author Igor
 */
public abstract class AbstractLikeDaoOld<T extends AbstractLikeEntity> {

    @PersistenceContext
    EntityManager em;
    
    protected Class<T> classType;

    private void setLikeOrDislike(@NotNull Long userId, Long entityId, T likeEntity, boolean value) {
        likeEntity.setUserId(userId);
        likeEntity.setEntityId(entityId);
        if (likeEntity.getEntityId() == null || likeEntity.getEntityId() < 1) {
            likeEntity.setValue(value);
            em.persist(likeEntity);
        } else {
            likeEntity.setValue(value);
            em.merge(likeEntity);
        }
    }

    public void unsetLike(Long userId, Long entityId, T likeEntity) {
        Query query = em.createQuery("DELETE FROM CommentLike c WHERE c.userId = :userId AND c.commentId = :commentId"); //override toString() with return "CommentLike"
        query.setParameter("userId", userId);
        query.setParameter("commentId", entityId);
        query.executeUpdate();
        
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = cb.createQuery(classType);
        Root<T> rootEntry = criteriaQuery.from(classType); // FROM CommentLike c 
        //SELECT c FROM CommentLike c WHERE c.userId
        //criteriaQuery.select(rootEntry).where(rootEntry.get(CommentLike.getUserId), cb.parameter(Long.class, "userId"));
        Predicate predicate = cb.and(cb.equal(rootEntry.get("userId"), userId), cb.equal(rootEntry.get("commentId"), entityId));
        criteriaQuery.select(rootEntry).where(predicate);
        T like = em.createQuery(criteriaQuery).getSingleResult();
        em.remove(like);
        //Query query = em.createQuery() 
    }
}


  //query execution
 /* CriteriaBuilder cb = entityManager.getCriteriaBuilder();
  CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
  Root<Employee> employee = query.from(Employee.class);
  query.select(employee)
       .where(cb.equal(employee.get(Employee_.name), cb.parameter(String.class, "empName")));
  //query execution
  TypedQuery<Employee> typedQuery = entityManager.createQuery(query);
  typedQuery.setParameter("empName", "Diana");
  List<Employee> resultList = typedQuery.getResultList(); */