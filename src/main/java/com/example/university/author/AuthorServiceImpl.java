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
	  List<Author> authorList =  (List<Author>) this.authorRepository.findAll();
	  List<AuthorDto> authorDto = new ArrayList();
	  
    return this.EntityToDto(authorList);
    
  }


  /**
   * {@inheritDoc}
   */
  @Override
  public Author get(Long id) {

    return this.authorRepository.findById(id).orElse(null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Author save(AuthorDto data) {

    Author categoria = null;
    if (data.getId() != null)
      categoria = get(data.getId());
    else
      categoria = new Author();

    BeanUtils.copyProperties(data, categoria);

    return this.authorRepository.save(categoria);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void delete(Long id) {

    this.authorRepository.deleteById(id);

  }
  
  private List<AuthorDto> EntityToDto(List<Author> author){
	  List<AuthorDto> authorDto= new ArrayList();
	  
	  return authorDto;
  }
}