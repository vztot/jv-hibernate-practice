package com.vztot.dao;

import com.vztot.model.Author;
import java.util.List;

public interface AuthorDao {
    Author add(Author author);

    List<Author> getAll();
}
