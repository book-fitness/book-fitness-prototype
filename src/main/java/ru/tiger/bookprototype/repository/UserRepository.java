package ru.tiger.bookprototype.repository;

import ru.tiger.bookprototype.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    
    //@Query("select u from User u where u.name = :username")
    //User findByUsername(@Param("username") String username);
}
