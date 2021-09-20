package com.tiki.bookstore.controller;

import com.tiki.bookstore.service.AuthorService;
import com.tiki.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class HomeController {

    private final BookService bookService;
    private final AuthorService authorService;

    @Autowired
    public HomeController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping("/home")
    public String getBooks(Model model) {
        model.addAttribute("books", bookService.getAll());
        return "home";
    }

    @GetMapping("/author")
    public String getAuthors(Model model) {
        model.addAttribute("authors", authorService.getAll());
        return "author";
    }

}
