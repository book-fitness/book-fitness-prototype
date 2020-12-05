package ru.tiger.bookprototype.webservice;

import ru.tiger.bookprototype.entity.Token;

/**
 *
 * @author Igor
 */
public class LogOutRequest {
    private Token token;

    public LogOutRequest(Token token) {
        this.token = token;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }
    
    
}
