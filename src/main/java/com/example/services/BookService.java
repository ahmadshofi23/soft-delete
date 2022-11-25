package com.example.services;


import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Books;
import com.example.repository.BookRepository;

import jakarta.persistence.EntityManager;

@Service
@Transactional
public class BookService {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private BookRepository bookRepository;

    public Books createBook(Books book) {
        return bookRepository.save(book);
    }

    public void remove(Long id) {
        bookRepository.deleteById(id);
    }

    public Iterable<Books> findAll(boolean isDeleted) {
        Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("deletedBookFilter");
        filter.setParameter("isDeleted", isDeleted);
        Iterable<Books> books = bookRepository.findAll();
        session.disableFilter("deletedBookFilter");
        return books;
        // return bookRepository.findAll();
    }
}
