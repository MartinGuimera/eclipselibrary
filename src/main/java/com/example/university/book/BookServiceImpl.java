package com.example.university.book;

import java.util.ArrayList;
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
  public List<BookDto> findAll() {

    List<Book> bookList = (List<Book>) this.bookRepository.findAll();

    return EntityToDtoList(bookList);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public BookDto get(Long id) {

    Book book = this.bookRepository.findById(id).orElse(null);

    return EntityToDto(book);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public BookDto save(BookDto data) {

    BookDto dataDto = new BookDto();
    Book categoria = null;
    if (data.getId() != null) {
      dataDto = get(data.getId());
      categoria = DtoToEntity(dataDto);
    } else
      categoria = new Book();

    BeanUtils.copyProperties(data, categoria);

    BookDto bookDto = EntityToDto(this.bookRepository.save(categoria));

    return bookDto;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void delete(Long id) {

    this.bookRepository.deleteById(id);

  }

  private List<BookDto> EntityToDtoList(List<Book> books) {

    List<BookDto> bookDtos = new ArrayList();

    for (Book book : books) {
      BookDto bookDto = new BookDto();
      bookDto.setId(book.getId());
      bookDto.setName(book.getName());
      bookDto.setAuthor(book.getAuthor());
      bookDto.setGenre(book.getGenre());
      bookDto.setYear(book.getYear());

      bookDtos.add(bookDto);
    }

    return bookDtos;

  }

  private BookDto EntityToDto(Book book) {

    BookDto bookDto = new BookDto();

    bookDto.setId(book.getId());
    bookDto.setName(book.getName());
    bookDto.setAuthor(book.getAuthor());
    bookDto.setGenre(book.getGenre());
    bookDto.setYear(book.getYear());

    return bookDto;
  }

  private Book DtoToEntity(BookDto bookDto) {

    Book book = new Book();

    book.setId(bookDto.getId());
    book.setName(bookDto.getName());
    book.setAuthor(bookDto.getAuthor());
    book.setGenre(bookDto.getGenre());
    book.setYear(bookDto.getYear());

    return book;
  }

}
