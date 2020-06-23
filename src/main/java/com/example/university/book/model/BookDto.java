package com.example.university.book.model;

import com.example.university.author.model.Author;
import com.example.university.genre.model.Genre;

public class BookDto {

		  private Long id;

		  private String name;
		  
		  private Author author;
		  
		  private Genre genre;
		  
		  private Long year;

		  /**
		   * @return id
		   */
		  public Long getId() {

		    return this.id;
		  }

		  /**
		   * @param id new value of {@link #getId}.
		   */
		  public void setId(Long id) {

		    this.id = id;
		  }

		  /**
		   * @return name
		   */
		  public String getName() {

		    return this.name;
		  }

		  /**
		   * @param name new value of {@link #getName}.
		   */
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