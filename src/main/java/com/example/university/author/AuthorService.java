package com.example.university.author;

import java.util.List;

import com.example.university.author.model.AuthorDto;

public interface AuthorService {

  List<AuthorDto> findAll();

  AuthorDto get(Long id);

  AuthorDto save(AuthorDto data);

  void delete(Long id);

}

