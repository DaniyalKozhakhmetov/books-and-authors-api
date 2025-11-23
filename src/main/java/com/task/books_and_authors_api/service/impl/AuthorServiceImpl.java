package com.task.books_and_authors_api.service.impl;

import com.task.books_and_authors_api.domain.Authors;
import com.task.books_and_authors_api.repository.AuthorsRepository;
import com.task.books_and_authors_api.entity.AuthorsEntity;
import com.task.books_and_authors_api.service.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService { // реализация бизнес логики авторов

    private final AuthorsRepository repository;
    private static final Logger log = LoggerFactory.getLogger(AuthorServiceImpl.class);
    @Autowired
    private AuthorServiceImpl(AuthorsRepository repository){
        this.repository = repository;
    }

    @Override
    public Authors getAuthorById(Long id) {
        log.info("Author id = {} has been called", id);
        AuthorsEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));
        return Authors.fromEntity(entity);
    }

    @Override
    public List<Authors> getAllAuthors() {
        log.info("All authors list has been called");
        List<AuthorsEntity> entities = repository.findAll();
        return entities.stream()
                .map(Authors::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Authors addNewAuthor(Authors author) {
        log.info("New author has been created");
        AuthorsEntity entity = new AuthorsEntity(
                author.name(),
                author.birthDate());
        AuthorsEntity savedEntity = repository.save(entity);
        return Authors.fromEntity(savedEntity);
    }

    @Override
    public Authors updateAuthor(Long id, Authors author) {
        AuthorsEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));
        log.info("Author id = {} has been updated", id);
        entity.setName(author.name());
        entity.setBirthDate(author.birthDate());
        AuthorsEntity savedEntity = repository.save(entity);
        return Authors.fromEntity(savedEntity);
    }

    @Override
    public void deleteAuthorById(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));
        log.info("Author id = {} has been deleted", id);
        repository.deleteById(id);
    }
}
