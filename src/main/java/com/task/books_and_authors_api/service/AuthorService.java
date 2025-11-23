package com.task.books_and_authors_api.service;

import com.task.books_and_authors_api.domain.Authors;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService { // сервис авторов

    Authors getAuthorById(Long id); //получение автора по id

    List<Authors> getAllAuthors(); // получение списка авторов

    Authors addNewAuthor(Authors author); // новый автор

    Authors updateAuthor(Long id, Authors author); // изменение автора

    void deleteAuthorById(Long id); // удаление автора
}
