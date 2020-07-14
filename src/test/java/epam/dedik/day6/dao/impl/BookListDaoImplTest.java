package epam.dedik.day6.dao.impl;

import by.epam.dedik.day6.dao.impl.BookListDaoImpl;
import by.epam.dedik.day6.entity.Book;
import by.epam.dedik.day6.entity.Library;
import by.epam.dedik.day6.service.SortType;
import epam.dedik.day6.data.DataTransfer;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class BookListDaoImplTest {
    private BookListDaoImpl bookListDao;

    @BeforeClass
    private void setBookListDao() {
        bookListDao = new BookListDaoImpl();
    }

    @AfterMethod
    private void removeFromLibrary() {
        Library.getInstance().getBooks().removeIf(Objects::nonNull);
    }

    @Test(dataProvider = "getValidBook", dataProviderClass = DataTransfer.class)
    public void addBook_validBook_true(Book book) {
        Assert.assertTrue(bookListDao.addBook(book));
    }

    @Test(dataProvider = "getInvalidBook", dataProviderClass = DataTransfer.class)
    public void addBook_invalidBook_false(Book book) {
        Assert.assertFalse(bookListDao.addBook(book));
    }

    @Test(dataProvider = "getValidBook", dataProviderClass = DataTransfer.class)
    public void removeBook_validBook_true(Book book) {
        bookListDao.addBook(book);
        Assert.assertTrue(bookListDao.removeBook(book));
    }

    @Test(dataProvider = "getInvalidBook", dataProviderClass = DataTransfer.class)
    public void removeBook_invalidBook_false(Book book) {
        bookListDao.addBook(book);
        Assert.assertFalse(bookListDao.removeBook(book));
    }

    @Test(dataProvider = "getValidBook", dataProviderClass = DataTransfer.class)
    public void findByName_existingBook_true(Book book) {
        bookListDao.addBook(book);
        List<Book> found = bookListDao.findByName(book.getName());
        Assert.assertTrue(found.contains(book));
    }

    @Test(dataProvider = "getValidBook", dataProviderClass = DataTransfer.class)
    public void findByName_nonexistentBook_false(Book book) {
        bookListDao.addBook(book);
        List<Book> found = bookListDao.findByName("qwe");
        Assert.assertFalse(found.contains(book));
    }

    @Test(dataProvider = "getValidBook", dataProviderClass = DataTransfer.class)
    public void findByAuthor_existingBook_true(Book book) {
        bookListDao.addBook(book);
        List<Book> found = bookListDao.findByAuthor(book.getAuthors().get(0));
        Assert.assertTrue(found.contains(book));
    }

    @Test(dataProvider = "getValidBook", dataProviderClass = DataTransfer.class)
    public void findByAuthor_nonexistentBook_false(Book book) {
        bookListDao.addBook(book);
        List<Book> found = bookListDao.findByAuthor("qwe");
        Assert.assertFalse(found.contains(book));
    }

    @Test(dataProvider = "getValidBook", dataProviderClass = DataTransfer.class)
    public void findByYear_existingBook_true(Book book) {
        bookListDao.addBook(book);
        List<Book> found = bookListDao.findByYear(book.getYear());
        Assert.assertTrue(found.contains(book));
    }

    @Test(dataProvider = "getValidBook", dataProviderClass = DataTransfer.class)
    public void findByYear_nonexistentBook_false(Book book) {
        bookListDao.addBook(book);
        List<Book> found = bookListDao.findByYear(0);
        Assert.assertFalse(found.contains(book));
    }

    @Test(dataProvider = "getValidBook", dataProviderClass = DataTransfer.class)
    public void findByNumberPages_existingBook_true(Book book) {
        bookListDao.addBook(book);
        List<Book> found = bookListDao.findByNumberPages(book.getNumberPages());
        Assert.assertTrue(found.contains(book));
    }

    @Test(dataProvider = "getValidBook", dataProviderClass = DataTransfer.class)
    public void findByNumberPages_nonexistentBook_false(Book book) {
        bookListDao.addBook(book);
        List<Book> found = bookListDao.findByNumberPages(0);
        Assert.assertFalse(found.contains(book));
    }

    @Test(dataProvider = "getBooks", dataProviderClass = DataTransfer.class)
    public void sortByName_books_sortedBooks(List<Book> books) {
        books.forEach(book -> bookListDao.addBook(book));
        List<Book> actual = bookListDao.sortByTag(SortType.NAME);
        List<Book> expected = Arrays.asList(
                new Book("Book1", Arrays.asList("Author21", "Author22"), 2003, 400),
                new Book("Book2", Arrays.asList("Author31", "Author32"), 2004, 500),
                new Book("Book3", Arrays.asList("Author41", "Author42"), 2001, 200),
                new Book("Book4", Arrays.asList("Author51", "Author52"), 2005, 100),
                new Book("Book5", Arrays.asList("Author11", "Author12"), 2002, 300));
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "getBooks", dataProviderClass = DataTransfer.class)
    public void sortByAuthor_books_sortedBooks(List<Book> books) {
        books.forEach(book -> bookListDao.addBook(book));
        List<Book> actual = bookListDao.sortByTag(SortType.AUTHOR);
        List<Book> expected = Arrays.asList(
                new Book("Book5", Arrays.asList("Author11", "Author12"), 2002, 300),
                new Book("Book1", Arrays.asList("Author21", "Author22"), 2003, 400),
                new Book("Book2", Arrays.asList("Author31", "Author32"), 2004, 500),
                new Book("Book3", Arrays.asList("Author41", "Author42"), 2001, 200),
                new Book("Book4", Arrays.asList("Author51", "Author52"), 2005, 100));
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "getBooks", dataProviderClass = DataTransfer.class)
    public void sortByYear_books_sortedBooks(List<Book> books) {
        books.forEach(book -> bookListDao.addBook(book));
        List<Book> actual = bookListDao.sortByTag(SortType.YEAR);
        List<Book> expected = Arrays.asList(
                new Book("Book3", Arrays.asList("Author41", "Author42"), 2001, 200),
                new Book("Book5", Arrays.asList("Author11", "Author12"), 2002, 300),
                new Book("Book1", Arrays.asList("Author21", "Author22"), 2003, 400),
                new Book("Book2", Arrays.asList("Author31", "Author32"), 2004, 500),
                new Book("Book4", Arrays.asList("Author51", "Author52"), 2005, 100));
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "getBooks", dataProviderClass = DataTransfer.class)
    public void sortByNumberPages_books_sortedBooks(List<Book> books) {
        books.forEach(book -> bookListDao.addBook(book));
        List<Book> actual = bookListDao.sortByTag(SortType.NUMBER_PAGES);
        List<Book> expected = Arrays.asList(
                new Book("Book4", Arrays.asList("Author51", "Author52"), 2005, 100),
                new Book("Book3", Arrays.asList("Author41", "Author42"), 2001, 200),
                new Book("Book5", Arrays.asList("Author11", "Author12"), 2002, 300),
                new Book("Book1", Arrays.asList("Author21", "Author22"), 2003, 400),
                new Book("Book2", Arrays.asList("Author31", "Author32"), 2004, 500));
        Assert.assertEquals(actual, expected);
    }
}
