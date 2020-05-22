package com.vztot.service;

import com.vztot.model.Book;
import com.vztot.model.Genre;

public interface BookService {
    Book add(Book book);

    Book getBookByTitle(String title);

    Book getBookByGenre(Genre genre);
}
