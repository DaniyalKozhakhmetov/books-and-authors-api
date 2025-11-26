package com.task.books_and_authors_api.web.dto;

import com.task.books_and_authors_api.entity.BookEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;

public record BookRequestDto(
        @NotBlank(message = "Title is required")
        String title,
        @NotNull(message = "Price is required")
        @Positive(message = "Price must be positive")
        BigDecimal price,
        @NotNull(message = "Publish date is required")
        LocalDate publishDate,
        @NotNull(message = "Author ID is required")
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