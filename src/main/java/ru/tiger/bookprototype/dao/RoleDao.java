package ru.tiger.bookprototype.dao;

import org.springframework.stereotype.Service;
import ru.tiger.bookprototype.entity.Role;

/**
 *
 * @author Igor
 */
@Service
public class RoleDao extends AbstractDao<Role> {

    public RoleDao() {
        super(Role.class);
    }
}
