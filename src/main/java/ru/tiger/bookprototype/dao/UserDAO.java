package ru.tiger.bookprototype.dao;

import ru.tiger.bookprototype.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
