package com.vztot.service;

import com.vztot.model.Author;
import com.vztot.model.Book;
import com.vztot.model.Genre;
import java.util.List;

public interface BookService {
    Book add(Book book);

    Book getBookByTitle(String title);

    List<Book> getBooksByAuthor(Author author);

    List<Book> getBooksByGenre(Genre genre);
}
