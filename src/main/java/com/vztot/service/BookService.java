package com.vztot.service;

import com.vztot.model.Book;

public interface BookService {
    Book add(Book book);

    Book getBookByTitle(String title);
}
