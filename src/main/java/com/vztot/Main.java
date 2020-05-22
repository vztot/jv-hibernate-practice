package com.vztot;

import com.vztot.lib.Injector;
import com.vztot.model.Author;
import com.vztot.model.Book;
import com.vztot.model.Genre;
import com.vztot.service.AuthorService;
import com.vztot.service.BookService;
import com.vztot.service.GenreService;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final Injector INJECTOR = Injector.getInstance("com.vztot");
    private static GenreService genreService
            = (GenreService) INJECTOR.getInstance(GenreService.class);
    private static AuthorService authorService
            = (AuthorService) INJECTOR.getInstance(AuthorService.class);
    private static BookService bookService
            = (BookService) INJECTOR.getInstance(BookService.class);

    public static void main(String[] args) {
        Author adolfHitler = new Author();
        adolfHitler.setName("Adolf Hitler");
        authorService.add(adolfHitler);

        Genre historyGenre = new Genre();
        historyGenre.setGenre("History");
        genreService.add(historyGenre);

        Book meinKampfBook = new Book();
        meinKampfBook.setTitle("Mein Kampf");
        meinKampfBook.setGenre(historyGenre);
        List<Author> list = new ArrayList<>() {
            {
                add(adolfHitler);
            }
        };
        meinKampfBook.setAuthorList(list);
        bookService.add(meinKampfBook);

        System.out.println(bookService.getBookByTitle("Mein Kampf"));
        System.out.println(bookService.getBookByGenre(historyGenre));
        System.out.println(authorService.getBooksByAuthor(adolfHitler));
    }
}
