package ru.tiger.bookprototype.service.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import ru.tiger.bookprototype.dao.TokenDao;
import ru.tiger.bookprototype.entity.Token;
import ru.tiger.bookprototype.service.TokenService;

/**
 *
 * @author Igor
 */
@Stateless
public class TokeServiceImpl implements TokenService {

    @EJB
    private TokenDao tokenDao;

    @EJB
    private TokenGenerator tokenGenerator;

    @Override
    public Token findByUserId(long userId) {
        return tokenDao.findByUserId(userId);
    }

    @Override
    public void saveOrUpdate(Token token) {
        tokenDao.saveOrUpdate(token);
    }

    @Override
    public String generateToken() {
        return tokenGenerator.generateToken40();
    }

    @Override
    public Token findByTokenValue(String tokenValue) {
        return tokenDao.findByTokenValue(tokenValue);
    }

    @Override
    public void remove(Token token) {
        tokenDao.remove(token);
    }
}
