package epam.dedik.day6.data;

import by.epam.dedik.day6.entity.Book;
import org.testng.annotations.DataProvider;

import java.util.Arrays;

public class DataTransfer {
    @DataProvider
    public Object[][] getBooks() {
        return new Object[][]{{
                new Book("Book1", Arrays.asList("Author1", "Author2"), 1999, 700),
                new Book("Book2", Arrays.asList("Author21", "Author22"), 2000, 800)
        }};
    }

    @DataProvider
    public Object[][] getValidBook() {
        return new Object[][]{{
                new Book("Book1", Arrays.asList("Author1", "Author2"), 1999, 700),
        }};
    }

    @DataProvider
    public Object[][] getInvalidBook() {
        return new Object[][]{{
                new Book("", Arrays.asList("Author1", "Author2"), 1999, 700),
        }};
    }
}
