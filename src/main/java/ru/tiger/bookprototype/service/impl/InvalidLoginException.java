package ru.tiger.bookprototype.service.impl;

public class InvalidLoginException extends Exception  {

    public InvalidLoginException() {
    }

    public InvalidLoginException(String string) {
        super(string);
    }

    public InvalidLoginException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public InvalidLoginException(Throwable thrwbl) {
        super(thrwbl);
    }
}
