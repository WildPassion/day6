package by.epam.dedik.day6.dao;

import by.epam.dedik.day6.entity.Book;
import by.epam.dedik.day6.service.SortType;

import java.util.List;

public interface BookListDao {
    boolean addBook(Book book);

    boolean removeBook(Book book);

    List<Book> findByName(String name);

    List<Book> findByAuthor(String author);

    List<Book> findByYear(int year);

    List<Book> findByNumberPages(int numberPages);

    List<Book> sortByTag(SortType sortType);
}
