package com.vztot.dao;

import java.util.List;
import com.vztot.model.Author;

public interface AuthorDao {
    Author add(Author author);

    List<Author> getAll();
}
