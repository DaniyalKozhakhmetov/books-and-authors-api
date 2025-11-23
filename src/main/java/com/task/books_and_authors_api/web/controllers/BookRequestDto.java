package com.task.books_and_authors_api.web.controllers;

import com.task.books_and_authors_api.entity.BookEntity;

import java.time.LocalDate;

public record BookRequestDto(
        String title,
        Integer price,
        LocalDate publishDate,
        Long authorId
) {
    public static BookRequestDto fromEntity(BookEntity entity) {
        return new BookRequestDto(
                entity.getTitle(),
                entity.getPrice(),
                entity.getPublishDate(),
                entity.getAuthor().getId());
    }
}