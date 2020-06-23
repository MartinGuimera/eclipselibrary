package com.example.university.author;


import java.util.List;

import com.example.university.author.model.Author;
import com.example.university.author.model.AuthorDto;


public interface AuthorService {


  List<AuthorDto> findAll();


  Author get(Long id);


  Author save(AuthorDto data);

  void delete(Long id);

}
