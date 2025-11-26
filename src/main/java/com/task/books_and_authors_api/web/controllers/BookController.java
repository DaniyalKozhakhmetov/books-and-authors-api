package com.task.books_and_authors_api.web.controllers;

import com.task.books_and_authors_api.service.BookService;
import com.task.books_and_authors_api.web.dto.BookRequestDto;
import com.task.books_and_authors_api.web.dto.BookRespondDto;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService service;

    public BookController(BookService service){
        this.service = service;
    }

    @GetMapping("/{id}")
    public BookRespondDto getBooksById(@PathVariable Long id){
        return service.getBookById(id);
    }

    @GetMapping
    public List<BookRespondDto> getAllBooks(){
        return service.getAllBooks();
    }

    @PostMapping
    public BookRespondDto addNewBook( @Valid @RequestBody BookRequestDto book){
        return service.addNewBook(book);
    }

    @PutMapping("/{id}")
    public BookRespondDto updateBook(@PathVariable Long id,  @Valid @RequestBody BookRequestDto book){
        return service.editBookInfo(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        service.deleteBookById(id);
    }
}

