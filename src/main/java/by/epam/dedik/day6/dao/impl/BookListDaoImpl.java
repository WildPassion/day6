package by.epam.dedik.day6.dao.impl;

import by.epam.dedik.day6.service.UniqueIdService;
import by.epam.dedik.day6.validator.BookValidator;
import by.epam.dedik.day6.dao.BookListDao;
import by.epam.dedik.day6.entity.Book;
import by.epam.dedik.day6.entity.Library;

import java.util.List;

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
    public List<Book> findByName() {
        return null;
    }

    @Override
    public List<Book> findByAuthor() {
        return null;
    }

    @Override
    public List<Book> findByYear() {
        return null;
    }

    @Override
    public List<Book> findByNumberPages() {
        return null;
    }

    @Override
    public List<Book> sortByName() {
        return null;
    }

    @Override
    public List<Book> sortByAuthor() {
        return null;
    }

    @Override
    public List<Book> sortByYear() {
        return null;
    }

    @Override
    public List<Book> sortByNumberPages() {
        return null;
    }
}
