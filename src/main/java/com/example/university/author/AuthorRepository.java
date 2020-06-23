package com.example.university.author;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.example.university.
author.model.Author;


public interface AuthorRepository extends CrudRepository<Author, Long> {


  Page<Author> findAll(Pageable page);

}
