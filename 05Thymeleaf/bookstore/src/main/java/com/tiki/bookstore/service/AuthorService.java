package com.tiki.bookstore.service;

import com.tiki.bookstore.model.Author;
import com.tiki.bookstore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AuthorService {
    private final AuthorRepository authorRepository;
    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAll() {
        return authorRepository.getAll();
    }
}
