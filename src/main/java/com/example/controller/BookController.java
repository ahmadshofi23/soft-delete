package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Books;
import com.example.services.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {
    

    @Autowired
    private BookService bookService;

    @PostMapping("/create")
    public Books createOne(@RequestBody Books book) {
        return bookService.createBook(book);
    }

    @DeleteMapping("/delete/{id}")
    public void removeOne(@PathVariable("id") Long id) {
        bookService.remove(id);
    }

    @GetMapping("/all")
    public Iterable<Books> findAll(@RequestParam(value = "isDeleted",required = false, defaultValue = "false")boolean isDeleted) {
        return bookService.findAll(isDeleted);
    }
}
