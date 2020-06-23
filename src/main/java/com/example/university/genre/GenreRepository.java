package com.example.university.genre;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.example.university.genre.model.Genre;


public interface GenreRepository extends CrudRepository<Genre, Long> {


  Page<Genre> findAll(Pageable page);

}

