package com.tiki.bookstore;

import com.tiki.bookstore.repository.BookStoreRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public BookStoreRepository getBookStore() {
        return new BookStoreRepository();
    }
}
