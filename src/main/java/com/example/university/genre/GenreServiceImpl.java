package com.example.university.genre;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.university.genre.model.Genre;
import com.example.university.genre.model.GenreDto;

@Service
@Transactional
public class GenreServiceImpl implements GenreService {

  @Autowired
  GenreRepository genreRepository;

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Genre> findAll() {

    return (List<Genre>) this.genreRepository.findAll();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Genre get(Long id) {

    return this.genreRepository.findById(id).orElse(null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Genre save(GenreDto data) {

	  Genre categoria = null;
    if (data.getId() != null)
      categoria = get(data.getId());
    else
      categoria = new Genre();

    BeanUtils.copyProperties(data, categoria);

    return this.genreRepository.save(categoria);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void delete(Long id) {

    this.genreRepository.deleteById(id);

  }

}
