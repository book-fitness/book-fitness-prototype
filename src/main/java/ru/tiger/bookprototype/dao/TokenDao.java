package ru.tiger.bookprototype.dao;

import java.util.List;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Service;
import ru.tiger.bookprototype.entity.Token;

/**
 *
 * @author Igor
 */
@Service
public class TokenDao extends AbstractDao<Token> {

    public TokenDao() {
        super(Token.class);
    }

    public Token findByTokenValue(String tokenValue) {
        String jpql = "SELECT t FROM Token t WHERE t.tokenValue = :tokenValue";
        TypedQuery<Token> typedQuery = entityManager.createQuery(jpql, Token.class);
        typedQuery.setParameter("tokenValue", tokenValue);
        List<Token> result = typedQuery.getResultList();
        return result == null || result.isEmpty() ? null : result.get(0);
    }

    public Token findByUserId(Long id) {
        String jpql = "SELECT t FROM Token t WHERE t.userId = :id";
        TypedQuery<Token> typedQuery = entityManager.createQuery(jpql, Token.class);
        typedQuery.setParameter("id", id);
        List<Token> result = typedQuery.getResultList();
        return result == null || result.isEmpty() ? null : result.get(0);
    }
}
