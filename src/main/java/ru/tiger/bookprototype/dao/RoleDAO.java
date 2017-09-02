package ru.tiger.bookprototype.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tiger.bookprototype.entity.Role;

public interface RoleDAO extends JpaRepository<Role, Long> {
    
}
