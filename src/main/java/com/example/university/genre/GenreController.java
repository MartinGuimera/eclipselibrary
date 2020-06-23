package com.example.university.genre;

import java.util.List;

import org.apache.commons.beanutils.BeanMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.university.genre.model.GenreDto;

@RequestMapping(value = "/genre/v1")
@RestController
public class GenreController {

  @Autowired
  GenreService genreService;

  @Autowired
  BeanMap beanMapper;

  @RequestMapping(path = "/", method = RequestMethod.GET)
  public List<GenreDto> findAll() {

    return this.beanMapper.mapList(this.genreService.findAll(), GenreDto.class);
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.GET)
  public GenreDto get(@PathVariable("id") Long id) {

    return this.beanMapper.map(this.genreService.get(id), GenreDto.class);
  }


  @RequestMapping(path = "/", method = RequestMethod.PUT)
  public GenreDto save(@RequestBody GenreDto data) {

    return this.beanMapper.map(this.genreService.save(data), GenreDto.class);
  }


  @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
  public void delete(@PathVariable("id") Long id) {

    this.genreService.delete(id);

  }
}