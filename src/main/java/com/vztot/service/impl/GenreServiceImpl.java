package com.vztot.service.impl;

import java.util.List;
import com.vztot.dao.AuthorDao;
import com.vztot.dao.BookDao;
import com.vztot.dao.GenreDao;
import com.vztot.lib.Inject;
import com.vztot.lib.Service;
import com.vztot.model.Author;
import com.vztot.model.Book;
import com.vztot.model.Genre;
import com.vztot.service.BookService;

@Service
public class GenreServiceImpl implements BookService {
    @Inject
    private BookDao bookDao;
    @Inject
    private AuthorDao authorDao;
    @Inject
    private GenreDao genreDao;

    @Override
    public Book getBookByTitle(String title) {
        return bookDao.getAll().stream()
                .filter(book -> book.getTitle().equals(title)).findFirst()
                .get();
    }

    @Override
    public List<Author> getBookByTitle(Author author) {
        return null;
    }

    @Override
    public List<Genre> getBookByTitle(Genre genre) {
        return null;
    }
}
