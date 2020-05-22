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
import com.vztot.service.AuthorService;
import com.vztot.service.BookService;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Inject
    private AuthorDao authorDao;

    @Inject
    private BookDao bookDao;

    @Override
    public Author add(Author author) {
        return authorDao.add(author);
    }

    @Override
    public List<Author> getBookByAuthor(Author author) {
        return bookDao;
    }
}
