package ru.tiger.bookprototype.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tiger.bookprototype.entity.Comment;

public interface CommentDAO extends JpaRepository<Comment, Long> {
    
}
