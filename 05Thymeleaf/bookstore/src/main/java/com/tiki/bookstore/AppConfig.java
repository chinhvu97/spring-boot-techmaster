package com.tiki.bookstore;

import com.tiki.bookstore.repository.AuthorRepository;
import com.tiki.bookstore.repository.BookRepository;
import com.tiki.bookstore.service.AuthorService;
import com.tiki.bookstore.service.BMIService;
import com.tiki.bookstore.service.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public BookRepository getBookStore() {
        return new BookRepository();
    }

    @Bean
    public AuthorRepository getAuthorRepo() {
        return new AuthorRepository();
    }

    @Bean
    public BookService getBookService() {
        return new BookService(getBookStore());
    }

    @Bean
    public AuthorService getAuthorService() {return new AuthorService(getAuthorRepo());}

    @Bean
    public BMIService getBMIService() {
        return new BMIService();
    }

}
