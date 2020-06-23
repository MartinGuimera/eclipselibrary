package com.example.university.author;


import java.util.List;

import org.apache.commons.beanutils.BeanMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.university.author.model.AuthorDto;

@RequestMapping(value = "/author/v1")
@RestController
public class AuthorController {

  @Autowired
  AuthorService authorService;

  @Autowired
  BeanMap beanMapper;

  @RequestMapping(path = "/", method = RequestMethod.GET)
  public List<AuthorDto> findAll() {

    return this.authorService.findAll();
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.GET)
  public AuthorDto get(@PathVariable("id") Long id) {

    return this.beanMapper.map(this.authorService.get(id), AuthorDto.class);
  }


  @RequestMapping(path = "/", method = RequestMethod.PUT)
  public AuthorDto save(@RequestBody AuthorDto data) {

    return this.beanMapper.map(this.authorService.save(data), AuthorDto.class);
  }


  @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
  public void delete(@PathVariable("id") Long id) {

    this.authorService.delete(id);

  }
}