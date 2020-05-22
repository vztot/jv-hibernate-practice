package com.vztot.dao;

import com.vztot.model.Book;
import java.util.List;

public interface BookDao {
    Book add(Book book);

    List<Book> getAll();
}
