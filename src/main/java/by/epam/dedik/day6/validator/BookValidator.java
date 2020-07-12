package by.epam.dedik.day6.validator;

import by.epam.dedik.day6.entity.Book;

import java.time.LocalDate;

public class BookValidator {
    private static final int FIRST_BOOK = -600;
    public static final String EMPTY_NAME = "";

    public boolean isValidBook(Book book) {
        if (book != null) {
            return book.getName() != null && !book.getName().equals(EMPTY_NAME) && book.getAuthors() != null &&
                    book.getYear() > FIRST_BOOK && book.getYear() < LocalDate.now().getYear() &&
                    book.getNumberPages() != 0;
        }
        return false;
    }
}
