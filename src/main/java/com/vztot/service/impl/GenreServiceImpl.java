package com.vztot.service.impl;

import com.vztot.dao.BookDao;
import com.vztot.dao.GenreDao;
import com.vztot.lib.Inject;
import com.vztot.lib.Service;
import com.vztot.model.Genre;
import com.vztot.service.GenreService;

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
}
