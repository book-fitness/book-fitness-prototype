package ru.tiger.bookprototype.servlet.listener;

import java.util.List;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.tiger.bookprototype.entity.Role;
import ru.tiger.bookprototype.entity.enums.RoleType;
import ru.tiger.bookprototype.repository.RoleRepository;

/**
 *
 * @author Tiger
 */
@Component
public class RolesUpdater implements InitializingBean, DisposableBean {
    
    @Autowired
    private RoleRepository roleRepo;
    
    @Override
    public void afterPropertiesSet() throws Exception {
        updateRolesInDB();
    }
    
    private void updateRolesInDB() {
        System.out.println("RolesUpdater...");
        
        RoleType[] roles = RoleType.values();
        List<Role> rolesInDB = roleRepo.findAll();
        
        for (RoleType roleType : roles) {
            Role role = new Role();
            role.setName(roleType);
            if (!rolesInDB.contains(role)) {
                roleRepo.save(role);
            }
        }
    }

    @Override
    public void destroy() throws Exception {
        
    }
}
