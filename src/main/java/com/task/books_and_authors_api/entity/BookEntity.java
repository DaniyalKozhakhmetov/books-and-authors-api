package com.task.books_and_authors_api.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "book_entity")
@Entity
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private BigDecimal price;

    @Column
    private LocalDate publishDate;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private AuthorsEntity author;

    public BookEntity(){
    }

    public BookEntity(String title, BigDecimal price, LocalDate publishDate, AuthorsEntity author) {
        this.title = title;
        this.price = price;
        this.publishDate = publishDate;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public AuthorsEntity getAuthor() {
        return author;
    }

    public void setAuthorId(Long authorId) {
        this.author = author;
    }
}
