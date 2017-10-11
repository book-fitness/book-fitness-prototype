package ru.tiger.bookprototype.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tiger.bookprototype.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
    
}
