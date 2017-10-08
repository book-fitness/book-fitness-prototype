package ru.tiger.bookprototype.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tiger.bookprototype.entity.Post;

public interface PostDAO extends JpaRepository<Post, Long>{
    
}
