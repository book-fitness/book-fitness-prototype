package ru.tiger.bookprototype.service.impl;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import ru.tiger.bookprototype.dao.UserDao;
import ru.tiger.bookprototype.entity.User;
import ru.tiger.bookprototype.service.RegistrationService;
import ru.tiger.bookprototype.validation.LoginValidator;
import ru.tiger.bookprototype.validation.PasswordValidator;

/**
 *
 * @author Igor
 */
@ApplicationScoped
public class RegistrationServiceImpl implements RegistrationService {

    @EJB
    private UserDao userDao;

    @Override
    public void tryToRegister(String login, String password, String repeatPassword)
            throws LoginAlreadyExistException, InvalidLoginException, InvalidPasswordException {
        
        if (userDao.findByLogin(login) != null) {
            throw new LoginAlreadyExistException("Login already exist: " + login);
        }
        
        LoginValidator loginValidator = new LoginValidator();
        if (!loginValidator.isValid(login)) {
            throw new InvalidLoginException("Login: " + login);
        }
        
        PasswordValidator passwordValidator = new PasswordValidator();
        if (!passwordValidator.isValid(password) || !password.equals(repeatPassword)) {
            throw new InvalidPasswordException("Password: " + password + ", " + repeatPassword);
        }
        
        User user = new User();
        user.setUsername(login);
        user.setPassword(password);
        userDao.saveOrUpdate(user);
    }
}
