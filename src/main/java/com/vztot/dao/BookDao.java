package com.vztot.dao;

import com.vztot.model.Author;
import com.vztot.model.Book;
import com.vztot.model.Genre;
import java.util.List;

public interface BookDao {
    Book add(Book book);

    List<Book> getAll();

    Book getBookByTitle(String title);

    List<Book> getBooksByAuthor(Author author);

    List<Book> getBooksByGenre(Genre genre);
}
