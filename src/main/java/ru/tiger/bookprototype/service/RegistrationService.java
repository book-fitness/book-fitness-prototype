package ru.tiger.bookprototype.service;

import ru.tiger.bookprototype.service.impl.LoginAlreadyExistException;
import ru.tiger.bookprototype.service.impl.CriteriaPasswordException;

/**
 *
 * @author Igor
 */
public interface RegistrationService {
    void tryToRegister(String login, String password) throws LoginAlreadyExistException, CriteriaPasswordException;
}
