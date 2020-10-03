package ru.tiger.bookprototype.dao;

import javax.ejb.Stateless;
import ru.tiger.bookprototype.entity.Role;

/**
 *
 * @author Igor
 */
@Stateless
public class RoleDao extends AbstractDao<Role> {

    public RoleDao() {
        super(Role.class);
    }
}
