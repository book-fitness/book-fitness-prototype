package ru.tiger.bookprototype.webservice;

import ru.tiger.bookprototype.entity.Token;

/**
 *
 * @author Igor
 */
public class LogOutResponse {
    private Token token;

    public LogOutResponse(Token token) {
        this.token = token;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }
    
    
}
