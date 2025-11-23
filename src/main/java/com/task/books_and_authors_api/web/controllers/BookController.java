package com.task.books_and_authors_api.web.controllers;

import com.task.books_and_authors_api.service.BookService;
import org.springframework.web.bind.annotation.*;

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
    public BookRequestDto addNewBook(@RequestBody BookRequestDto book){
        return service.addNewBook(book);
    }

    @PutMapping("/{id}")
    public BookRequestDto updateBook(@PathVariable Long id, @RequestBody BookRequestDto book){
        return service.editBookInfo(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        service.deleteBookById(id);
    }
}

