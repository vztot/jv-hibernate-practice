package com.vztot.service.impl;

import com.vztot.dao.AuthorDao;
import com.vztot.dao.BookDao;
import com.vztot.lib.Inject;
import com.vztot.lib.Service;
import com.vztot.model.Author;
import com.vztot.model.Book;
import com.vztot.service.AuthorService;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<Book> getBooksByAuthor(Author author) {
        return bookDao.getAll().stream()
                .filter(book -> book.getAuthorList().contains(author))
                .collect(Collectors.toList());
    }
}
