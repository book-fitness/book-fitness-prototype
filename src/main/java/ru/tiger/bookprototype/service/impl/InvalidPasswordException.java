package ru.tiger.bookprototype.service.impl;

/**
 *
 * @author Igor
 */
public class InvalidPasswordException extends Exception {

    public InvalidPasswordException() {
    }

    public InvalidPasswordException(String arg0) {
        super(arg0);
    }

    public InvalidPasswordException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public InvalidPasswordException(Throwable arg0) {
        super(arg0);
    }
}
