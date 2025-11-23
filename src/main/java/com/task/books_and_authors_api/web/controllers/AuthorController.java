package com.task.books_and_authors_api.web.controllers;

import com.task.books_and_authors_api.domain.Authors;
import com.task.books_and_authors_api.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService service;

    public AuthorController(AuthorService service){
        this.service = service;
    }

    @GetMapping("/{id}")
    public Authors getAuthorsById(@PathVariable Long id){
        return service.getAuthorById(id);
    }

    @GetMapping
    public List<Authors> getAuthors(){
        return service.getAllAuthors();
    }

    @PostMapping
    public Authors addNewAuthor(@RequestBody Authors author){
        return service.addNewAuthor(author);
    }

    @PutMapping("/{id}")
    public Authors updateAuthor(@PathVariable Long id, @RequestBody Authors author){
        return service.updateAuthor(id, author);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id){
        service.deleteAuthorById(id);
    }
}
