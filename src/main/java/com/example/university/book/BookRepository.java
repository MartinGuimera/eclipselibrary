package com.example.university.book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.example.university.book.model.Book;


public interface BookRepository extends CrudRepository<Book, Long> {


  Page<Book> findAll(Pageable page);

}