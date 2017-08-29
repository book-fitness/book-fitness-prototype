package ru.tiger.bookprototype.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.tiger.bookprototype.entity.Role;

public class UserDetailsServiceImpl implements UserDetailsService {

    private UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        ru.tiger.bookprototype.entity.User person = userDAO.findByLogin(login);

        User user = new User(
                person.getLogin(),
                person.getPassword(),
                true, true, true, true,
                getAuthorities((Set<Role>) person.getRoleList()));

        return user;
    }

    private Collection<GrantedAuthority> getAuthorities(Set<Role> set) {
        Collection<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
        for (Role role : set) {
            //authList.add(new GrantedAuthorityImpl(role.getName()));
        }
        return authList;
    }

    @SuppressWarnings("deprecation")
    private Collection<GrantedAuthority> getAuthorities(String grant_name) {
        Collection<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
        //authList.add(new GrantedAuthorityImpl("ROLE_USER"));
        return authList;
    }
}
