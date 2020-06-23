package com.example.university.book;


import java.util.List;

import org.apache.commons.beanutils.BeanMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.university.book.model.BookDto;

@RequestMapping(value = "/author/v1")
@RestController
public class BookController {

  @Autowired
  BookService authorService;

  @Autowired
  BeanMap beanMapper;

  @RequestMapping(path = "/", method = RequestMethod.GET)
  public List<BookDto> findAll() {

    return this.beanMapper.mapList(this.authorService.findAll(), BookDto.class);
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.GET)
  public BookDto get(@PathVariable("id") Long id) {

    return this.beanMapper.map(this.authorService.get(id), BookDto.class);
  }


  @RequestMapping(path = "/", method = RequestMethod.PUT)
  public BookDto save(@RequestBody BookDto data) {

    return this.beanMapper.map(this.authorService.save(data), BookDto.class);
  }


  @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
  public void delete(@PathVariable("id") Long id) {

    this.authorService.delete(id);

  }
}