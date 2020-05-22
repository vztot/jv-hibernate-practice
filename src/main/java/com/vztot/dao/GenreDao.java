package com.vztot.dao;

import com.vztot.model.Genre;
import java.util.List;

public interface GenreDao {
    Genre add(Genre genre);

    List<Genre> getAll();
}
