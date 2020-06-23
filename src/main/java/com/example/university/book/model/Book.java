package com.example.university.book.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.university.author.model.Author;
import com.example.university.genre.model.Genre;

@Entity
@Table(name = "Book")
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "name")
  private String name;
  
  @OneToMany
  @JoinColumn(name = "authorid", referencedColumnName = "id")
  private Author author;
  
  @OneToMany
  @JoinColumn(name = "genreid", referencedColumnName = "id")
  private Genre genre;
  
  @Column(name = "year")
  private Long year;

  public Long getId() {

    return this.id;
  }

  public void setId(Long id) {

    this.id = id;
  }


  public String getName() {

    return this.name;
  }

  public void setName(String name) {

    this.name = name;
  }

public Author getAuthor() {
	return author;
}

public void setAuthor(Author author) {
	this.author = author;
}

public Genre getGenre() {
	return genre;
}

public void setGenre(Genre genre) {
	this.genre = genre;
}

public Long getYear() {
	return year;
}

public void setYear(Long year) {
	this.year = year;
}


}