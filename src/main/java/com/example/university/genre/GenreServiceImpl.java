package com.example.university.genre;

import java.util.ArrayList;
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
  public List<GenreDto> findAll() {

    List<Genre> genreList = (List<Genre>) this.genreRepository.findAll();

    return EntityToDtoList(genreList);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public GenreDto get(Long id) {

    Genre genre = this.genreRepository.findById(id).orElse(null);

    GenreDto genreDto = EntityToDto(genre);

    return genreDto;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public GenreDto save(GenreDto data) {

    GenreDto dataDto = new GenreDto();
    Genre categoria = null;
    if (data.getId() != null) {
      dataDto = get(data.getId());
      categoria = DtoToEntity(dataDto);
    } else
      categoria = new Genre();

    BeanUtils.copyProperties(data, categoria);

    GenreDto genreDto = EntityToDto(this.genreRepository.save(categoria));

    return genreDto;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void delete(Long id) {

    this.genreRepository.deleteById(id);

  }

  private List<GenreDto> EntityToDtoList(List<Genre> genres) {

    List<GenreDto> genreDtos = new ArrayList();

    for (Genre genre : genres) {

      GenreDto genreDto = new GenreDto();
      genreDto.setId(genre.getId());
      genreDto.setName(genre.getName());

      genreDtos.add(genreDto);
    }

    return genreDtos;
  }

  private GenreDto EntityToDto(Genre genre) {

    GenreDto genreDto = new GenreDto();

    genreDto.setId(genre.getId());
    genreDto.setName(genre.getName());

    return genreDto;
  }

  private Genre DtoToEntity(GenreDto genreDto) {

    Genre genre = new Genre();

    genre.setId(genreDto.getId());
    genre.setName(genreDto.getName());

    return genre;
  }

}
