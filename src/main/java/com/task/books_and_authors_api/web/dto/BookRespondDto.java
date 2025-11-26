package com.task.books_and_authors_api.web.dto;

import com.task.books_and_authors_api.entity.BookEntity;

import java.math.BigDecimal;
import java.time.LocalDate;

public record BookRespondDto(
        Long Id,
        String title,
        BigDecimal price,
        LocalDate publishDate,
        String authorName,
        LocalDate authorBirthDate
) {   public static BookRespondDto fromEntity(BookEntity entity) {
    return new BookRespondDto(
            entity.getId(),
            entity.getTitle(),
            entity.getPrice(),
            entity.getPublishDate(),
            entity.getAuthor().getName(),
            entity.getAuthor().getBirthDate());
    }
}
