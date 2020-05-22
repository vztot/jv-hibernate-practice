package com.vztot.service.impl;

import com.vztot.dao.BookDao;
import com.vztot.lib.Inject;
import com.vztot.lib.Service;
import com.vztot.model.Book;
import com.vztot.model.Genre;
import com.vztot.service.BookService;

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
        return bookDao.getAll().stream()
                .filter(book -> book.getTitle().equals(title)).findFirst()
                .get();
    }

    @Override
    public Book getBookByGenre(Genre genre) {
        return bookDao.getAll().stream()
                .filter(book -> book.getGenre().equals(genre)).findFirst()
                .get();
    }
}
