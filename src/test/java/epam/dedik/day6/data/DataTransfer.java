package epam.dedik.day6.data;

import by.epam.dedik.day6.entity.Book;
import org.testng.annotations.DataProvider;

import java.util.Arrays;

public class DataTransfer {
    @DataProvider
    public Object[][] getBooks() {
        return new Object[][]{{Arrays.asList(
                new Book("Book1", Arrays.asList("Author21", "Author22"), 2003, 400),
                new Book("Book2", Arrays.asList("Author31", "Author32"), 2004, 500),
                new Book("Book3", Arrays.asList("Author41", "Author42"), 2001, 200),
                new Book("Book4", Arrays.asList("Author51", "Author52"), 2005, 100),
                new Book("Book5", Arrays.asList("Author11", "Author12"), 2002, 300))
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
