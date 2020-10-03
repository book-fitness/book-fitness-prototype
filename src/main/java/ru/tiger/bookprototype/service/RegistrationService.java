package ru.tiger.bookprototype.service;

import ru.tiger.bookprototype.service.impl.InvalidLoginException;
import ru.tiger.bookprototype.service.impl.LoginAlreadyExistException;
import ru.tiger.bookprototype.service.impl.InvalidPasswordException;

/**
 *
 * @author Igor
 */
public interface RegistrationService {
    void tryToRegister(String login, String password, String repeatPassword)
            throws LoginAlreadyExistException, InvalidLoginException, InvalidPasswordException;
}
