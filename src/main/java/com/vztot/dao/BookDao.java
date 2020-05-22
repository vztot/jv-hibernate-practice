package com.vztot.dao;

import java.util.List;
import com.vztot.model.Book;

public interface BookDao {
    Book add(Book book);

    List<Book> getAll();
}
