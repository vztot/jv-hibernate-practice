package com.vztot;

import com.vztot.lib.Injector;
import com.vztot.model.Genre;
import com.vztot.service.AuthorService;
import com.vztot.service.BookService;
import com.vztot.service.GenreService;

public class Main {
    private static final Injector INJECTOR = Injector.getInstance("com.vztot");
    private static GenreService genreService
            = (GenreService) INJECTOR.getInstance(GenreService.class);
    private static AuthorService authorService
            = (AuthorService) INJECTOR.getInstance(AuthorService.class);
    private static BookService bookService
            = (BookService) INJECTOR.getInstance(BookService.class);

    public static void main(String[] args) {
        Genre drama = new Genre();
        drama.setGenre("Drama");
        genreService.add(drama);
    }
}
