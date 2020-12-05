package ru.tiger.bookprototype.webservice;

import ru.tiger.bookprototype.entity.Token;

/**
 *
 * @author Igor
 */
public class LoginResponse {

    private String token;
    private String error;

    public LoginResponse() {}
    
    public LoginResponse(Token token, String error) {
        this.token = token == null ? null : token.getToken();
        this.error = error;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
