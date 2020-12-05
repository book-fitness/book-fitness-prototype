package ru.tiger.bookprototype.service;

import ru.tiger.bookprototype.entity.Token;

/**
 *
 * @author Igor
 */
public interface TokenService {
    
    public Token findByUserId(long userId);
    
    public void saveOrUpdate(Token token);
    
    public String generateToken();
    
    public Token findByTokenValue(String tokenValue);
    
    public void remove(Token token);
}
