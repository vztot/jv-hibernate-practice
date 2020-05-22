package com.vztot;

import com.vztot.lib.Injector;
import com.vztot.model.Author;
import com.vztot.model.Book;
import com.vztot.model.Genre;
import com.vztot.service.AuthorService;
import com.vztot.service.BookService;
import com.vztot.service.GenreService;
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
        Author authorOne = new Author();
        Author authorTwo = new Author();
        Author authorThree = new Author();

        authorOne.setName("Author One");
        authorTwo.setName("Author Two");
        authorThree.setName("Author Three");

        authorService.add(authorOne);
        authorService.add(authorTwo);
        authorService.add(authorThree);

        Genre historyGenre = new Genre();
        Genre dramaGenre = new Genre();
        historyGenre.setGenre("history");
        dramaGenre.setGenre("drama");
        genreService.add(historyGenre);
        genreService.add(dramaGenre);

        Book bookOfOne = new Book();
        Book bookOfTwo = new Book();
        Book bookOfDrama = new Book();
        bookOfOne.setTitle("Book of One");
        bookOfTwo.setTitle("Book of Two");
        bookOfDrama.setTitle("Book of Drama");

        bookOfOne.setGenre(historyGenre);
        bookOfTwo.setGenre(historyGenre);
        bookOfDrama.setGenre(dramaGenre);

        List<Author> authorsOne = List.of(authorOne);
        List<Author> authorsTwo = List.of(authorOne, authorTwo);
        List<Author> authorsDrama = List.of(authorOne, authorTwo, authorThree);

        bookOfOne.setAuthorList(authorsOne);
        bookOfTwo.setAuthorList(authorsTwo);
        bookOfDrama.setAuthorList(authorsDrama);
        bookService.add(bookOfOne);
        bookService.add(bookOfTwo);
        bookService.add(bookOfDrama);

        System.out.println("Get book by Title: Book of One");
        System.out.println(bookService.getBookByTitle("Book of One"));

        System.out.println("\nGet all books by Author: Author One");
        bookService.getBooksByAuthor(authorOne).forEach(System.out::println);

        System.out.println("\nGet all books by Genre: History");
        bookService.getBooksByGenre(historyGenre).forEach(System.out::println);

        System.out.println("\nGet all books by Genre: Drama");
        bookService.getBooksByGenre(dramaGenre).forEach(System.out::println);
    }
}
