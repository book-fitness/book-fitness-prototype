package ru.tiger.bookprototype.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tiger.bookprototype.entity.UserLike;


public interface UserLikeDAO extends JpaRepository<UserLike, Long> {
    
}
