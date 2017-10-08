package ru.tiger.bookprototype.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tiger.bookprototype.entity.Book;

public interface BookDAO extends JpaRepository<Book, Long>{
    
}
