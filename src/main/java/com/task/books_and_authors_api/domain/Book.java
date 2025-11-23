package com.task.books_and_authors_api.domain;

import com.task.books_and_authors_api.entity.AuthorsEntity;

import java.time.LocalDate;

public record Book (
    Long id,
    String title,
    Integer price,
    LocalDate publishDate,
    AuthorsEntity author
){/*public static Book fromEntity(BookEntity entity) { //outdated by Dto
    return new Book(
            entity.getId(),
            entity.getTitle(),
            entity.getPrice(),
            entity.getPublishDate(),
            entity.getAuthor());
    }*/
}
