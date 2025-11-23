package com.task.books_and_authors_api.domain;

import com.task.books_and_authors_api.entity.AuthorsEntity;

import java.time.LocalDate;

public record Authors (
        Long id,
        String name,
        LocalDate birthDate
){public static Authors fromEntity(AuthorsEntity entity) {
    return new Authors(
            entity.getId(),
            entity.getName(),
            entity.getBirthDate());
    }
}


