package com.task.books_and_authors_api.repository;

import com.task.books_and_authors_api.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
    @Override
    @Query("SELECT b FROM BookEntity b LEFT JOIN FETCH b.author") //N+1
    List<BookEntity> findAll();
}

