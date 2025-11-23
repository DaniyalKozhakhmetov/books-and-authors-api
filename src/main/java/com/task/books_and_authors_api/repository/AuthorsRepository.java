package com.task.books_and_authors_api.repository;

import com.task.books_and_authors_api.entity.AuthorsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorsRepository extends JpaRepository<AuthorsEntity, Long> {
}
