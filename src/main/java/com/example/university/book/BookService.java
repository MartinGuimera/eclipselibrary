package com.example.university.book;

import java.util.List;

import com.example.university.book.model.BookDto;

public interface BookService {

  List<BookDto> findAll();

  BookDto get(Long id);

  BookDto save(BookDto data);

  void delete(Long id);

}