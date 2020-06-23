package com.example.university.author;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.university.author.model.Author;
import com.example.university.author.model.AuthorDto;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

  @Autowired
  AuthorRepository authorRepository;

  /**
   * {@inheritDoc}
   */
  @Override
  public List<AuthorDto> findAll() {

    List<Author> authorList = (List<Author>) this.authorRepository.findAll();

    return EntityToDtoList(authorList);

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public AuthorDto get(Long id) {

    Author author = this.authorRepository.findById(id).orElse(null);

    AuthorDto authorDto = EntityToDto(author);

    return authorDto;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public AuthorDto save(AuthorDto data) {

    AuthorDto dataDto = new AuthorDto();
    Author categoria = null;
    if (data.getId() != null) {
      dataDto = get(data.getId());
      categoria = DtoToEntity(dataDto);
    } else
      categoria = new Author();

    BeanUtils.copyProperties(data, categoria);

    AuthorDto authorDto = EntityToDto(this.authorRepository.save(categoria));

    return authorDto;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void delete(Long id) {

    this.authorRepository.deleteById(id);

  }

  private List<AuthorDto> EntityToDtoList(List<Author> authors) {

    List<AuthorDto> authorDtos = new ArrayList();

    for (Author author : authors) {

      AuthorDto authorDto = new AuthorDto();
      authorDto.setId(author.getId());
      authorDto.setName(author.getName());

      authorDtos.add(authorDto);

    }

    return authorDtos;
  }

  private AuthorDto EntityToDto(Author author) {

    AuthorDto authorDto = new AuthorDto();

    authorDto.setId(author.getId());
    authorDto.setName(author.getName());
    return authorDto;
  }

  private Author DtoToEntity(AuthorDto authorDto) {

    Author author = new Author();

    author.setId(authorDto.getId());
    author.setName(authorDto.getName());
    return author;
  }
}