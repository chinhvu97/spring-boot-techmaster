package com.tiki.bookstore.controller;


import com.tiki.bookstore.model.Book;
import com.tiki.bookstore.repository.BookStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book/")
public class RestBook {

    @Autowired
    private BookStoreRepository bookStoreRepository;

    @GetMapping("id")
    public ResponseEntity<Book> getBook(@RequestParam(value = "id", required = false) int id) {
        Optional<Book> optional = bookStoreRepository.get(id);
        final Book[] myBook = {null};
        optional.ifPresent(book -> myBook[0] = book);
        return ResponseEntity.ok().body(myBook[0]);
    }

    @PostMapping("add")
    public ResponseEntity<List<Book>> add(@RequestParam(value = "id") int id,
                                          @RequestParam(value = "title") String title,
                                          @RequestParam(value = "description") String description) {
        Book book = new Book(id, title, description);
        bookStoreRepository.add(book);
        List<Book> bookList = bookStoreRepository.getAll();
        return ResponseEntity.ok().body(bookList);
    }


    @PutMapping("update")
    public ResponseEntity<List<Book>> update(@RequestParam(value = "id") int id,
                                             @RequestParam(value = "title", required = false) String title,
                                             @RequestParam(value = "description", required = false) String description) {
        Optional<Book> optional = bookStoreRepository.get(id);
        optional.ifPresent(book -> {
            Book newBook = new Book(id, title, description);
            bookStoreRepository.update(newBook);
        });
        List<Book> bookList = bookStoreRepository.getAll();
        return ResponseEntity.ok().body(bookList);
    }

    @DeleteMapping("delete")
    public ResponseEntity<List<Book>> delete(@RequestParam(value = "id") int id) {
        Optional<Book> optional = bookStoreRepository.get(id);
        optional.ifPresent(book -> {
            bookStoreRepository.delete(book);
        });
        List<Book> bookList = bookStoreRepository.getAll();
        return ResponseEntity.ok().body(bookList);
    }

}
