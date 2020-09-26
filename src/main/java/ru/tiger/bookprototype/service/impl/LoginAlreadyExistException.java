package ru.tiger.bookprototype.service.impl;

/**
 *
 * @author Igor
 */
public class LoginAlreadyExistException extends Exception {

    public LoginAlreadyExistException() {
        super();
    }

    public LoginAlreadyExistException(String arg0) {
        super(arg0);
    }

    public LoginAlreadyExistException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public LoginAlreadyExistException(Throwable arg0) {
        super(arg0);
    }
}
