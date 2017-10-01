
package ru.tiger.bookprototype.servlet.listener;

import java.util.List;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.tiger.bookprototype.dao.RoleDAO;
import ru.tiger.bookprototype.entity.Role;
import ru.tiger.bookprototype.entity.RoleType;

/**
 *
 * @author Tiger
 */
@Component
public class RolesUpdater implements InitializingBean, DisposableBean {
    
    @Autowired
    private RoleDAO roleDao;
    
    @Override
    public void afterPropertiesSet() throws Exception {
        updateRolesInDB();
    }
    
    private void updateRolesInDB() {
        System.out.println("RolesUpdater...");
        
        RoleType[] roles = RoleType.values();
        List<Role> rolesInDB = roleDao.findAll();
        
        for (RoleType roleType : roles) {
            Role role = new Role();
            role.setName(roleType);
            if (!rolesInDB.contains(role)) {
                roleDao.save(role);
            }
        }
    }

    @Override
    public void destroy() throws Exception {
        
    }
}
