package com.example.university.genre;


import java.util.List;

import com.example.university.genre.model.Genre;
import com.example.university.genre.model.GenreDto;


public interface GenreService {


  List<Genre> findAll();

  Genre get(Long id);


  Genre save(GenreDto data);

  void delete(Long id);

}