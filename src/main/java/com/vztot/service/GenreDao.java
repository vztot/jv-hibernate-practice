package com.vztot.service;

import com.vztot.model.Genre;
import java.util.List;

public interface GenreDao {
    Genre add(Genre genre);

    List<Genre> getBookByGenre(Genre genre);
}
