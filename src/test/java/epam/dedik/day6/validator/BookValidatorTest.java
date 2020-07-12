package epam.dedik.day6.validator;

import by.epam.dedik.day6.entity.Book;
import by.epam.dedik.day6.validator.BookValidator;
import epam.dedik.day6.data.DataTransfer;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BookValidatorTest {
    private BookValidator validator;

    @BeforeClass
    private void setValidator() {
        validator = new BookValidator();
    }

    @Test(dataProvider = "getValidBook", dataProviderClass = DataTransfer.class)
    public void isValidBook_validBook_true(Book book) {
        Assert.assertTrue(validator.isValidBook(book));
    }

    @Test(dataProvider = "getInvalidBook", dataProviderClass = DataTransfer.class)
    public void isValidBook_invalidBook_false(Book book) {
        Assert.assertFalse(validator.isValidBook(book));
    }
}
