package com.task.books_and_authors_api.service;

import com.task.books_and_authors_api.web.dto.BookRequestDto;
import com.task.books_and_authors_api.web.dto.BookRespondDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService { //сервис книг

    BookRespondDto getBookById(Long id); // книга по id

    List<BookRespondDto> getAllBooks(); //список всех книг с авторами

    BookRespondDto addNewBook(BookRequestDto book); // новая книга

    BookRespondDto editBookInfo(Long id, BookRequestDto book); // изменение книги

    void deleteBookById(Long id); // удаление книги
}
