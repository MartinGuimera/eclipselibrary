package com.example.university.book;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.university.book.model.Book;
import com.example.university.book.model.BookDto;

@Service
@Transactional
public class BookServiceImpl implements BookService {

  @Autowired
  BookRepository bookRepository;

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Book> findAll() {

    return (List<Book>) this.bookRepository.findAll();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Book get(Long id) {

    return this.bookRepository.findById(id).orElse(null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Book save(BookDto data) {

	  Book categoria = null;
    if (data.getId() != null)
      categoria = get(data.getId());
    else
      categoria = new Book();

    BeanUtils.copyProperties(data, categoria);

    return this.bookRepository.save(categoria);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void delete(Long id) {

    this.bookRepository.deleteById(id);

  }

}
