package by.epam.dedik.day6.dao;

import by.epam.dedik.day6.entity.Book;

import java.util.List;

public interface BookListDao {
    boolean addBook(Book book);

    boolean removeBook(Book book);

    List<Book> findByName(String name);

    List<Book> findByAuthor(String author);

    List<Book> findByYear(int year);

    List<Book> findByNumberPages(int numberPages);

    List<Book> sortByName();

    List<Book> sortByAuthor();

    List<Book> sortByYear();

    List<Book> sortByNumberPages();
}
