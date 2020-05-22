package com.vztot.dao;

import java.util.List;
import com.vztot.model.Genre;

public interface GenreDao {
    Genre add(Genre genre);

    List<Genre> getAll();
}
