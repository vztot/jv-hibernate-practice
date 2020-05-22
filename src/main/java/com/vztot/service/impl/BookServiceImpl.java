package com.vztot.service.impl;

import com.vztot.dao.BookDao;
import com.vztot.lib.Inject;
import com.vztot.lib.Service;
import com.vztot.model.Author;
import com.vztot.model.Book;
import com.vztot.model.Genre;
import com.vztot.service.BookService;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Inject
    private BookDao bookDao;

    @Override
    public Book add(Book book) {
        return bookDao.add(book);
    }

    @Override
    public Book getBookByTitle(String title) {
        return bookDao.getBookByTitle(title);
    }

    @Override
    public List<Book> getBooksByAuthor(Author author) {
        return bookDao.getBooksByAuthor(author);
    }

    @Override
    public List<Book> getBooksByGenre(Genre genre) {
        return bookDao.getBooksByGenre(genre);
    }
}
