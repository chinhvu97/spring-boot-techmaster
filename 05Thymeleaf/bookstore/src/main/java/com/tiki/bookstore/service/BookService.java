package com.tiki.bookstore.service;

import com.tiki.bookstore.model.Book;
import com.tiki.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookService {

    private final BookRepository bookStoreRepository;
    @Autowired
    public BookService(BookRepository bookStoreRepository) {
        this.bookStoreRepository = bookStoreRepository;
    }

    public List<Book> getAll() {
        return bookStoreRepository.getAll();
    }

}
