package by.epam.dedik.day6.dao.impl;

import by.epam.dedik.day6.dao.BookListDao;
import by.epam.dedik.day6.entity.Book;
import by.epam.dedik.day6.entity.Library;
import by.epam.dedik.day6.service.SortType;
import by.epam.dedik.day6.service.UniqueIdService;
import by.epam.dedik.day6.validator.BookValidator;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookListDaoImpl implements BookListDao {
    private BookValidator bookValidator = new BookValidator();

    @Override
    public boolean addBook(Book book) {
        boolean result = false;
        if (bookValidator.isValidBook(book)) {
            if (book.getName() == null) {
                book.setId(UniqueIdService.getId());
            }
            List<Book> books = Library.getInstance().getBooks();
            result = books.add(book);
        }
        return result;
    }

    @Override
    public boolean removeBook(Book book) {
        boolean result = false;
        if (book != null && book.getId() != 0) {
            List<Book> books = Library.getInstance().getBooks();
            result = books.remove(book);
        }
        return result;
    }

    @Override
    public List<Book> findByName(String name) {
        return Library.getInstance().getBooks().stream().
                filter(book -> book.getName().equals(name)).
                collect(Collectors.toList());
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return Library.getInstance().getBooks().stream().
                filter(book -> book.getAuthors().contains(author)).
                collect(Collectors.toList());
    }

    @Override
    public List<Book> findByYear(int year) {
        return Library.getInstance().getBooks().stream().
                filter(book -> book.getYear() == year).
                collect(Collectors.toList());
    }

    @Override
    public List<Book> findByNumberPages(int numberPages) {
        return Library.getInstance().getBooks().stream().
                filter(book -> book.getNumberPages() == numberPages).
                collect(Collectors.toList());
    }

    @Override
    public List<Book> sortByTag(SortType sortType) {
        return Library.getInstance().getBooks().stream()
                .sorted(sortType.getComparator())
                .collect(Collectors.toList());
    }
}
