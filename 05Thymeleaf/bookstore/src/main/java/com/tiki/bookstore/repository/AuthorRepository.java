package com.tiki.bookstore.repository;

import com.tiki.bookstore.model.Author;
import com.tiki.bookstore.model.Book;

import java.util.List;
import java.util.Optional;

public class AuthorRepository extends Repository<Author>{
    public AuthorRepository() {
        collections.add(new Author("Ernest Hemingway", 1899, "American", "male"));
        collections.add(new Author("Leo Tolstoy", 1828, "Russia", "male"));
        collections.add(new Author("J.K.Rowling", 1965, "England", "female"));
        collections.add(new Author("Victor Hugo", 1802, "France", "male"));
    }

    @Override
    public List<Author> getAll() {
        return collections;
    }



}
