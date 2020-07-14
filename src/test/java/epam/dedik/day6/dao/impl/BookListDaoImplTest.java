package epam.dedik.day6.dao.impl;

import by.epam.dedik.day6.dao.impl.BookListDaoImpl;
import by.epam.dedik.day6.entity.Book;
import by.epam.dedik.day6.entity.Library;
import epam.dedik.day6.data.DataTransfer;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
}
