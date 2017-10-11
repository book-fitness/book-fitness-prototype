package ru.tiger.bookprototype.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tiger.bookprototype.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
}
