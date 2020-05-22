package com.vztot.service.impl;

import com.vztot.dao.BookDao;
import com.vztot.dao.GenreDao;
import com.vztot.lib.Inject;
import com.vztot.lib.Service;
import com.vztot.model.Book;
import com.vztot.model.Genre;
import com.vztot.service.GenreService;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenreServiceImpl implements GenreService {
    @Inject
    private GenreDao genreDao;

    @Inject
    private BookDao bookDao;

    @Override
    public Genre add(Genre genre) {
        return genreDao.add(genre);
    }

    @Override
    public List<Book> getBookByGenre(Genre genre) {
        return bookDao.getAll().stream()
                .filter(book -> book.getGenre().equals(genre))
                .collect(Collectors.toList());
    }
}
