package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Books;

public interface BookRepository extends CrudRepository<Books, Long> {

}
    

