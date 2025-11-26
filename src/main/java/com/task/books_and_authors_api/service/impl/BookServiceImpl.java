package com.task.books_and_authors_api.service.impl;

import com.task.books_and_authors_api.entity.AuthorsEntity;
import com.task.books_and_authors_api.entity.BookEntity;
import com.task.books_and_authors_api.repository.AuthorsRepository;
import com.task.books_and_authors_api.repository.BookRepository;
import com.task.books_and_authors_api.service.BookService;
import com.task.books_and_authors_api.web.controllers.BookRequestDto;
import com.task.books_and_authors_api.web.controllers.BookRespondDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService { // реализация бизнес логики книг

    private final BookRepository repository;
    private static final Logger log = LoggerFactory.getLogger(BookServiceImpl.class);
    private final AuthorsRepository authorsRepository;

    private BookServiceImpl(BookRepository repository,
                           AuthorsRepository authorsRepository){
        this.repository = repository;
        this.authorsRepository = authorsRepository;
    }

    @Override
    public BookRespondDto getBookById(Long id) {
        BookEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        log.info("Book id = {} has been called", id);
        return BookRespondDto.fromEntity(entity);
    }

    @Override
    public List<BookRespondDto> getAllBooks() {
        log.info("Book list has been called");
        List<BookEntity> entities = repository.findAll();
        return entities.stream()
                .map(BookRespondDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public BookRequestDto addNewBook(BookRequestDto book) {
        if(book.price() < 0) throw new IllegalArgumentException("Price must be positive");
        AuthorsEntity author = authorsRepository.findById(book.authorId())
                .orElseThrow(() -> new RuntimeException("Author not found"));

        log.info("New book has been created at author id = " + book.authorId());
        BookEntity entity = new BookEntity(
                book.title(),
                book.price(),
                book.publishDate(),
                author);
        BookEntity savedEntity = repository.save(entity);
        return BookRequestDto.fromEntity(savedEntity);
    }

    @Override
    public BookRequestDto editBookInfo(Long id, BookRequestDto book) {
        BookEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        if(book.price() < 0) throw new IllegalArgumentException("Price must be positive");
        log.info("Book id = {} has been updated", id);
        entity.setTitle(book.title());
        entity.setPrice(book.price());
        entity.setPublishDate(book.publishDate());
        entity.setAuthorId(book.authorId());
        BookEntity savedEntity = repository.save(entity);
        return BookRequestDto.fromEntity(savedEntity);
    }

    @Override
    public void deleteBookById(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        log.info("Book id = {} has been deleted", id);
        repository.deleteById(id);
    }
}
