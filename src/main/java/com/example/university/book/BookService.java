package com.example.university.book;

import java.util.List;

import com.example.university.book.model.Book;
import com.example.university.book.model.BookDto;


public interface BookService {


  List<Book> findAll();

  Book get(Long id);


  Book save(BookDto data);

  void delete(Long id);

}