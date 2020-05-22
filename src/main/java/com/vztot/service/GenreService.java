package com.vztot.service;

import com.vztot.model.Book;
import com.vztot.model.Genre;
import java.util.List;

public interface GenreService {
    Genre add(Genre genre);

    List<Book> getBookByGenre(Genre genre);
}
