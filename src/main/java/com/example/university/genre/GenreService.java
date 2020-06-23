package com.example.university.genre;

import java.util.List;

import com.example.university.genre.model.GenreDto;

public interface GenreService {

  List<GenreDto> findAll();

  GenreDto get(Long id);

  GenreDto save(GenreDto data);

  void delete(Long id);

}