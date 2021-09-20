package com.tiki.bookstore.model;

import java.util.concurrent.atomic.AtomicInteger;

public class Book {
    int id;
    String title;
    String description;
    Genre genre;

    public Book(int id, String title, String description, Genre genre) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
