package epam.dedik.day6.dao.impl;

import by.epam.dedik.day6.dao.impl.BookListDaoImpl;
import by.epam.dedik.day6.entity.Book;
import epam.dedik.day6.data.DataTransfer;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BookListDaoImplTest {
    private BookListDaoImpl bookListDao;

    @BeforeClass
    private void setBookListDao() {
        bookListDao = new BookListDaoImpl();
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
}
