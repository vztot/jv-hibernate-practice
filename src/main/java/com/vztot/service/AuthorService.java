package com.vztot.service;

import com.vztot.model.Author;
import com.vztot.model.Book;
import java.util.List;

public interface AuthorService {
    Author add(Author author);

    List<Book> getBooksByAuthor(Author author);
}
