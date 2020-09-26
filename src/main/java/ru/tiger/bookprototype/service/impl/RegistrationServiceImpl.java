package ru.tiger.bookprototype.service.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import ru.tiger.bookprototype.dao.UserDao;
import ru.tiger.bookprototype.entity.User;
import ru.tiger.bookprototype.service.RegistrationService;

/**
 *
 * @author Igor
 */
@Stateless
public class RegistrationServiceImpl implements RegistrationService {

    @EJB
    private UserDao userDao;
    private Pattern pattern = Pattern.compile("[a-z][0-9]{8,16}");
    private Matcher matcher;

    @Override
    public void tryToRegister(String login, String password) throws LoginAlreadyExistException, CriteriaPasswordException {
        matcher = pattern.matcher(password);
        if (userDao.findByLogin(login) != null) {
            throw new LoginAlreadyExistException("Login: " + login);
        }

        if (matcher.matches()) {
            User user = new User();
            user.setUsername(login);
            user.setPassword(password);
            userDao.saveOrUpdate(user);
        } else {
              throw new CriteriaPasswordException("Password" + password);
        }
    }
}
