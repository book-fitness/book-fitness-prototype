package ru.tiger.bookprototype.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tiger.bookprototype.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long>{
    
}
