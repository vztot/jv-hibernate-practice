package com.vztot.service;

import com.vztot.model.Author;
import java.util.List;

public interface AuthorService {
    Author add(Author author);

    List<Author> getBookByAuthor(Author author);
}
